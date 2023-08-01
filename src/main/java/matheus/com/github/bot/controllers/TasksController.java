package matheus.com.github.bot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import matheus.com.github.bot.services.TasksService;

@Controller
public class TasksController implements WebMvcConfigurer {
    @Autowired
    private TasksService tasksService;
    public List<String> lista = Arrays.asList("1","2","3");

    @GetMapping("/")
    public String index(final Model model) throws Exception {
        model.addAttribute("tasks", this.lista);
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
    /*
    @PostMapping("/")
    public String runBot(@ModelAttribute("odds") Odds_Form odds) {
        System.out.println(odds.getName()+" : "+odds.getSelect());
        return "retorno";
    }
    */
}
