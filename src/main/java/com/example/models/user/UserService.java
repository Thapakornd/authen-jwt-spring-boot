package com.example.models.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.user.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Collection<User> getUser() {
        return this.userRepository.findAll();
    }

}
