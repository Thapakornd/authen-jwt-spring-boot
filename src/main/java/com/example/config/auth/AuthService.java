package com.example.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.config.auth.dto.SignUpDto;
import com.example.models.user.UserService;
import com.example.models.user.entity.User;

@Service
public class AuthService implements UserDetailsService {
    
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = this.userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public UserDetails signUp(SignUpDto data) throws Exception {
        if (this.userService.getUserByUsername(data.username()) != null) {
            throw new Exception("Username already exists");
        }
        String encryptedPass = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), encryptedPass, data.role());
        return this.userService.createUser(newUser);
    }
}
