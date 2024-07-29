package leviticus.master.controller;

import leviticus.master.entity.taskEntity.TrainTaskEntity;
import leviticus.master.model.TrainLBPRequestFormModel;
import leviticus.master.model.TrainMiniVGGRequestFormModel;
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
        return "results";
    }

    @GetMapping(value = "/train")
    public String getTrainOptions(Model model) {
        return "trainOptions";
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
