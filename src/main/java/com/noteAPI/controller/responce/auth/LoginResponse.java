package com.noteAPI.controller.responce.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LoginResponse {
    private boolean success;
    private String errorMessage;
    private String token;
    public LoginResponse success(String token) {
        return LoginResponse.builder().success(true).token(token).build();
    }

    public LoginResponse failed(String errorMessage) {
        return LoginResponse.builder().success(false).errorMessage(errorMessage).build();
    }
}
