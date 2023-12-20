package kswelder.com.github.task.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    @NotBlank(message = "Name task is mandatory")
    private String name;
    @Column(nullable = false)
    @NotBlank(message = "Start task is mandatory")
    private LocalDateTime task_start;
    @Column(nullable = false)
    @NotBlank(message = "End task is mandatory")
    private LocalDateTime task_end;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
