package com.noteAPI.controller.request.note;

import lombok.Data;

import java.util.UUID;

@Data
public class NoteUpdateRequest {
    private UUID id;
    private String title;
    private String content;
}
