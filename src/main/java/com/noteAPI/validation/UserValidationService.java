package com.noteAPI.validation;

import com.noteAPI.database.entity.Role;
import com.noteAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidationService {
    private final UserRepository userRepository;

    public boolean isEmailValid(String email) {
        return userRepository.countUserWithEmail(email) == 0;
    }

    public boolean isPasswordValid(String password) {
        return password != null && !password.isEmpty();
    }

    public boolean isNameValid(String name) {
        return name != null && !name.isEmpty();
    }

    public boolean isRoleValid(Role role) {
        return role.equals(Role.USER) || role.equals(Role.ADMIN);
    }

    public boolean isAgeValid(int age) {
        return age > 12;
    }
}
