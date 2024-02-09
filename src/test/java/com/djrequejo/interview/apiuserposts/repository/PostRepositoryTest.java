package com.djrequejo.interview.apiuserposts.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.djrequejo.interview.apiuserposts.model.Post;

@DataJpaTest
public class PostRepositoryTest {
    
    @Autowired
    private PostRepository postRepository;

    @Test
    public void shouldSavePost() {
        // Given
        Post post = new Post();
        post.setText("Hello, world!");

        // When
        Post savedPost = postRepository.save(post);

        // Then
        assertThat(savedPost.getId()).isNotNull();
        assertThat(savedPost.getText()).isEqualTo("Hello, world!");
        
    }

}
