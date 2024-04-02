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
public class NoteCreateResponse {

    private boolean success;
    private String errorMessage;
    private Note note;
    public NoteCreateResponse success(Note note) {
        return NoteCreateResponse.builder().success(true).note(note).build();
    }

    public NoteCreateResponse failed(String errorMessage) {
        return NoteCreateResponse.builder().success(false).errorMessage(errorMessage).build();
    }
}
