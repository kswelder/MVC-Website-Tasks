package kswelder.com.github.task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/task/{id}")
    public String taskPage(@PathVariable("id") String id, final Model model) {
        model.addAttribute("task", tasksService.findTask(id));

        return "task";
    }
    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("tasks") Task task, final Model model) {
        tasksService.saveTask(task);

        model.addAttribute("message", "Task Created");

        return "retorno";
    }
    @GetMapping("/updateTask/{id}")
    public String updateTask(@PathVariable("id") String id,@ModelAttribute("tasks") Task task) {
        tasksService.updateTask(id, task);
        return "redirect:/";
    }
    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") String id, final Model model) {
        tasksService.deleteTask(id);

        model.addAttribute("message", "Task deleted");

        return "retorno";
    }
}
