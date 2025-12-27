package com.arpitha.taskManagementSystem.repository;

import com.arpitha.taskManagementSystem.entity.User;
import com.arpitha.taskManagementSystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User createUser(User user) {
        String sql = "INSERT INTO users" +
                "(userId,name,email,createdId) " +
                "VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
        );
        return user;
    }
    @Override
    public User getUserById(Long userId) {
        String sql = "SELECT * FROM users WHERE userId = ?";
        try{
           return jdbcTemplate.queryForObject(
                   sql,
                   new UserRowMapper(),
                   userId);

        }catch (Exception e){
            throw new ResourceNotFoundException("User not found with id:"+userId);
        }
    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql,new UserRowMapper());
    }

    @Override
    public void deleteUser(Long userId) {
        String sql = "DELETE FROM users WHERE userId = ?";
        jdbcTemplate.update(sql,userId);
    }

    @Override
    public User update(User user) {
        String sql = "UPDATE users" +
                "SET name = ?," +
                "email = ?," +
                "createAt = ?";

        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setCreatedAt(user.getCreatedAt());

        return user;
    }

}
