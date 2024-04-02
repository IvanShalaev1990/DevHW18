package com.noteAPI.controller;

import com.noteAPI.controller.request.note.NoteDeleteRequest;
import com.noteAPI.controller.request.note.NoteUpdateRequest;
import com.noteAPI.controller.request.user.UserDeleteRequest;
import com.noteAPI.controller.request.user.UserUpdateRequest;
import com.noteAPI.controller.responce.note.NoteDeleteResponse;
import com.noteAPI.controller.responce.note.NoteGetByIdResponse;
import com.noteAPI.controller.responce.note.NoteUpdateResponse;
import com.noteAPI.controller.responce.user.UserDeleteResponse;
import com.noteAPI.controller.responce.user.UserGetByIdResponse;
import com.noteAPI.controller.responce.user.UserUpdateResponse;
import com.noteAPI.database.entity.Note;
import com.noteAPI.database.entity.User;
import com.noteAPI.service.note.NoteDeleteService;
import com.noteAPI.service.note.NoteGetByIdService;
import com.noteAPI.service.note.NoteService;
import com.noteAPI.service.user.UserDeleteService;
import com.noteAPI.service.user.UserGetByIdService;
import com.noteAPI.service.user.UserService;
import com.noteAPI.service.note.NoteUpdateService;
import com.noteAPI.service.user.UserUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final UserService userService;
    private final UserDeleteService userDeleteService;
    private final UserGetByIdService userGetByIdService;
    private final UserUpdateService userUpdateService;
    private final NoteService noteService;
    private final NoteDeleteService noteDeleteService;
    private final NoteGetByIdService noteGetByIdService;
    private final NoteUpdateService noteUpdateService;

    @GetMapping("/note/list")
    public ResponseEntity<List<Note>> notesList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(noteService.listAll());
    }

    @GetMapping("/user/list")
    public ResponseEntity<List<User>> usersList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.listAll());
    }

    @PostMapping("/note/delete")
    public NoteDeleteResponse deleteNote(@Autowired Principal principal, @RequestBody NoteDeleteRequest request) {
        return noteDeleteService.deleteNoteById(principal, request.getId());
    }

    @GetMapping("/note/getById/{id}")
    public NoteGetByIdResponse getByIdNote(@Autowired Principal principal, @PathVariable("id") UUID id) {
        return noteGetByIdService.noteGetById(principal, id);
    }

    @PostMapping("/note/update")
    public NoteUpdateResponse updateNote(@Autowired Principal principal, @RequestBody NoteUpdateRequest request) {
        return noteUpdateService.noteUpdate(principal, request);
    }

    @PostMapping("/user/delete")
    public UserDeleteResponse deleteUser(@Autowired Principal principal, @RequestBody UserDeleteRequest request) {
        return userDeleteService.deleteUserById(principal, request.getId());
    }

    @GetMapping("/user/getById/{id}")
    public UserGetByIdResponse getByIdUser(@PathVariable("id") UUID id) {
        return userGetByIdService.userGetById(id);
    }

    @PostMapping("/user/update")
    public UserUpdateResponse updateUser(@Autowired Principal principal, @RequestBody UserUpdateRequest request) {
        return userUpdateService.userUpdate(principal, request);
    }
}
