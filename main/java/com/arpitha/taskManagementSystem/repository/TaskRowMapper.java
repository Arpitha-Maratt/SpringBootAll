package com.arpitha.taskManagementSystem.repository;

import com.arpitha.taskManagementSystem.entity.Task;
import com.arpitha.taskManagementSystem.entity.TaskStatus;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        Task task = new Task();

        task.setTaskId(resultSet.getLong("taskId"));
        task.setTitle(resultSet.getString("title"));
        task.setDescription(resultSet.getString("description"));
        task.setStatus(TaskStatus.valueOf(resultSet.getString("status")));
        task.setExecuted(resultSet.getBoolean("executed"));
        task.setCreatedAt(resultSet.getTimestamp("createdAt").toLocalDateTime());
        task.setUpdatedAt(resultSet.getTimestamp("updatedAt").toLocalDateTime());

        return task;
    }

}
