package com.noteAPI.controller.request.note;

import lombok.Data;

@Data
public class NoteCreateRequest {
    private String title;
    private String content;
}
