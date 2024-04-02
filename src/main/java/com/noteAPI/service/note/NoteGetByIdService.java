package com.noteAPI.service.note;

import com.noteAPI.controller.responce.note.NoteGetByIdResponse;
import com.noteAPI.database.entity.Note;
import com.noteAPI.database.entity.Role;
import com.noteAPI.database.entity.User;
import com.noteAPI.repository.NoteRepository;
import com.noteAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteGetByIdService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final NoteGetByIdResponse noteGetByIdResponse;
    public NoteGetByIdResponse noteGetById(Principal principal, UUID id) {
        if (!noteRepository.existsById(id)) {
            return noteGetByIdResponse.failed("Note with id " + id + " not found");
        }
        Note note = noteRepository.findById(id).get();
        User user = userRepository.findByEmail(principal.getName()).orElseThrow();
        if (!note.getUserEmail().getEmail().equals(user.getEmail()) && !user.getRole().equals(Role.ADMIN)) {
            return noteGetByIdResponse.failed("User not authorized to assess note with id " + id);
        }
        return noteGetByIdResponse.success(noteRepository.findById(id).orElseThrow());
    }
}
