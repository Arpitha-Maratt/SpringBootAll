package com.arpitha.task.service;

import com.arpitha.task.dto.UserRequestDTO;
import com.arpitha.task.entity.User;
import com.arpitha.task.repository.UserRepository;
import com.arpitha.task.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository mockRepository;

    @InjectMocks
    private UserService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserTest() {
        UserRequestDTO dto = new UserRequestDTO();
        dto.setUserName("Test User");
        dto.setEmail("test@ivoyant.com");

        service.createUser(dto);

        verify(mockRepository).createUser(any(User.class));
    }

    @Test
    void getUserFoundTest() {
        User user = new User();
        user.setId(1L);
        user.setUserName("Arpitha");
        user.setEmail("arpitha@ivoyant.com");

        when(mockRepository.getUserById(1L)).thenReturn(user);

        User result = service.getUser(1L);

        assertNotNull(result);
        assertEquals("Arpitha", result.getUserName());
        assertEquals("arpitha@ivoyant.com", result.getEmail());
    }

    @Test
    void getAllUsersTest() {
        User firstUser = new User();
        firstUser.setId(1L);
        firstUser.setUserName("User1");

        User secondUser = new User();
        secondUser.setId(2L);
        secondUser.setUserName("User2");

        when(mockRepository.getAllUsers()).thenReturn(Arrays.asList(firstUser,secondUser));

        List<User> users = service.getAllUsers();
        assertEquals(2, users.size());
        verify(mockRepository).getAllUsers();
    }

    @Test
    void updateUserTest() {
        UserRequestDTO dto = new UserRequestDTO();
        dto.setUserName("Updated User");
        dto.setEmail("updated@ivoyant.com");

        service.updateUser(1L, dto);

        verify(mockRepository).updateUser(any(User.class));
    }

    @Test
    void deleteUserTest() {
        service.deleteUser(1L);
        verify(mockRepository).deleteUser(1L);
    }
}