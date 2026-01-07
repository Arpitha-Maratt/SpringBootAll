package com.arpitha.task.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime scheduledTime;
    private Long userId;
}
