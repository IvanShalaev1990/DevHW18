package com.noteAPI.service.user;

import com.noteAPI.database.entity.User;
import com.noteAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserRepository userRepository;

    public User getUserInfo(Principal principal) {
        return userRepository.findByEmail(principal.getName()).orElseThrow();
    }
}
