package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebBlogController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
