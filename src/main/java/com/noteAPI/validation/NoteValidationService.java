package com.noteAPI.validation;

import org.springframework.stereotype.Service;

@Service
public class NoteValidationService {
    public boolean isTitleValid(String title) {
        return title != null && !title.isEmpty();
    }
    public boolean isContentValid(String content) {
        return content != null && !content.isEmpty();
    }
}
