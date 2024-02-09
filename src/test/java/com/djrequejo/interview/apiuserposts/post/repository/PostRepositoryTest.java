package com.djrequejo.interview.apiuserposts.post.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


import com.djrequejo.interview.apiuserposts.post.model.Post;
import com.djrequejo.interview.apiuserposts.user.model.User;
import com.djrequejo.interview.apiuserposts.user.repository.UserRepository;

@DataJpaTest
public class PostRepositoryTest {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSavePost() {
        // Given
        User user = new User();
        user.setName("Diego");
        user.setLastName("Requejo");
        user.setPassword("secret");
        user.setCellphone("123456789");

        userRepository.save(user);
        
        Post post = new Post();
        post.setText("Hello, world!");
        post.setUser(user);

        // When
        Post savedPost = postRepository.save(post);

        // Then
        assertThat(savedPost.getId()).isNotNull();
        assertThat(savedPost.getText()).isEqualTo("Hello, world!");
        
    }

}
