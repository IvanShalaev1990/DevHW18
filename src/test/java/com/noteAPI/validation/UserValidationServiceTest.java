package com.noteAPI.validation;

import com.noteAPI.database.entity.Role;
import com.noteAPI.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserValidationServiceTest {
    @Mock
    Role role;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserValidationService userValidationService;

    @Test
    public void testIsEmailValid_WhenNoUserWithEmailExists_ReturnsTrue() {
        // Arrange
        when(userRepository.countUserWithEmail(anyString())).thenReturn(0);

        // Act
        boolean result = userValidationService.isEmailValid("test@example.com");

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsEmailValid_WhenUserWithEmailExists_ReturnsFalse() {
        // Arrange
        when(userRepository.countUserWithEmail(anyString())).thenReturn(1);

        // Act
        boolean result = userValidationService.isEmailValid("existing@example.com");

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsPasswordValid_WhenPasswordIsNull_ReturnsFalse() {
        // Act
        boolean result = userValidationService.isPasswordValid(null);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsPasswordValid_WhenPasswordIsEmpty_ReturnsFalse() {
        // Act
        boolean result = userValidationService.isPasswordValid("");

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsNameValid_WhenNameIsNull_ReturnsFalse() {
        // Act
        boolean result = userValidationService.isNameValid(null);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsNameValid_WhenNameIsEmpty_ReturnsFalse() {
        // Act
        boolean result = userValidationService.isNameValid("");

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsRoleValid_WhenRoleIsUser_ReturnsTrue() {
        // Act
        boolean result = userValidationService.isRoleValid(Role.USER);

        // Assert
        assertTrue(result);
    }
    @Test
    public void testIsRoleValid_WhenRoleIsInvalid_ReturnsFalse() {
        Role invalidRole = mock(Role.class);

        // Act
        boolean result = userValidationService.isRoleValid(invalidRole);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsRoleValid_WhenRoleIsAdmin_ReturnsTrue() {
        // Act
        boolean result = userValidationService.isRoleValid(Role.ADMIN);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAgeValid_WhenAgeIsLessThanThirteen_ReturnsFalse() {
        // Act
        boolean result = userValidationService.isAgeValid(12);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAgeValid_WhenAgeIsThirteen_ReturnsTrue() {
        // Act
        boolean result = userValidationService.isAgeValid(13);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAgeValid_WhenAgeIsGreaterThanThirteen_ReturnsTrue() {
        // Act
        boolean result = userValidationService.isAgeValid(14);

        // Assert
        assertTrue(result);
    }
}