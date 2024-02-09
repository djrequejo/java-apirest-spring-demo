package com.djrequejo.interview.apiuserposts.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.djrequejo.interview.apiuserposts.user.model.User;
import com.djrequejo.interview.apiuserposts.user.service.UserService;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "123456789", "John", "Doe", "password"));
        users.add(new User(2L, "987654321", "Jane", "Doe", "password"));

        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<User>> response = userController.listUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

}
