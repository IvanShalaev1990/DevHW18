package com.noteAPI.service.note;

import com.noteAPI.controller.responce.note.NoteDeleteResponse;
import com.noteAPI.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteDeleteService {
    private final NoteRepository noteRepository;
    private final NoteDeleteResponse deleteResponse;
    public NoteDeleteResponse deleteNoteById(UUID id) {
        if (!noteRepository.existsById(id)) {
            return deleteResponse.failed("Note with id " + id + " not found");
        }
        noteRepository.deleteById(id);
        return deleteResponse.success("Note with id " + id + " was deleted");
    }
}
