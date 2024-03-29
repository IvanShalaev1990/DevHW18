package com.noteAPI.controller.responce.note;

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
public class NoteDeleteResponse {
    private boolean success;
    private String message;


    public NoteDeleteResponse success(String message) {
        return NoteDeleteResponse.builder().success(true).message(message).build();
    }

    public NoteDeleteResponse failed(String message) {
        return NoteDeleteResponse.builder().success(false).message(message).build();
    }
}
