package leviticus.master.controller;

import leviticus.master.dto.TrainLBPDto;
import leviticus.master.entity.taskEntity.TrainTaskEntity;
import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;
import leviticus.master.model.TrainRequestFormModel;
import leviticus.master.service.ModelParamsEntityService;
import leviticus.master.service.OptimizerParamsEntityService;
import leviticus.master.service.PredictTaskEntityService;
import leviticus.master.service.TrainTaskEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

    @PostMapping(value = "/submitSelection")
    public String submitForm(TrainRequestFormModel trainRequestFormModel, Model model) {
        LOG.info("entered into submitSelection API");
        ClassificationModelType modelType = trainRequestFormModel.getModelType();
        OptimizerType optimizerType = trainRequestFormModel.getOptimizerType();
        String dataset = trainRequestFormModel.getDataset();
        Boolean isTrainOnly = trainRequestFormModel.getIsTrainOnly();
        Boolean isCrossValidated = trainRequestFormModel.getIsCrossValidated();

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
                dataset
            );

        TrainTaskEntity savedEntity = trainService.save(trainEntity);
        Long trainId = savedEntity.getId();

        TrainLBPDto trainLBPDto = new TrainLBPDto(
                trainId,
                isTrainOnly,
                dataset,
                24,
                8,
                89.0
        );
        String baseUrl = "http://fastapi-" + modelType + ":" + router.get(modelType);
        String endpoint = "/train";
        WebClient webClient = webClientBuilder.baseUrl(baseUrl).build();
        Mono<String> trainResponse = webClient.post()
                .uri(endpoint)
                .body(Mono.just(trainLBPDto), TrainLBPDto.class)
                .retrieve()
                .bodyToMono(String.class);

        LOG.info(trainResponse.block());

        LOG.info("API request done");
        return "redirect:/templates";

    }
}
