package com.noteAPI.controller;

import com.noteAPI.controller.request.note.NoteCreateRequest;
import com.noteAPI.controller.request.note.NoteDeleteRequest;
import com.noteAPI.controller.request.note.NoteUpdateRequest;
import com.noteAPI.controller.request.user.UserDeleteRequest;
import com.noteAPI.controller.request.user.UserUpdateRequest;
import com.noteAPI.controller.responce.note.NoteCreateResponse;
import com.noteAPI.controller.responce.note.NoteDeleteResponse;
import com.noteAPI.controller.responce.note.NoteGetByIdResponse;
import com.noteAPI.controller.responce.note.NoteUpdateResponse;
import com.noteAPI.controller.responce.user.UserDeleteResponse;
import com.noteAPI.controller.responce.user.UserUpdateResponse;
import com.noteAPI.database.entity.Note;
import com.noteAPI.database.entity.User;
import com.noteAPI.service.auth.AuthService;
import com.noteAPI.service.note.*;
import com.noteAPI.service.user.UserDeleteService;
import com.noteAPI.service.user.UserInfoService;
import com.noteAPI.service.user.UserUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final NoteCreateService noteCreateService;
    private final NoteDeleteService noteDeleteService;
    private final NoteGetByIdService noteGetByIdService;
    private final NoteUpdateService noteUpdateService;
    private final NoteService noteService;
    private final UserInfoService userInfoService;
    private final UserDeleteService userDeleteService;
    private final UserUpdateService userUpdateService;
    private static final Logger LOG = LoggerFactory.getLogger(AuthService.class);


    @GetMapping("/note/list")
    public ResponseEntity<List<Note>> notesList(@Autowired Principal principal) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(noteService.getByUserEmail(principal.getName()));
    }

    @PostMapping("/note/create")
    public NoteCreateResponse createNote(@Autowired Principal principal, @RequestBody NoteCreateRequest request) {
        return noteCreateService.noteCreate(principal, request);
    }

    @PostMapping("/note/delete")
    public NoteDeleteResponse delete(@Autowired Principal principal, @RequestBody NoteDeleteRequest request) {
        return noteDeleteService.deleteNoteById(principal, request.getId());
    }
    @GetMapping("/note/getById/{id}")
    public NoteGetByIdResponse getByIdNote(@Autowired Principal principal, @PathVariable("id") UUID id) {
        return noteGetByIdService.noteGetById(principal,id);
    }
    @PostMapping("/note/update")
    public NoteUpdateResponse update(@Autowired Principal principal, @RequestBody NoteUpdateRequest request) {
        return noteUpdateService.noteUpdate(principal,request);
    }
    @GetMapping("/info")
    public User userInfo(@Autowired Principal principal) {
        return userInfoService.getUserInfo(principal);
    }
    @PostMapping("/delete")
    public UserDeleteResponse delete(@Autowired Principal principal, @RequestBody UserDeleteRequest request) {
        return userDeleteService.deleteUserById(principal, request.getId());
    }
    @PostMapping("/update")
    public UserUpdateResponse update(@Autowired Principal principal, @RequestBody UserUpdateRequest request) {
        return userUpdateService.userUpdate(principal, request);
    }
}
