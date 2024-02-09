package com.djrequejo.interview.apiuserposts.post.service;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djrequejo.interview.apiuserposts.post.model.Post;
import com.djrequejo.interview.apiuserposts.post.repository.PostRepository;
import com.djrequejo.interview.apiuserposts.user.model.User;
import com.djrequejo.interview.apiuserposts.user.repository.UserRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<Post> getPostsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return user.getPosts();
    }

    public Post createPost(Long userId, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        post.setUser(user);
        return postRepository.save(post);
    }

    @Transactional
    public Post updatePost(Long userId, Long postId, Post updatedPost) {
        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found: " + postId));

        if (!existingPost.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("Modifying another user's post is not allowed");
        }

        existingPost.setText(updatedPost.getText());

        return postRepository.saveAndFlush(existingPost);
    }

    @Transactional
    public void deletePost(Long userId, Long postId) {
        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found: " + postId));
        
        if (!existingPost.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("Deleting a post from another user is not allowed");
        }

        postRepository.delete(existingPost);
    }


}
