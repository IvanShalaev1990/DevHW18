package com.noteAPI.controller.request.user;

import lombok.Data;

import java.util.UUID;

@Data
public class UserGetByIdRequest {
    private UUID id;
}
