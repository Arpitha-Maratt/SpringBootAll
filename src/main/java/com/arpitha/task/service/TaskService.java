package com.arpitha.task.service;

import com.arpitha.task.dto.TaskRequestDTO;
import com.arpitha.task.entity.Task;
import com.arpitha.task.exception.ResourceNotFoundException;
import com.arpitha.task.repository.TaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public int createTask(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus("PENDING");
        task.setScheduledTime(dto.getScheduledTime());
        task.setUserId(dto.getUserId());

        return repository.createTask(task);
    }

    public int updateTask(Task task) {
        Task existingTask = repository.getTaskById(task.getId());

        if (existingTask == null) {
            throw new ResourceNotFoundException(
                    "Task not found with id: " + task.getId()
            );
        }

        return repository.updateTask(task);
    }

    public void deleteTask(Long id) {
        Task existingTask = repository.getTaskById(id);

        if (existingTask == null) {
            throw new ResourceNotFoundException(
                    "Task not found with id: " + id
            );
        }

        repository.deleteTask(id);
    }

    public Task getTaskById(Long id) {
        Task task = repository.getTaskById(id);

        if (task == null) {
            throw new ResourceNotFoundException(
                    "Task not found with id: " + id
            );
        }

        return task;
    }

    public List<Task> getAllTasks() {
        return repository.getAllTasks();
    }

    // Scheduler runs every minute
    @Scheduled(fixedRate = 60000)
    public void scheduledTaskLogger() {
        List<Task> tasks = repository.getAllTasks();
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);

        for (Task task : tasks) {
            if (task.getScheduledTime() != null &&
                    task.getScheduledTime().withSecond(0).withNano(0).equals(now)) {

                System.out.println("Scheduled Task Triggered → " +
                        "Title: " + task.getTitle() +
                        ", Time: " + task.getScheduledTime() +
                        ", User ID: " + task.getUserId());
            }
        }
    }
}
