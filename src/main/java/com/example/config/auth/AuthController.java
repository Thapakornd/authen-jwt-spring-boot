package com.example.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.config.auth.dto.SignInDto;
import com.example.config.auth.dto.SignUpDto;
import com.example.models.user.UserRole;
import com.example.models.user.entity.User;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthService authService;

    @Autowired
    TokenProvider tokenService;

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup.jsp";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam("username") String username, @RequestParam("password") String password, Model m) throws Exception {
        SignUpDto data = new SignUpDto(username, password, UserRole.USER);
        this.authService.signUp(data);
        return "login";
    }

    @GetMapping("/login")
    public String getMethodName() {
        return "login";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam("username") String username, @RequestParam("password") String password, Model m) {
        SignInDto data = new SignInDto(username, password);
        Authentication authentication = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        Authentication auth = authenticationManager.authenticate(authentication);
        String accessToken = tokenService.generateAccessToken((User) auth.getPrincipal());
        return "index";
    }
}
