package com.djrequejo.interview.apiuserposts.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.djrequejo.interview.apiuserposts.user.model.User;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveUser() {
        // Given
        User user = new User();
        user.setName("Diego");
        user.setLastName("Requejo");
        user.setPassword("secret");
        user.setCellphone("1234567890");

        // When
        User savedUser = userRepository.save(user);

        // Then
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("Diego");
        
    }

}
