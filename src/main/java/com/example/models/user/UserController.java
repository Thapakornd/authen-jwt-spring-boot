package com.example.models.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public String getUserInfo(Model m) {
        m.addAttribute("users", userService.getUser());
        return "user";
    }

    @GetMapping("/all")
    public String getUsers(@RequestParam String param) {
        return "users";
    }
}
