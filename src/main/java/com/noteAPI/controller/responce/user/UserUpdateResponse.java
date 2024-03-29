package com.noteAPI.controller.responce.user;

import com.noteAPI.controller.responce.note.NoteUpdateResponse;
import com.noteAPI.database.entity.Note;
import com.noteAPI.database.entity.User;
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
public class UserUpdateResponse {
    private boolean success;
    private String errorMessage;
    private User user;

    public UserUpdateResponse success(User user) {
        return UserUpdateResponse.builder().success(true).user(user).build();
    }

    public UserUpdateResponse failed(String errorMessage) {
        return UserUpdateResponse.builder().success(false).errorMessage(errorMessage).build();
    }
}
