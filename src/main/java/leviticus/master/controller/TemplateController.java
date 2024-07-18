package leviticus.master.controller;

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
    public String getForm(Model model) {
        model.addAttribute("trainRequestFormModel", new TrainRequestFormModel());

        return "train";
    }
}
