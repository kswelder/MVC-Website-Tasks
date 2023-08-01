package matheus.com.github.bot.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Odds {
    private String name;
    private LocalDateTime task_start;
    private LocalDateTime task_end;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
