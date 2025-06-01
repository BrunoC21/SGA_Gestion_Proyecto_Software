package com.microservice.authentication.services;

import com.microservice.authentication.dto.RegisterRequest;
import com.microservice.authentication.entities.User;
import com.microservice.authentication.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void updateUserRole(Long userId, String role) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(role);
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void updateUserData(Long userId, RegisterRequest data) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFullName(data.getFullName());
        user.setEmail(data.getEmail());
        user.setBirthDate(data.getBirthDate());
        user.setRegion(data.getRegion());
        user.setCommune(data.getCommune());
        user.setAddress(data.getAddress());

        userRepository.save(user);
    }

    public void updateUserDataByUsername(String username, RegisterRequest data) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFullName(data.getFullName());
        user.setEmail(data.getEmail());
        user.setBirthDate(data.getBirthDate());
        user.setRegion(data.getRegion());
        user.setCommune(data.getCommune());
        user.setAddress(data.getAddress());

        userRepository.save(user);
    }
}