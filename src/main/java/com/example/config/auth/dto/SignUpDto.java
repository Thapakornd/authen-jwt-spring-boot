package com.example.config.auth.dto;

import com.example.models.user.UserRole;

public record SignUpDto (
    String username,
    String password,
    UserRole role
) {}
