package com.noteAPI.repository;

import com.noteAPI.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String username);

    @Query(value = "SELECT COUNT(u.*) FROM users u WHERE u.email = :email",
            nativeQuery = true)
    int countUserWithEmail(String email);

}
