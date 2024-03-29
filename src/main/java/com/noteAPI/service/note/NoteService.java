package com.noteAPI.service.note;

import com.noteAPI.database.entity.Note;
import com.noteAPI.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public Note add(Note note) {
        return noteRepository.save(note);
    }


    public List<Note> listAll() {
        return noteRepository.findAll();
    }


    public Note getById(UUID id) throws Exception {
        Note note = Optional.ofNullable(noteRepository.findById(id))
                .get()
                .orElseThrow(() -> new Exception("Note with id " + id + " not found"));
        return note;
    }
    public List<Note> getByUserEmail(String userEmail) throws Exception {
        return noteRepository.findByUserEmailEmail(userEmail).stream()
                .map(Optional::ofNullable)
                .flatMap(Optional::stream).toList();
    }

    public void deleteById(UUID id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }
}
