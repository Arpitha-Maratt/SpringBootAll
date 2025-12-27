package com.arpitha.taskManagementSystem.service;

import com.arpitha.taskManagementSystem.entity.Task;
import com.arpitha.taskManagementSystem.exception.InvalidInputException;
import com.arpitha.taskManagementSystem.exception.ResourceNotFoundException;
import com.arpitha.taskManagementSystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(Task task){
        return taskRepository.findAll();
    }

    public Task createTask(Task task){
        boolean validateName = validateTaskName(task.getTitle());

        if(!validateTaskName(task.getTitle())){
            throw new InvalidInputException("Task name is invalid",task.getTaskId());
        }
        return taskRepository.createTask(task);
    }

    private boolean validateTaskName(String title){
        return title!=null;
    }

    public Task updateTask(Long taskId,Task task){
        Task existing = taskRepository.getTaskById(taskId);
        if(existing==null) {
            throw new ResourceNotFoundException(
                    "Task Not found with id",
                    taskId
            );
        }
            existing.setTitle(task.getTitle());
            existing.setStatus(task.getStatus());
            existing.setDescription(task.getDescription());
            existing.setExecuted(task.getExecuted());
            existing.setUpdatedAt(task.getUpdatedAt());
            existing.setCreatedAt(task.getCreatedAt());

            return taskRepository.updateTask(existing);

    }

    public void deleteTaskById(Long taskId) {
        Task task = taskRepository.getTaskById(taskId);
        if (task == null) {
            throw new ResourceNotFoundException(
                    "Task not found with id",
                    taskId
            );
        }
        taskRepository.deleteTask(taskId);
    }

}
