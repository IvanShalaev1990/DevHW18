package com.noteAPI.service.note;

import com.noteAPI.controller.request.note.NoteCreateRequest;
import com.noteAPI.controller.responce.note.NoteCreateResponse;
import com.noteAPI.database.entity.Note;
import com.noteAPI.database.entity.User;
import com.noteAPI.repository.NoteRepository;
import com.noteAPI.repository.UserRepository;
import com.noteAPI.service.auth.AuthService;
import com.noteAPI.validation.NoteValidationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class NoteCreateService {
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;
    private final NoteCreateResponse noteCreateResponse;
    private final NoteValidationService noteValidationService;

    public NoteCreateResponse noteCreate(Principal principal, NoteCreateRequest request) {
        if (!noteValidationService.isTitleValid(request.getTitle())) {
            return noteCreateResponse.failed("Title is not valid");
        }
        if (!noteValidationService.isContentValid(request.getContent())) {
            return noteCreateResponse.failed("Content is not valid");
        }
        User user = userRepository.findByEmail(principal.getName()).orElseThrow();
        Note note = Note.builder().userEmail(user).title(request.getTitle()).content(request.getContent()).build();

        return noteCreateResponse.success(noteRepository.save(note));
    }
}
