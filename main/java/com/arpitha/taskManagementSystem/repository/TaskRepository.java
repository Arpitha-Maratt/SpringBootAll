package com.arpitha.taskManagementSystem.repository;

import com.arpitha.taskManagementSystem.entity.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findAll();
    Task createTask(Task task);
    Task getTaskById(Long taskId);
    Task updateTask(Task task);
    void deleteTask(Long taskId);
    List<Task> findTaskByUserId(Long userId);

}
