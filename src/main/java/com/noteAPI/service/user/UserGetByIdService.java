package com.noteAPI.service.user;

import com.noteAPI.controller.responce.user.UserGetByIdResponse;
import com.noteAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserGetByIdService {
    private final UserRepository userRepository;
    private final UserGetByIdResponse userGetByIdResponse;
    public UserGetByIdResponse userGetById(UUID id) {
        if (!userRepository.existsById(id)) {
            return userGetByIdResponse.failed("Note with id " + id + " not found");
        }
        return userGetByIdResponse.success(userRepository.findById(id).orElseThrow());
    }
}
