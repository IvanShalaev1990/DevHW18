package com.noteAPI.service.note;

import com.noteAPI.controller.responce.note.NoteGetByIdResponse;
import com.noteAPI.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteGetByIdService {
    private final NoteRepository noteRepository;
    private final NoteGetByIdResponse noteGetByIdResponse;
    public NoteGetByIdResponse noteGetById(UUID id) {
        if (!noteRepository.existsById(id)) {
            return noteGetByIdResponse.failed("Note with id " + id + " not found");
        }
        return noteGetByIdResponse.success(noteRepository.findById(id).orElseThrow());
    }
}
