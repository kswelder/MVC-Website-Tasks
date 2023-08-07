package kswelder.com.github.task.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kswelder.com.github.task.models.Task;
import kswelder.com.github.task.repositorys.TasksRepository;


@Service
public class TasksService {
    @Autowired
    private TasksRepository repository;

    public void saveTask(Task task) {
        UUID uuid = UUID.randomUUID();
        task.setId(uuid.toString());
        LocalDateTime dateTime = LocalDateTime.now();
        task.setCreatedAt(dateTime);
        task.setUpdatedAt(dateTime);
        if (repository.findById(uuid.toString()).isPresent()){
            uuid = UUID.randomUUID();
            task.setId(uuid.toString());
        }
        repository.save(task);
    }
    public void updateTask(String id,Task task) {
        Task register = repository.findById(id).get();
        if (Optional.of(task.getName()).isPresent()) {
            register.setName(task.getName());
        }
        if (Optional.of(task.getTask_start()).isPresent()) {
            register.setTask_start(task.getTask_start());
        }
        if (Optional.of(task.getTask_end()).isPresent()) {
            register.setTask_end(task.getTask_end());
        }
        repository.save(register);
    }
    public List<Task> listTasks() {
        return repository.findAll()
                .stream()
                .collect(Collectors.toList());
    }
    public void deleteTask(String id) {
        repository.deleteById(id);
    }
}
