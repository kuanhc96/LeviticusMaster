package leviticus.master.controller;

import jakarta.annotation.PostConstruct;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

    private Map<ClassificationModelType, Integer> router;

    @PostConstruct
    public void setup() {
        router = new HashMap<>();
        router.put(ClassificationModelType.LBP, 8000);
        router.put(ClassificationModelType.MINI_VGG, 8001);

    }


    @GetMapping
    public String getJobs() {
        return "landing";
    }

    @GetMapping(value = "/train")
    public String getForm(Model model) {
        model.addAttribute("selectionForm", new TrainRequestFormModel());

        return "train";
    }

    @PostMapping(value = "/submitSelection")
    public String submitForm(TrainRequestFormModel selectionForm, Model model) {
        LOG.info("entered into submitSelection API");
        ClassificationModelType modelType = selectionForm.getModelType();
        OptimizerType optimizerType = selectionForm.getOptimizerType();
        String dataset = selectionForm.getDataset();
        Boolean isTrainOnly = selectionForm.getTrainOnly();
        Boolean isCrossValidated = selectionForm.getCrossValidated();

        TrainTaskEntity trainEntity = new TrainTaskEntity(
                modelType,
                optimizerType,
                null,
                dataset,
                false,
                isCrossValidated,
                isTrainOnly
            );

        TrainTaskEntity savedEntity = trainService.save(trainEntity);
        Long trainId = savedEntity.getId();

        String jsonData = "" +
                "{" +
                "\"taskId\":\"" + trainId + "\"," +
                "\"trainOnly\":\"" + isTrainOnly + "\"," +
                "\"dataset\":\"" + dataset + "\"," +
                "\"numPoints\":24," +
                "\"radius\":8," +
                "\"C\":89.0" +
                "}";

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:" + router.get(modelType) + "/train"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();
        LOG.info("prepared API request");
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.info("API request done");
        return "redirect:/jobs";

    }
}
