package com.noteAPI.controller;

import com.noteAPI.database.entity.Note;
import com.noteAPI.service.note.NoteService;
import com.noteAPI.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;
    private NoteService noteService;

    @Autowired
    public UserController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @GetMapping("/note/list")
    public ResponseEntity<List<Note>> notesList(@Autowired Principal principal) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(noteService.getByUserEmail(principal.getName()));
    }


}
