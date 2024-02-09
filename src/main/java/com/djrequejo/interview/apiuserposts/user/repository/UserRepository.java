package com.djrequejo.interview.apiuserposts.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djrequejo.interview.apiuserposts.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}