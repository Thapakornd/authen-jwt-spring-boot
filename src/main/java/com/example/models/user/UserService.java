package com.example.models.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.models.user.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Collection<User> getUser() {
        return this.userRepository.findAll();
    }

    public UserDetails getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }
}
