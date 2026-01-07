package com.arpitha.task.service;

import com.arpitha.task.dto.TaskRequestDTO;
import com.arpitha.task.entity.Task;
import com.arpitha.task.exception.ResourceNotFoundException;
import com.arpitha.task.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService service;

    private TaskRepository mockRepository;

    @BeforeEach
    void setUp() {
        mockRepository = mock(TaskRepository.class);
        service = new TaskService(mockRepository); // inject mock
    }

    @Test
    void createTaskTest() {
        TaskRequestDTO dto = new TaskRequestDTO();
        dto.setTitle("Test Task");
        dto.setDescription("This is a test");
        dto.setUserId(1L);
        dto.setScheduledTime(LocalDateTime.now().plusMinutes(1));

        when(mockRepository.createTask(any(Task.class))).thenReturn(1);

        int result = service.createTask(dto);
        assertEquals(1, result);
    }

    @Test
    void getTaskByIdFoundTest() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Sample Task");

        when(mockRepository.getTaskById(1L)).thenReturn(task);

        Task result = service.getTaskById(1L);
        assertNotNull(result);
        assertEquals("Sample Task", result.getTitle());
    }

    @Test
    void getTaskByIdNotFoundTest() {
        when(mockRepository.getTaskById(99L)).thenReturn(null);

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> service.getTaskById(99L)
        );

        assertEquals("Task not found with id: 99", exception.getMessage());
    }

    @Test
    void updateTaskFoundTest() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Updated Task");

        when(mockRepository.getTaskById(1L)).thenReturn(task);
        when(mockRepository.updateTask(task)).thenReturn(1);

        int result = service.updateTask(task);
        assertEquals(1, result);
    }

    @Test
    void updateTaskNotFoundTest() {
        Task task = new Task();
        task.setId(99L);

        when(mockRepository.getTaskById(99L)).thenReturn(null);

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> service.updateTask(task)
        );

        assertEquals("Task not found with id: 99", exception.getMessage());
    }

    @Test
    void deleteTaskFoundTest() {
        Task task = new Task();
        task.setId(1L);

        // mock getTaskById to return the task
        when(mockRepository.getTaskById(1L)).thenReturn(task);

        // mock deleteTask to return 1 (success)
        when(mockRepository.deleteTask(1L)).thenReturn(1);

        // call service and assert no exception
        assertDoesNotThrow(() -> service.deleteTask(1L));

        // verify the repository method was called
        verify(mockRepository).deleteTask(1L);
    }


    @Test
    void deleteTaskNotFoundTest() {
        when(mockRepository.getTaskById(99L)).thenReturn(null);

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> service.deleteTask(99L)
        );

        assertEquals("Task not found with id: 99", exception.getMessage());
    }

    @Test
    void getAllTasksTest() {
        Task task1 = new Task();
        Task task2 = new Task();
        when(mockRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = service.getAllTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    void scheduledTaskLoggerTest() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Scheduler Test");
        task.setScheduledTime(LocalDateTime.now().withSecond(0).withNano(0));

        when(mockRepository.getAllTasks()).thenReturn(Arrays.asList(task));

        // Just call the scheduler method
        assertDoesNotThrow(() -> service.scheduledTaskLogger());
    }
}
