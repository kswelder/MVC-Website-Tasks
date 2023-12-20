package kswelder.com.github.task.dto;

import kswelder.com.github.task.models.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private String id;
    private String name;
    private LocalDateTime task_start;
    private LocalDateTime task_end;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.task_start = task.getTask_start();
        this.task_end = task.getTask_end();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
    }
}
