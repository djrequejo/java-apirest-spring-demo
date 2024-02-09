package com.djrequejo.interview.apiuserposts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djrequejo.interview.apiuserposts.model.Post;
import com.djrequejo.interview.apiuserposts.model.User;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUser(User user);

}