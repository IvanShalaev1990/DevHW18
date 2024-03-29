package com.noteAPI.controller.responce.user;

import com.noteAPI.controller.responce.note.NoteDeleteResponse;
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
public class UserDeleteResponse {
    private boolean success;
    private String message;


    public UserDeleteResponse success(String message) {
        return UserDeleteResponse.builder().success(true).message(message).build();
    }

    public UserDeleteResponse failed(String message) {
        return UserDeleteResponse.builder().success(false).message(message).build();
    }
}
