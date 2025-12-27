package com.arpitha.taskManagementSystem.repository;

import com.arpitha.taskManagementSystem.entity.Task;
import com.arpitha.taskManagementSystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Task> findAll() {
        String sql = "SELECT * FROM tasks";
        return jdbcTemplate.query(sql, new TaskRowMapper());
    }

    @Override
    public Task createTask(Task task) {
        String sql = """
        INSERT INTO tasks
        (title,description,status,executed,createdAt,updatedAt,user_id)
        VALUES(?,?,?,?,?,?,?)""";
        jdbcTemplate.update(sql,
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name(),
                task.getExecuted(),
                task.getCreatedAt(),
                task.getUpdatedAt(),
                task.getUser().getUserId()
        );
        return task;
    }

    @Override
    public Task getTaskById(Long taskId) {
       String sql = "SELECT * FROM tasks WHERE taskId = ?";
      try{
          return jdbcTemplate.queryForObject(
                  sql,
                  new TaskRowMapper(),
                  taskId
          );

      }catch (Exception e){
          throw new ResourceNotFoundException("Task not found by this id:"+taskId);
      }
    }

    @Override
    public Task updateTask(Task task) {
        String sql = """
                UPDATE tasks 
                SET title = ?,
                description= ?,
                status=?,
                executed=?, +
                updatedAt=?, +
                user_id=? +
                WHERE taskId =? """;

        jdbcTemplate.update(sql,
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name(),
                task.getExecuted(),
                task.getUpdatedAt(),
                task.getUser().getUserId(),
                task.getTaskId()
        );
        return task;
    }

    @Override
    public void deleteTask(Long taskId) {
        String sql = "DELETE FROM tasks WHERE taskId = ?";
        jdbcTemplate.update(sql,taskId);

    }

    @Override
    public List<Task> findTaskByUserId(Long userId) {
       String sql = "SELECT * FROM tasks WHERE user_id = ?";
       return jdbcTemplate.query(sql,
               new TaskRowMapper(),userId);
    }
}
