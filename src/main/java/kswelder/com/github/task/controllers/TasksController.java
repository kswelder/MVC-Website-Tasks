package kswelder.com.github.task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kswelder.com.github.task.models.Task;
import kswelder.com.github.task.services.TasksService;

@Controller
public class TasksController implements WebMvcConfigurer {
    @Autowired
    private TasksService tasksService;

    @GetMapping("/")
    public String index(final Model model) throws Exception {
        List<Task> listTasks = tasksService.listTasks();

        model.addAttribute("tasks", listTasks);
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
    @PostMapping("/")
    public String runBot(@ModelAttribute("tasks") Task task) {
        System.out.println(task.getName());
        return "retorno";
    }
}
