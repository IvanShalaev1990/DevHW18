package com.noteAPI.service.user;

import com.noteAPI.controller.responce.note.NoteDeleteResponse;
import com.noteAPI.controller.responce.user.UserDeleteResponse;
import com.noteAPI.database.entity.User;
import com.noteAPI.repository.NoteRepository;
import com.noteAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserDeleteService {
    private final UserRepository userRepository;
    private final UserDeleteResponse deleteResponse;
    public UserDeleteResponse deleteUserById(UUID id) {
        if (!userRepository.existsById(id)) {
            return deleteResponse.failed("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
        return deleteResponse.success("User with id " + id + " was deleted");
    }
}
