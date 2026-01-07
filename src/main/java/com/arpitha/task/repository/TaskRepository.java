package com.arpitha.task.repository;

import com.arpitha.task.entity.Task;
import com.arpitha.task.exception.ResourceNotFoundException;
import com.arpitha.task.rowmapper.TaskRowMapper;
import com.arpitha.task.util.DBConnectionSingleton;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class TaskRepository {


//    private final org.springframework.jdbc.core.JdbcTemplate jdbcTemplate = DBConnectionSingleton.getInstance();

    private final JdbcTemplate jdbcTemplate;

    // Constructor injection
    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createTask(Task task) {
        String sql = "INSERT INTO tasks (title, description, status, scheduled_time, user_id) VALUES (?, ?, ?, ?, ?)";
        Timestamp ts = task.getScheduledTime() != null ? Timestamp.valueOf(task.getScheduledTime()) : null;
        return jdbcTemplate.update(sql, task.getTitle(), task.getDescription(), task.getStatus(), ts, task.getUserId());
    }

    public int updateTask(Task task) {
        String sql = "UPDATE tasks SET title=?, description=?, status=?, scheduled_time=? WHERE id=?";
        Timestamp ts = task.getScheduledTime() != null ? Timestamp.valueOf(task.getScheduledTime()) : null;
        return jdbcTemplate.update(sql, task.getTitle(), task.getDescription(), task.getStatus(), ts, task.getId());
    }

    public int deleteTask(Long id) {
        String sql = "DELETE FROM tasks WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    public Task getTaskById(Long id) {
        String sql = "SELECT * FROM tasks WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new TaskRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
    }

    public List<Task> getAllTasks() {
        String sql = "SELECT * FROM tasks";
        return jdbcTemplate.query(sql, new TaskRowMapper());
    }


}
