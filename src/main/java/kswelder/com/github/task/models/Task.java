package kswelder.com.github.task.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private String id;
    private String name;
    private LocalDateTime task_start;
    private LocalDateTime task_end;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
