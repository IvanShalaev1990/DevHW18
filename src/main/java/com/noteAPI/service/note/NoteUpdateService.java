package com.noteAPI.service.note;

import com.noteAPI.controller.request.note.NoteUpdateRequest;
import com.noteAPI.controller.responce.note.NoteUpdateResponse;
import com.noteAPI.database.entity.Note;
import com.noteAPI.database.entity.Role;
import com.noteAPI.database.entity.User;
import com.noteAPI.repository.NoteRepository;
import com.noteAPI.repository.UserRepository;
import com.noteAPI.validation.NoteValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class NoteUpdateService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final NoteUpdateResponse noteUpdateResponse;
    private final NoteValidationService noteValidationService;

    public NoteUpdateResponse noteUpdate(Principal principal, NoteUpdateRequest request) {
        if (!noteRepository.existsById(request.getId())) {
            return noteUpdateResponse.failed("Note with id " + request.getId() + " not found");
        }
        if (!noteValidationService.isTitleValid(request.getTitle())) {
            return noteUpdateResponse.failed("Title is not valid");
        }
        if (!noteValidationService.isContentValid(request.getContent())) {
            return noteUpdateResponse.failed("Content is not valid");
        }
        Note note = noteRepository.findById(request.getId()).orElseThrow();
        User user = userRepository.findByEmail(principal.getName()).orElseThrow();
        if (!note.getUserEmail().getEmail().equals(user.getEmail()) && !user.getRole().equals(Role.ADMIN)) {
            return noteUpdateResponse.failed("User not authorized to assess note with id " + request.getId());
        }
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        return noteUpdateResponse.success(noteRepository.save(note));
    }
}
