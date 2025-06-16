package org.example.service;

import lombok.AllArgsConstructor;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }
}
