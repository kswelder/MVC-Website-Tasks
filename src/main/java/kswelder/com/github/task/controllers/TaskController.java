package kswelder.com.github.task.controllers;

import kswelder.com.github.task.dto.TaskDTO;
import kswelder.com.github.task.models.Task;
import kswelder.com.github.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping("/list")
    public ResponseEntity<List<TaskDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.listTasks());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findTask(id));
    }
    @PostMapping("/save/{id}")
    public ResponseEntity<Void> saveTask(@PathVariable("id") String id ,@RequestBody Task task) {
        service.saveTask(id, task);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable("id") String id,@RequestBody Task task) {
        service.updateTask(id, task);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") String id) {
        service.deleteTask(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
