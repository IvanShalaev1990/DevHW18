package com.noteAPI.service.auth;

import com.noteAPI.config.jwt.JwtUtil;
import com.noteAPI.controller.request.auth.LoginRequest;
import com.noteAPI.controller.request.auth.RegisterRequest;
import com.noteAPI.controller.responce.auth.LoginResponse;
import com.noteAPI.controller.responce.auth.RegisterResponse;
import com.noteAPI.database.entity.User;
import com.noteAPI.service.user.UserService;
import com.noteAPI.validation.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final LoginResponse loginResponse;
    private final RegisterResponse registerResponse;
    private final UserValidationService userValidationService;
    private static final Logger LOG = LoggerFactory.getLogger(AuthService.class);


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public RegisterResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPasswordHash()))
                .name(request.getName())
                .role(request.getRole())
                .age(request.getAge())
                .build();
        if (!userValidationService.isEmailValid(request.getEmail())) {
            return registerResponse.failed("Email is not available");
        }
        if (!userValidationService.isPasswordValid(request.getPasswordHash())) {
            return registerResponse.failed("Password is not valid");
        }
        if (!userValidationService.isNameValid(request.getName())) {
            return registerResponse.failed("Name is not valid");
        }
        if (!userValidationService.isRoleValid(request.getRole())) {
            return registerResponse.failed("Role is not valid");
        }
        if (!userValidationService.isAgeValid(request.getAge())) {
            return registerResponse.failed("Age is not valid");
        }
        return registerResponse.success(userService.save(user));
    }


    public LoginResponse login(LoginRequest request) {

        User user = userService.getUserByEmail(request.getEmail());
        if (Objects.isNull(user)) {
            return loginResponse.failed("Invalid email");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            return loginResponse.failed("Password is not valid");
        }
        String authToken = jwtUtil.generateToken(request.getEmail());
        return loginResponse.success(authToken);
    }


}
