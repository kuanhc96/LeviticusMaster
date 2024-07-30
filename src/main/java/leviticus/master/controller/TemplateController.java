package leviticus.master.controller;

import leviticus.master.entity.modelParamsEntity.CNNModelParamsEntity;
import leviticus.master.entity.modelParamsEntity.LBPModelParamsEntity;
import leviticus.master.entity.taskEntity.TrainTaskEntity;
import leviticus.master.model.predict.PredictRequestFormModel;
import leviticus.master.model.train.TrainLBPRequestFormModel;
import leviticus.master.model.train.TrainMiniVGGRequestFormModel;
import leviticus.master.service.modelParamsService.CNNModelParamsEntityService;
import leviticus.master.service.modelParamsService.LBPModelParamsEntityService;
import leviticus.master.service.taskService.TrainTaskEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/templates")
public class TemplateController {
    @Autowired
    private TrainTaskEntityService trainTaskEntityService;

    @Autowired
    private LBPModelParamsEntityService lbpModelParamsEntityService;

    @Autowired
    private CNNModelParamsEntityService cnnModelParamsEntityService;

    @GetMapping
    public String getJobs(Model model) {
        return "landing";
    }

    @GetMapping(value = "/results")
    public String getResults(Model model) {
        Iterable<TrainTaskEntity> trainTaskEntities = trainTaskEntityService.findAll();
        List<TrainTaskEntity> trainTaskEntityList = new ArrayList<>();
        trainTaskEntities.forEach(p -> trainTaskEntityList.add(p));
        model.addAttribute("trainTaskEntities", trainTaskEntityList);

        Iterable<LBPModelParamsEntity> lbpModelParamsEntityIterable = lbpModelParamsEntityService.findAll();
        List<LBPModelParamsEntity> lbpModelParamsEntityList = new ArrayList<>();
        lbpModelParamsEntityIterable.forEach(p -> lbpModelParamsEntityList.add(p));
        model.addAttribute("lbpModelParamsEntities", lbpModelParamsEntityList);

        Iterable<CNNModelParamsEntity> cnnModelParamsEntityIterable = cnnModelParamsEntityService.findAll();
        List<CNNModelParamsEntity> cnnModelParamsEntityList = new ArrayList<>();
        cnnModelParamsEntityIterable.forEach(p -> cnnModelParamsEntityList.add(p));
        model.addAttribute("cnnModelParamsEntities", cnnModelParamsEntityList);
        return "results";
    }

    @GetMapping(value = "/train")
    public String getTrainOptions(Model model) {
        return "trainOptions";
    }

    @GetMapping(value = "/predict")
    public String getPredictOptions(Model model) {
        Iterable<TrainTaskEntity> trainTaskEntities = trainTaskEntityService.findAll();
        List<TrainTaskEntity> trainTaskEntityList = new ArrayList<>();
        trainTaskEntities.forEach(p -> trainTaskEntityList.add(p));
        model.addAttribute("trainTaskEntities", trainTaskEntityList);

        model.addAttribute("predictRequestFormModel", new PredictRequestFormModel());
        return "predictOptions";
    }

    @GetMapping(value = "/train/lbp")
    public String getLBPForm(Model model) {
        model.addAttribute("trainLBPRequestFormModel", new TrainLBPRequestFormModel());
        return "trainLBP";

    }

    @GetMapping(value = "/train/minivgg")
    public String getMiniVGGForm(Model model) {
        model.addAttribute("trainMiniVGGRequestFormModel", new TrainMiniVGGRequestFormModel());
        return "trainMiniVGG";
    }
}
