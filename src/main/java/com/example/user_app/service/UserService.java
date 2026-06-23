package com.example.user_app.service;

import com.example.user_app.entity.User;
import com.example.user_app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final KeycloakUserService keycloakUserService;
    private final UserRepository userRepository;

    public UserService(KeycloakUserService keycloakUserService, UserRepository userRepository) {
        this.keycloakUserService = keycloakUserService;
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user){
        user.setCreatedAt(LocalDateTime.now());
        User saveUser= userRepository.save(user);
        log.info(saveUser.getId().toString());
        keycloakUserService.createUser(saveUser);

        return user;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
