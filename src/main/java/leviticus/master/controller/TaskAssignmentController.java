package leviticus.master.controller;

import leviticus.master.dto.trainRequest.TrainLBPRequestDto;
import leviticus.master.dto.trainRequest.TrainMiniVGGRequestDto;
import leviticus.master.dto.trainResponse.TrainLBPResponseDto;
import leviticus.master.dto.trainResponse.TrainMiniVGGResponseDto;
import leviticus.master.entity.taskEntity.TrainTaskEntity;
import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;
import leviticus.master.model.TrainLBPRequestFormModel;
import leviticus.master.model.TrainMiniVGGRequestFormModel;
import leviticus.master.service.ModelParamsEntityService;
import leviticus.master.service.OptimizerParamsEntityService;
import leviticus.master.service.PredictTaskEntityService;
import leviticus.master.service.TrainTaskEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "/jobs")
public class TaskAssignmentController {

    private static final Logger LOG = LoggerFactory.getLogger(TaskAssignmentController.class);

    @Autowired
    private ModelParamsEntityService modelService;

    @Autowired
    private OptimizerParamsEntityService optimizerService;

    @Autowired
    private PredictTaskEntityService predictService;

    @Autowired
    private TrainTaskEntityService trainService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private Map<ClassificationModelType, Integer> router;

    @PostMapping(value = "/submitSelectionLBP")
    public String submitForm(TrainLBPRequestFormModel trainRequestFormModel, Model model) {
        LOG.info("entered into submitSelectionLBP API");
        ClassificationModelType modelType = trainRequestFormModel.getModelType();
        OptimizerType optimizerType = trainRequestFormModel.getOptimizerType();
        String dataset = trainRequestFormModel.getDataset();
        Boolean isTrainOnly = trainRequestFormModel.getIsTrainOnly();
        Boolean isCrossValidated = trainRequestFormModel.getIsCrossValidated();
        Integer numPoints = trainRequestFormModel.getNumPoints();
        Integer radius = trainRequestFormModel.getRadius();
        Double cValue = trainRequestFormModel.getC();
        LOG.info("C value is " + cValue);

        Date date = new Date();
        TrainTaskEntity trainEntity = new TrainTaskEntity(
                modelType,
                optimizerType,
                null,
                isCrossValidated,
                isTrainOnly,
                null,
                null,
                0.0,
                false,
                dataset,
                new Timestamp(date.getTime())
        );

        TrainTaskEntity savedEntity = trainService.save(trainEntity);
        Long trainId = savedEntity.getId();

        TrainLBPRequestDto trainLBPRequestDto = new TrainLBPRequestDto(
                trainId,
                isTrainOnly,
                dataset,
                numPoints,
                radius,
                cValue
        );

        Class<TrainLBPResponseDto> trainResponseDtoClass = TrainLBPResponseDto.class;

        StopWatch watch = new StopWatch();
        watch.start();

        String baseUrl = "http://fastapi-" + modelType.toString().toLowerCase() + ":" + router.get(modelType);
        String endpoint = "/train";
        WebClient webClient = webClientBuilder.baseUrl(baseUrl).build();
        webClient.post()
                .uri(endpoint)
                .body(Mono.just(trainLBPRequestDto), trainLBPRequestDto.getClass())
                .retrieve()
                .bodyToMono(trainResponseDtoClass)
                .subscribe(trainResponse -> {
                    watch.stop();
                    TrainTaskEntity updatedEntity = trainService.getTrainTaskEntityById(trainId);
                    updatedEntity.setComplete(true);
                    updatedEntity.setWeightsFile(trainResponse.getModelPath());
                    updatedEntity.setAccuracy(trainResponse.getAccuracy());
                    updatedEntity.setClassificationReport(trainResponse.getClassificationReport());
                    updatedEntity.setTimeElapsed(watch.getTotalTimeSeconds());
                    updatedEntity.setLchgTime(new Timestamp(date.getTime()));
                });


        LOG.info("API request done");
        return "redirect:/templates";
    }


    @PostMapping(value = "/submitSelectionMiniVGG")
    public String submitForm(TrainMiniVGGRequestFormModel trainRequestFormModel, Model model) {
        LOG.info("entered into submitSelectionMiniVGG API");
        ClassificationModelType modelType = trainRequestFormModel.getModelType();
        OptimizerType optimizerType = trainRequestFormModel.getOptimizerType();
        String dataset = trainRequestFormModel.getDataset();
        Boolean isTrainOnly = trainRequestFormModel.getIsTrainOnly();
        Boolean isCrossValidated = trainRequestFormModel.getIsCrossValidated();

        Date date = new Date();
        TrainTaskEntity trainEntity = new TrainTaskEntity(
                modelType,
                optimizerType,
                null,
                isCrossValidated,
                isTrainOnly,
                null,
                null,
                0.0,
                false,
                dataset,
                new Timestamp(date.getTime())
            );

        TrainTaskEntity savedEntity = trainService.save(trainEntity);
        Long trainId = savedEntity.getId();

        TrainMiniVGGRequestDto trainRequestDto = new TrainMiniVGGRequestDto(
                trainId,
                isTrainOnly,
                dataset
        );

        Class<TrainMiniVGGResponseDto> trainResponseDtoClass = TrainMiniVGGResponseDto.class;

        StopWatch watch = new StopWatch();
        watch.start();

        String baseUrl = "http://fastapi-" + modelType.toString().toLowerCase() + ":" + router.get(modelType);
        String endpoint = "/train";
        WebClient webClient = webClientBuilder.baseUrl(baseUrl).build();
        webClient.post()
                .uri(endpoint)
                .body(Mono.just(trainRequestDto), trainRequestDto.getClass())
                .retrieve()
                .bodyToMono(trainResponseDtoClass)
                .subscribe(trainResponse -> {
                    watch.stop();
                    TrainTaskEntity updatedEntity = trainService.getTrainTaskEntityById(trainId);
                    updatedEntity.setWeightsFile(trainResponse.getModelPath());
                    updatedEntity.setAccuracy(trainResponse.getAccuracy());
                    updatedEntity.setClassificationReport(trainResponse.getClassificationReport());
                    updatedEntity.setTimeElapsed(watch.getTotalTimeSeconds());
                    updatedEntity.setLchgTime(new Timestamp(date.getTime()));
                });


        LOG.info("API request done");
        return "redirect:/templates";

    }
}
