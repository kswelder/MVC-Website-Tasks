package kswelder.com.github.task.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import kswelder.com.github.task.dto.TaskDTO;
import kswelder.com.github.task.models.User;
import kswelder.com.github.task.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kswelder.com.github.task.models.Task;
import kswelder.com.github.task.repositorys.TaskRepository;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository repository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public void saveTask(String id, Task task) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        LocalDateTime dateTime = LocalDateTime.now();
        task.setCreatedAt(dateTime);
        task.setUpdatedAt(dateTime);
        task.setUser(user);
        repository.save(task);
    }
    public void updateTask(String id, Task task) {
        Task register = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
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
    public List<TaskDTO> listTasks() {
        return repository.findAll()
                .stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
    }
    public void deleteTask(String id) {
        repository.deleteById(id);
    }
    public Task findTask(String id) {
        Optional<Task> register = repository.findById(id);
        return register.get();
    }
}
