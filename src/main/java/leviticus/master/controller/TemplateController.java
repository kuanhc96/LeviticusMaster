package leviticus.master.controller;

import leviticus.master.model.TrainLBPRequestFormModel;
import leviticus.master.model.TrainMiniVGGRequestFormModel;
import leviticus.master.model.TrainRequestFormModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/templates")
public class TemplateController {
    @GetMapping
    public String getJobs() {
        return "landing";
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
