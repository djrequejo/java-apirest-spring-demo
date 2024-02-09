package com.djrequejo.interview.apiuserposts.post.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.djrequejo.interview.apiuserposts.post.model.Post;
import com.djrequejo.interview.apiuserposts.post.repository.PostRepository;
import com.djrequejo.interview.apiuserposts.user.model.User;
import com.djrequejo.interview.apiuserposts.user.repository.UserRepository;

public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PostService postService;

    public PostServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreatePost() {
        User user = new User(1L, "123456789", "Diego", "Requejo", "secret");
        Post post = new Post(null, "Test post", user);
        Post savedPost = new Post(1L, "Test post", user);

        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
        when(postRepository.save(post)).thenReturn(savedPost);

        Post createdPost = postService.createPost(1L, post);

        assertNotNull(createdPost.getId());
        assertEquals(savedPost.getText(), createdPost.getText());
        assertEquals(savedPost.getUser(), createdPost.getUser());
    }

}
