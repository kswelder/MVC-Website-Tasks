package kswelder.com.github.task.controllers;

import java.util.List;

import kswelder.com.github.task.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kswelder.com.github.task.models.Task;
import kswelder.com.github.task.services.TaskService;

@Controller
public class PagesController implements WebMvcConfigurer {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String index(final Model model) throws Exception {
        List<TaskDTO> listTasks = taskService.listTasks();

        model.addAttribute("tasks", listTasks);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/task/{id}")
    public String taskPage(@PathVariable("id") String id, final Model model) {
        model.addAttribute("task", taskService.findTask(id));

        return "task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("tasks") Task task, final Model model) {
        //taskService.saveTask(task);

        model.addAttribute("message", "Task Created");

        return "retorno";
    }

    @GetMapping("/updateTask/{id}")
    public String updateTask(@PathVariable("id") String id,@ModelAttribute("tasks") Task task) {
        taskService.updateTask(id, task);
        return "redirect:/";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") String id, final Model model) {
        taskService.deleteTask(id);

        model.addAttribute("message", "Task deleted");

        return "retorno";
    }
}
