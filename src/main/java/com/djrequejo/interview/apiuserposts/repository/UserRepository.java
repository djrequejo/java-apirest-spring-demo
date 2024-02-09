package com.djrequejo.interview.apiuserposts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djrequejo.interview.apiuserposts.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}