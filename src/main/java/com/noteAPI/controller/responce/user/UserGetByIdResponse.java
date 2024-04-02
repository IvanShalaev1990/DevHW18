package com.noteAPI.controller.responce.user;

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
public class UserGetByIdResponse {
    private boolean success;
    private String errorMessage;
    private User user;

    public UserGetByIdResponse success(User user) {
        return UserGetByIdResponse.builder().success(true).user(user).build();
    }

    public UserGetByIdResponse failed(String errorMessage) {
        return UserGetByIdResponse.builder().success(false).errorMessage(errorMessage).build();
    }
}
