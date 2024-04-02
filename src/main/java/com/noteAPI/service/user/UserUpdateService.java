package com.noteAPI.service.user;

import com.noteAPI.controller.request.user.UserUpdateRequest;
import com.noteAPI.controller.responce.user.UserUpdateResponse;
import com.noteAPI.database.entity.Role;
import com.noteAPI.database.entity.User;
import com.noteAPI.repository.UserRepository;
import com.noteAPI.validation.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserUpdateService {
    private final UserRepository userRepository;
    private final UserUpdateResponse userUpdateResponse;
    private final UserValidationService userValidationService;

    public UserUpdateResponse userUpdate(Principal principal,UserUpdateRequest request) {
        if (!userRepository.existsById(request.getId())) {
            return userUpdateResponse.failed("User with id " + request.getId() + " not found");
        }
        User userFromPrincipal = userRepository.findByEmail(principal.getName()).orElseThrow();
        User userFromRequest = userRepository.findById(request.getId()).orElseThrow();
        if (!userFromRequest.equals(userFromPrincipal) && !userFromPrincipal.getRole().equals(Role.ADMIN)) {
            return userUpdateResponse.failed("User not authorized to update user with id " + request.getId());
        }
        if (!userFromRequest.getEmail().equals(request.getEmail()) &&
                !userValidationService.isEmailValid(request.getEmail())) {
                return userUpdateResponse.failed("Email is not available");
        }
        if (!userValidationService.isPasswordValid(request.getPasswordHash())) {
            return userUpdateResponse.failed("Password is not valid");
        }
        if (!userValidationService.isNameValid(request.getName())) {
            return userUpdateResponse.failed("Name is not valid");
        }
        if (!userValidationService.isRoleValid(request.getRole())) {
            return userUpdateResponse.failed("Role is not valid");
        }
        if (!userValidationService.isAgeValid(request.getAge())) {
            return userUpdateResponse.failed("Age is not valid");
        }
        userFromRequest.setEmail(request.getEmail());
        userFromRequest.setPasswordHash(request.getPasswordHash());
        userFromRequest.setRole(request.getRole());
        userFromRequest.setName(request.getName());
        userFromRequest.setAge(request.getAge());
        return userUpdateResponse.success(userRepository.save(userFromRequest));
    }

}
