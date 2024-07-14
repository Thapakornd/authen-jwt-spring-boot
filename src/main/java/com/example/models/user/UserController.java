package com.example.models.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public String getUserInfo(Model m) {
        m.addAttribute("users", userService.getUser());
        return "user.jsp";
    }

    @GetMapping("/create")
    public String showCreateUser(Model m) {
        return "user-create.jsp";
    }

    @PostMapping("/create")
    public String createUser(Model m) {
        return "redirect:/users";
    }
}
