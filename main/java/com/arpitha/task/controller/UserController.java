package com.arpitha.task.controller;

import com.arpitha.task.dto.UserRequestDTO;
import com.arpitha.task.entity.User;
import com.arpitha.task.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String createUser(@RequestBody UserRequestDTO dto) {
        service.createUser(dto);
        return "User created successfully";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserRequestDTO dto) {
        service.updateUser(id, dto);
        return "User updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}
