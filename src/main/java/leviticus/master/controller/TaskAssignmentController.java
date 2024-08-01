package leviticus.master.controller;

import leviticus.master.dto.predictRequest.PredictLBPRequestDto;
import leviticus.master.dto.predictRequest.PredictMiniVGGRequestDto;
import leviticus.master.dto.predictRequest.PredictRequestDto;
import leviticus.master.dto.predictResponse.PredictResponseDto;
import leviticus.master.dto.trainRequest.TrainLBPRequestDto;
import leviticus.master.dto.trainRequest.TrainMiniVGGRequestDto;
import leviticus.master.dto.trainResponse.TrainLBPResponseDto;
import leviticus.master.dto.trainResponse.TrainMiniVGGResponseDto;
import leviticus.master.entity.modelParamsEntity.CNNModelParamsEntity;
import leviticus.master.entity.modelParamsEntity.LBPModelParamsEntity;
import leviticus.master.entity.taskEntity.PredictTaskEntity;
import leviticus.master.entity.taskEntity.TrainTaskEntity;
import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;
import leviticus.master.model.predict.PredictRequestFormModel;
import leviticus.master.model.train.TrainLBPRequestFormModel;
import leviticus.master.model.train.TrainMiniVGGRequestFormModel;
import leviticus.master.service.modelParamsService.CNNModelParamsEntityService;
import leviticus.master.service.modelParamsService.LBPModelParamsEntityService;
import leviticus.master.service.OptimizerParamsEntityService;
import leviticus.master.service.taskService.PredictTaskEntityService;
import leviticus.master.service.taskService.TrainTaskEntityService;
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
import java.util.Map;

@Controller
@RequestMapping(value = "/jobs")
public class TaskAssignmentController {

    private static final Logger LOG = LoggerFactory.getLogger(TaskAssignmentController.class);

    @Autowired
    private LBPModelParamsEntityService lbpModelParamsService;

    @Autowired
    private CNNModelParamsEntityService cnnModelParamsService;

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

    @PostMapping(value = "/predict")
    public String predict(PredictRequestFormModel predictRequestFormModel, Model model) {
        LOG.info("entered into predict API");
        Long trainId = predictRequestFormModel.getTrainId();
        String predictDataset = predictRequestFormModel.getDataset();

        TrainTaskEntity trainTaskEntity = trainService.findById(trainId);
        ClassificationModelType modelType = trainTaskEntity.getModelType();
        String trainDataset = trainTaskEntity.getDataset();
        String weightsFile = trainTaskEntity.getWeightsFile();

        if (!trainTaskEntity.isComplete()) {
            throw new IllegalStateException("This Training task is not complete and cannot be used for prediction");
        }

        PredictTaskEntity predictTaskEntity = new PredictTaskEntity();
        predictTaskEntity.setTrainId(trainId);
        predictTaskEntity.setDataset(predictDataset);
        predictTaskEntity.setModelType(modelType);

        PredictTaskEntity savedEntity = predictService.save(predictTaskEntity);
        Long predictId = savedEntity.getId();

        PredictRequestDto predictRequestDto;
        if (modelType.equals(ClassificationModelType.LBP)) {
            LBPModelParamsEntity lbpModelParamsEntity = lbpModelParamsService.findByTrainId(trainId);
            Integer numPoints = lbpModelParamsEntity.getNumPoints();
            Integer radius = lbpModelParamsEntity.getRadius();
            predictRequestDto = new PredictLBPRequestDto(
                    trainId, trainDataset, predictDataset, weightsFile, numPoints, radius
            );
        } else if (modelType.equals(ClassificationModelType.MINIVGG)) {
            CNNModelParamsEntity cnnModelParamsEntity = cnnModelParamsService.findByTrainId(trainId);
            predictRequestDto = new PredictMiniVGGRequestDto(trainId, trainDataset, predictDataset, weightsFile);
        } else {
            throw new IllegalStateException("invalid classification model type");
        }

        String baseUrl = "http://fastapi-" + modelType.toString().toLowerCase() + ":" + router.get(modelType);
        String endpoint = "/predict";

        StopWatch watch = new StopWatch();
        watch.start();

        WebClient webClient = webClientBuilder.baseUrl(baseUrl).build();
        webClient.post()
                .uri(endpoint)
                .body(Mono.just(predictRequestDto), predictRequestDto.getClass())
                .retrieve()
                .bodyToMono(PredictResponseDto.class)
                .subscribe(predictResponse -> {
                    watch.stop();
                    LOG.info("API Response received");
                    PredictTaskEntity updatedEntity = predictService.findById(predictId);
                    updatedEntity.setComplete(true);
                    updatedEntity.setTimeElapsed(watch.getTotalTimeSeconds());
                    updatedEntity.setLchgTime(new Timestamp(System.currentTimeMillis()));
                    updatedEntity.setAccuracy(predictResponse.getAccuracy());
                    updatedEntity.setClassificationReport(predictResponse.getClassificationReport());
                    updatedEntity.setPredictions(predictResponse.getPredictions());
                    predictService.save(updatedEntity);
                });


        return "redirect:/templates";
    }

