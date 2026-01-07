package com.arpitha.task.repository;

import com.arpitha.task.entity.User;
import com.arpitha.task.exception.ResourceNotFoundException;
import com.arpitha.task.rowmapper.UserRowMapper;
import com.arpitha.task.util.DBConnectionSingleton;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {


    private final JdbcTemplate jdbcTemplate;

    // Constructor injection
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // Create a new user
    public int createUser(User user) {
        try {
            String sql = "INSERT INTO users (userName, email) VALUES (?, ?)";
            return jdbcTemplate.update(sql, user.getUserName(), user.getEmail());
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user: " + e.getMessage());
        }
    }

    // Get user by ID
    public User getUserById(Long id) {
        String sql = "SELECT * FROM users WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch user: " + e.getMessage());
        }
    }

    // Get all users
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        try {
            return jdbcTemplate.query(sql, new UserRowMapper());
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch users: " + e.getMessage());
        }
    }

    // Update user
    public int updateUser(User user) {
        try {
            String sql = "UPDATE users SET userName=?, email=? WHERE id=?";
            return jdbcTemplate.update(sql, user.getUserName(), user.getEmail(), user.getId());
        } catch (Exception e) {
            throw new RuntimeException("Failed to update user: " + e.getMessage());
        }
    }

    // Delete user
    public int deleteUser(Long id) {
        try {
            return jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete user: " + e.getMessage());
        }
    }
}
