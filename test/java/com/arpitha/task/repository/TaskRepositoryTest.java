package com.arpitha.task.repository;

import com.arpitha.task.entity.Task;
import com.arpitha.task.exception.ResourceNotFoundException;
import com.arpitha.task.rowmapper.TaskRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

public class TaskRepositoryTest {

    @Mock
    private JdbcTemplate mockJdbcTemplate;

    @InjectMocks
    private TaskRepository repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void createTaskTest() {
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Desc");
        task.setStatus("PENDING");
        task.setScheduledTime(LocalDateTime.now());
        task.setUserId(1L);

        when(mockJdbcTemplate.update(anyString(), any(), any(), any(), any(), any())).thenReturn(1);

        int result = repository.createTask(task);

        assertEquals(1, result);
        verify(mockJdbcTemplate).update(anyString(), any(), any(), any(), any(), any());
    }

    @Test
    void getTaskByIdFoundTest() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Task 1");

        when(mockJdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(1L))).thenReturn(task);

        Task result = repository.getTaskById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void getTaskByIdNotFoundTest() {
        when(mockJdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(99L)))
                .thenThrow(EmptyResultDataAccessException.class);

        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class,
                () -> repository.getTaskById(99L));

        assertEquals("Task not found with id: 99", ex.getMessage());
    }

    @Test
    void getAllTasksTest() {
        Task firstTask = new Task();
        Task secondTask = new Task();
        when(mockJdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(Arrays.asList(firstTask,secondTask));

        List<Task> tasks = repository.getAllTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    void updateTaskTest() {
        Task task = new Task();
        task.setId(1L);

        when(mockJdbcTemplate.update(anyString(), any(), any(), any(), any(), any())).thenReturn(1);

        int result = repository.updateTask(task);
        assertEquals(1, result);
    }

    @Test
    void deleteTaskTest() {
        when(mockJdbcTemplate.update(anyString(), eq(1L))).thenReturn(1);

        int result = repository.deleteTask(1L);
        assertEquals(1, result);
    }
}

