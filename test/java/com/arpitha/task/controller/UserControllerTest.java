package com.arpitha.task.controller;

import com.arpitha.task.dto.UserRequestDTO;
import com.arpitha.task.entity.User;
import com.arpitha.task.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService mockService;

    @InjectMocks
    private UserController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserTest() {
        UserRequestDTO dto = new UserRequestDTO();
        dto.setUserName("Arpitha");
        dto.setEmail("arpitha@example.com");

        // Since createUser is void, use doNothing()
        doNothing().when(mockService).createUser(dto);

        String response = controller.createUser(dto);

        assertEquals("User created successfully", response);
        verify(mockService, times(1)).createUser(dto);
    }

    @Test
    void getUserTest() {
        User user = new User();
        user.setId(1L);
        user.setUserName("Arpitha");
        user.setEmail("arpitha@example.com");

        when(mockService.getUser(1L)).thenReturn(user);

        User response = controller.getUser(1L);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Arpitha", response.getUserName());
        verify(mockService, times(1)).getUser(1L);
    }

    @Test
    void getAllUsersTest() {
        User firstUser = new User();
        firstUser.setId(1L);
        User secondUser = new User();
        secondUser.setId(2L);

        when(mockService.getAllUsers()).thenReturn(Arrays.asList(firstUser,secondUser));

        List<User> response = controller.getAllUsers();

        assertEquals(2, response.size());
        verify(mockService, times(1)).getAllUsers();
    }

    @Test
    void updateUserTest() {
        UserRequestDTO dto = new UserRequestDTO();
        dto.setUserName("Updated Name");
        dto.setEmail("updated@example.com");

        // updateUser is void
        doNothing().when(mockService).updateUser(1L, dto);

        String response = controller.updateUser(1L, dto);

        assertEquals("User updated successfully", response);
        verify(mockService, times(1)).updateUser(1L, dto);
    }

    @Test
    void deleteUserTest() {
        // deleteUser is void
        doNothing().when(mockService).deleteUser(1L);

        String response = controller.deleteUser(1L);

        assertEquals("User deleted successfully", response);
        verify(mockService, times(1)).deleteUser(1L);
    }
}
