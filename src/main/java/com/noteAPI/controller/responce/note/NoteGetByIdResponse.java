package com.noteAPI.controller.responce.note;

import com.noteAPI.database.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NoteGetByIdResponse {
    private boolean success;
    private String errorMessage;
    private Note note;

    public NoteGetByIdResponse success(Note note) {
        return NoteGetByIdResponse.builder().success(true).note(note).build();
    }

    public NoteGetByIdResponse failed(String errorMessage) {
        return NoteGetByIdResponse.builder().success(false).errorMessage(errorMessage).build();
    }
}
