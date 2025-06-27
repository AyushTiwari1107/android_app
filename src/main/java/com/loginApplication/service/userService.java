package com.loginApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginApplication.entity.userEntity;
import com.loginApplication.repository.userRepo;

@Service
public class userService {

    @Autowired
    private userRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(userEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public userEntity authenticate(String username, String rawPassword) {
        return userRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }
}
