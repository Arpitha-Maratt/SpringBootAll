package com.arpitha.taskManagementSystem.repository;


import com.arpitha.taskManagementSystem.entity.User;

import java.util.List;

public interface UserRepository {

    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUser();
    void deleteUser(Long userId);
    User update(User user);
}
