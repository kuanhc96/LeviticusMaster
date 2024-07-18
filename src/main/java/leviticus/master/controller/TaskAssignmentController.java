package leviticus.master.controller;

import jakarta.annotation.PostConstruct;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
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

    private Map<ClassificationModelType, Integer> router;

    @PostConstruct
    public void setup() {
        router = new HashMap<>();
        router.put(ClassificationModelType.LBP, 8000);
        router.put(ClassificationModelType.MINI_VGG, 8001);

    }

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
        String baseUrl = "http://fastapi-lbp:" + router.get(modelType);
        String endpoint = "/train";
        WebClient webClient = webClientBuilder.baseUrl(baseUrl).build();
        Mono<String> trainResponse = webClient.post()
                .uri(endpoint)
                .body(Mono.just(trainLBPDto), TrainLBPDto.class)
                .retrieve()
                .bodyToMono(String.class);

        LOG.info(trainResponse.block());

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<Object> request = new HttpEntity<>(jsonData, headers);
//        ResponseEntity<String> response =
//
//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create())
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
//                .build();
//        LOG.info("prepared API request");
//        try {
//            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            System.out.println("Response Code: " + response.statusCode());
//            System.out.println("Response Body: " + response.body());
//        } catch (InterruptedException | IOException e) {
//            e.printStackTrace();
//        }
//        LOG.info("API request done");
        return "redirect:/templates";

    }
}
