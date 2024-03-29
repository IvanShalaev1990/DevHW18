package com.noteAPI.controller.request.note;

import lombok.Data;

import java.util.UUID;
@Data
public class NoteGetByIdRequest {
    private UUID id;
}
