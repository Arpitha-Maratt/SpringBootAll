package com.arpitha.taskManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private Boolean executed = false;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LocalDateTime scheduledTime;

    @ManyToOne
    @JoinColumn(name ="user_Id",nullable = false)
    private User user;
}
