package com.djrequejo.interview.apiuserposts.post.controller;

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

import com.djrequejo.interview.apiuserposts.post.model.Post;
import com.djrequejo.interview.apiuserposts.post.service.PostService;

public class PostControllerTest {

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    public PostControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPostsByUser() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "First post"));
        posts.add(new Post(2L, "Second post"));

        when(postService.getPostsByUser(1L)).thenReturn(posts);

        ResponseEntity<List<Post>> response = postController.listPostsByUser(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(posts, response.getBody());    }

}
