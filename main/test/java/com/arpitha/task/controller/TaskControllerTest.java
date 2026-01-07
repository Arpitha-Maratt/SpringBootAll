package com.arpitha.task.controller;

import com.arpitha.task.dto.TaskRequestDTO;
import com.arpitha.task.entity.Task;
import com.arpitha.task.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    @Mock
    private TaskService mockService;

    @InjectMocks
    private TaskController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTaskExceptionTest() {
        TaskRequestDTO dto = new TaskRequestDTO();
        dto.setTitle("Test Task");

        // Throw exception when service is called
        doThrow(new RuntimeException("DB Error")).when(mockService).createTask(dto);

        ResponseEntity<String> response = controller.createTask(dto);

        assertEquals(500, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("Error creating task: DB Error"));

        verify(mockService, times(1)).createTask(dto);
    }



    @Test
    void updateTaskExceptionTest() {
        Task task = new Task();
        task.setTitle("Updated Task");

        doThrow(new RuntimeException("DB Error")).when(mockService).updateTask(task);

        ResponseEntity<String> response = controller.updateTask(1L, task);

        assertEquals(500, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("Error updating task: DB Error"));

        verify(mockService, times(1)).updateTask(task);
    }

    @Test
    void deleteTaskTest() {
        doNothing().when(mockService).deleteTask(1L);

        ResponseEntity<String> response = controller.deleteTask(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Task deleted successfully", response.getBody());

        verify(mockService, times(1)).deleteTask(1L);
    }

    @Test
    void getTaskTest() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");

        when(mockService.getTaskById(1L)).thenReturn(task);

        ResponseEntity<Task> response = controller.getTask(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        assertEquals("Test Task", response.getBody().getTitle());

        verify(mockService, times(1)).getTaskById(1L);
    }

    @Test
    void getAllTasksTest() {
        Task t1 = new Task();
        t1.setId(1L);
        Task t2 = new Task();
        t2.setId(2L);

        when(mockService.getAllTasks()).thenReturn(Arrays.asList(t1, t2));

        ResponseEntity<List<Task>> response = controller.getAllTasks();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());

        verify(mockService, times(1)).getAllTasks();
    }
}
