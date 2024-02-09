package com.djrequejo.interview.apiuserposts.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.djrequejo.interview.apiuserposts.user.model.User;
import com.djrequejo.interview.apiuserposts.user.repository.UserRepository;

public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User(null, "123456789", "Diego", "Requejo", "secret");
        User savedUser = new User(1L, "123456789", "Diego", "Requejo", "secret");

        when(userRepository.save(user)).thenReturn(savedUser);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser.getId());
        assertEquals(savedUser.getCellphone(), createdUser.getCellphone());
        assertEquals(savedUser.getName(), createdUser.getName());
        assertEquals(savedUser.getLastName(), createdUser.getLastName());
        assertEquals(savedUser.getPassword(), createdUser.getPassword());
    }
}