    @PostMapping(value = "/trainLBP")
    public String submitForm(TrainLBPRequestFormModel trainRequestFormModel, Model model) {
        LOG.info("entered into submitSelectionLBP API");
        ClassificationModelType modelType = trainRequestFormModel.getModelType();
        String dataset = trainRequestFormModel.getDataset();
        Boolean isTrainOnly = trainRequestFormModel.getIsTrainOnly();
        Integer numPoints = trainRequestFormModel.getNumPoints();
        Integer radius = trainRequestFormModel.getRadius();
        Double cValue = trainRequestFormModel.getC();

        TrainTaskEntity trainEntity = new TrainTaskEntity(modelType);
        trainEntity.setDataset(dataset);
        trainEntity.setTrainOnly(isTrainOnly);

        TrainTaskEntity savedTaskEntity = trainService.save(trainEntity);
        Long trainId = savedTaskEntity.getId();

        LBPModelParamsEntity modelEntity = new LBPModelParamsEntity(trainId);
        modelEntity.setcValue(cValue);
        modelEntity.setNumPoints(numPoints);
        modelEntity.setRadius(radius);

        lbpModelParamsService.save(modelEntity);

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
                    TrainTaskEntity updatedEntity = trainService.findById(trainId);
                    updatedEntity.setComplete(true);
                    updatedEntity.setWeightsFile(trainResponse.getModelPath());
                    updatedEntity.setAccuracy(trainResponse.getAccuracy());
                    updatedEntity.setClassificationReport(trainResponse.getClassificationReport());
                    updatedEntity.setTimeElapsed(watch.getTotalTimeSeconds());
                    updatedEntity.setLchgTime(new Timestamp(System.currentTimeMillis()));
                    trainService.save(updatedEntity);
                });


        LOG.info("API request done");
        return "redirect:/templates";
    }


    @PostMapping(value = "/trainMiniVGG")
    public String submitForm(TrainMiniVGGRequestFormModel trainRequestFormModel, Model model) {
        LOG.info("entered into submitSelectionMiniVGG API");
        ClassificationModelType modelType = trainRequestFormModel.getModelType();
        String dataset = trainRequestFormModel.getDataset();
        Boolean isTrainOnly = trainRequestFormModel.getIsTrainOnly();
        OptimizerType optimizerType = trainRequestFormModel.getOptimizerType();

        TrainTaskEntity trainEntity = new TrainTaskEntity(modelType);
        trainEntity.setDataset(dataset);
        trainEntity.setTrainOnly(isTrainOnly);
        trainEntity.setOptimizerType(optimizerType);

        TrainTaskEntity savedEntity = trainService.save(trainEntity);
        Long trainId = savedEntity.getId();

        CNNModelParamsEntity paramsEntity = new CNNModelParamsEntity(trainId);
        paramsEntity.setBatchSize(32);
        paramsEntity.setEpochs(2);
        paramsEntity.setNumClasses(3);
        paramsEntity.setResizedX(128);
        paramsEntity.setResizedY(128);
        cnnModelParamsService.save(paramsEntity);

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
                    LOG.info("API Response received");
                    TrainTaskEntity updatedEntity = trainService.findById(trainId);
                    updatedEntity.setComplete(true);
                    updatedEntity.setWeightsFile(trainResponse.getModelPath());
                    updatedEntity.setAccuracy(trainResponse.getAccuracy());
                    updatedEntity.setClassificationReport(trainResponse.getClassificationReport());
                    updatedEntity.setTimeElapsed(watch.getTotalTimeSeconds());
                    updatedEntity.setLchgTime(new Timestamp(System.currentTimeMillis()));
                    trainService.save(updatedEntity);
                });


        LOG.info("API request done");
        return "redirect:/templates";

    }
}
