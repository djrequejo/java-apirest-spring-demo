package com.djrequejo.interview.apiuserposts.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djrequejo.interview.apiuserposts.user.model.User;
import com.djrequejo.interview.apiuserposts.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        
        if (!existingUser.getId().equals(updatedUser.getId())) {
            throw new RuntimeException("Modifying the user ID is not allowed");
        }

        if(updatedUser.getName() != null) {
            existingUser.setName(updatedUser.getName());
        }
        if(updatedUser.getLastName() != null) {
            existingUser.setLastName(updatedUser.getLastName());
        }
        if(updatedUser.getCellphone() != null) {
            existingUser.setCellphone(updatedUser.getCellphone());
        }

        return userRepository.saveAndFlush(existingUser);
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        userRepository.deleteById(userId);
    }
}
