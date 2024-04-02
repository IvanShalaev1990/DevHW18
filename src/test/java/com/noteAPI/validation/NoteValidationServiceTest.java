package com.noteAPI.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NoteValidationServiceTest {
    @Autowired
    private NoteValidationService noteValidationService;

    @Test
    public void testIsTitleValid() {
        assertTrue(noteValidationService.isTitleValid("Valid title"));
    }

    @Test
    public void testIsTitleInvalid() {
        assertFalse(noteValidationService.isTitleValid(null));
    }

    @Test
    public void testIsContentValid() {
        assertTrue(noteValidationService.isContentValid("Valid content"));
    }

    @Test
    public void testIsContentInvalid() {
        assertFalse(noteValidationService.isContentValid(null));
    }
}