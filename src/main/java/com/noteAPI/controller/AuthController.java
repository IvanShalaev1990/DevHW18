package com.noteAPI.controller;

import com.noteAPI.controller.request.auth.LoginRequest;
import com.noteAPI.controller.request.auth.RegisterRequest;
import com.noteAPI.controller.responce.auth.LoginResponse;
import com.noteAPI.controller.responce.auth.RegisterResponse;
import com.noteAPI.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest userLogin) {
        return authService.login(userLogin);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest userRegister) {
        return authService.register(userRegister);
    }
}
