package com.arpitha.taskManagementSystem.repository;

import com.arpitha.taskManagementSystem.entity.User;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet,int rowNum)throws SQLException{
        User user = new User();

        user.setUserId(resultSet.getLong("userId"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));

        return user;
    }
}