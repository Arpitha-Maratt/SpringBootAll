package com.arpitha.task.rowmapper;

import com.arpitha.task.entity.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setStatus(rs.getString("status"));

        Timestamp ts = rs.getTimestamp("scheduled_time");
        task.setScheduledTime(ts != null ? ts.toLocalDateTime() : null);

        task.setUserId(rs.getLong("user_id"));
        return task;
    }
}
