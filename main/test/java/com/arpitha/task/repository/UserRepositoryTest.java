package com.arpitha.task.repository;

import com.arpitha.task.entity.User;
import com.arpitha.task.exception.ResourceNotFoundException;
import com.arpitha.task.rowmapper.UserRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserRepositoryTest {

    @Mock
    private JdbcTemplate mockJdbcTemplate;

    @InjectMocks
    private UserRepository repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }


    @Test
    void createUserTest() {
        User user = new User();
        user.setUserName("Arpitha");
        user.setEmail("arpitha@example.com");

        // Mock JdbcTemplate update for varargs
        when(mockJdbcTemplate.update(anyString(), any(Object[].class))).thenReturn(1);

        int result = repository.createUser(user);
        assertEquals(1, result);

        verify(mockJdbcTemplate).update(anyString(), any(Object[].class));
    }



    @Test
    void getUserByIdFoundTest() {
        User user = new User();
        user.setId(1L);
        user.setUserName("Arpitha");

        when(mockJdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(1L)))
                .thenReturn(user);

        User result = repository.getUserById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Arpitha", result.getUserName());
    }

    @Test
    void getUserByIdNotFoundTest() {
        when(mockJdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(99L)))
                .thenThrow(EmptyResultDataAccessException.class);

        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class,
                () -> repository.getUserById(99L));

        assertEquals("User not found with id: 99", ex.getMessage());
    }

    @Test
    void getAllUsersTest() {
        User u1 = new User();
        User u2 = new User();

        when(mockJdbcTemplate.query(anyString(), any(RowMapper.class)))
                .thenReturn(Arrays.asList(u1, u2));

        List<User> users = repository.getAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    void updateUserTest() {
        User user = new User();
        user.setId(1L);
        user.setUserName("ArpithaUpdated");

        when(mockJdbcTemplate.update(anyString(), any(), any(), any())).thenReturn(1);

        int result = repository.updateUser(user);
        assertEquals(1, result);
        verify(mockJdbcTemplate).update(anyString(), any(), any(), any());
    }

    @Test
    void deleteUserTest() {
        when(mockJdbcTemplate.update(anyString(), eq(1L))).thenReturn(1);

        int result = repository.deleteUser(1L);
        assertEquals(1, result);
        verify(mockJdbcTemplate).update(anyString(), eq(1L));
    }
}
