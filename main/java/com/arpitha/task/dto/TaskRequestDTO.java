package com.arpitha.task.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskRequestDTO {
    private String title;
    private String description;
    private LocalDateTime scheduledTime;
    private Long userId;
}
