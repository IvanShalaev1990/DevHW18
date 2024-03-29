package com.noteAPI.controller.request.user;

import com.noteAPI.database.entity.Role;
import lombok.Data;

import java.util.UUID;
@Data
public class UserUpdateRequest {
    private UUID id;
    private String email;
    private String passwordHash;
    private Role role;
    private String name;
    private int age;
}
