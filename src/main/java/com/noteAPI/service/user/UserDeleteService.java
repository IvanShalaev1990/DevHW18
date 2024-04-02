package com.noteAPI.service.user;

import com.noteAPI.controller.responce.user.UserDeleteResponse;
import com.noteAPI.database.entity.Role;
import com.noteAPI.database.entity.User;
import com.noteAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserDeleteService {
    private final UserRepository userRepository;
    private final UserDeleteResponse deleteResponse;
    public UserDeleteResponse deleteUserById(Principal principal, UUID id) {
        if (!userRepository.existsById(id)) {
            return deleteResponse.failed("User with id " + id + " not found");
        }
        User userFromPrincipal = userRepository.findByEmail(principal.getName()).orElseThrow();
        User userFromRequest = userRepository.findById(id).orElseThrow();
        if (!userFromRequest.equals(userFromPrincipal) && !userFromPrincipal.getRole().equals(Role.ADMIN)) {
            return deleteResponse.failed("User not authorized to delete user with id " + id);
        }
        userRepository.deleteById(id);
        return deleteResponse.success("User with id " + id + " was deleted");
    }
}
