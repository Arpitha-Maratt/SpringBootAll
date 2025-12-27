package com.arpitha.taskManagementSystem.service;

import com.arpitha.taskManagementSystem.entity.User;
import com.arpitha.taskManagementSystem.exception.InvalidInputException;
import com.arpitha.taskManagementSystem.exception.ResourceNotFoundException;
import com.arpitha.taskManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }


    public User getUserById(Long userId){
        User user = userRepository.getUserById(userId);
        if(user==null){
            throw new ResourceNotFoundException("User not found with this id"+userId);
        }
        return user;
    }



    public User createUser(User user){
        boolean validation = validateUser(user.getName());

        if(!validateUser(user.getName())){
            throw new InvalidInputException("User name is invalid",user.getUserId());
        }
        return userRepository.createUser(user);
    }

    private boolean validateUser(String name) {
        return name!= null;
    }



    public void deleteUserById(Long userId){
        User user = userRepository.getUserById(userId);
        if(user==null){
            throw  new ResourceNotFoundException(
                    "User not found with id",
                    userId
            );
        }
        userRepository.deleteUser(userId);
    }



}
