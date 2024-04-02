package com.noteAPI.controller.request.auth;

import com.noteAPI.database.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String passwordHash;
    private String name;
    private Role role;
    private int age;
}
