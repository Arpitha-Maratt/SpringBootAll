package com.arpitha.task.service;
import com.arpitha.task.dto.UserRequestDTO;
import com.arpitha.task.entity.User;
import com.arpitha.task.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(UserRequestDTO dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        repository.createUser(user);
    }

    public User getUser(Long id) {
        return repository.getUserById(id);
    }

    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    public void updateUser(Long id, UserRequestDTO dto) {
        User user = new User();
        user.setId(id);
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        repository.updateUser(user);
    }

    public void deleteUser(Long id) {
        repository.deleteUser(id);
    }

}

