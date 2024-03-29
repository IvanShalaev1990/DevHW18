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
public class NoteUpdateResponse {
    private boolean success;
    private String errorMessage;
    private Note note;

    public NoteUpdateResponse success(Note note) {
        return NoteUpdateResponse.builder().success(true).note(note).build();
    }

    public NoteUpdateResponse failed(String errorMessage) {
        return NoteUpdateResponse.builder().success(false).errorMessage(errorMessage).build();
    }
}
