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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public NoteDeleteResponse delete(@RequestBody NoteDeleteRequest request) {
     return noteDeleteService.deleteNoteById(request.getId());
    }
    @GetMapping("/note/getById/{id}")
    public NoteGetByIdResponse getByIdNote(@PathVariable("id")UUID id) {
        return noteGetByIdService.noteGetById(id);
    }
    @PostMapping("/note/update")
    public NoteUpdateResponse update(@RequestBody NoteUpdateRequest request) {
        return noteUpdateService.noteUpdate(request);
    }
    @PostMapping("/user/delete")
    public UserDeleteResponse delete(@RequestBody UserDeleteRequest request) {
        return userDeleteService.deleteUserById(request.getId());
    }
    @GetMapping("/user/getById/{id}")
    public UserGetByIdResponse getByIdUser(@PathVariable("id")UUID id) {
        return userGetByIdService.userGetById(id);
    }
    @PostMapping("/user/update")
    public UserUpdateResponse update(@RequestBody UserUpdateRequest request) {
        return userUpdateService.userUpdate(request);
    }
}
