package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages= "com.example")
@PropertySource("file:${user.dir}/.env")
public class WebBlogApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WebBlogApplication.class, args);
    }
}
