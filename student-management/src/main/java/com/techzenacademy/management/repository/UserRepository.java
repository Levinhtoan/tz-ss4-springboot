package com.techzenacademy.management.repository;

import com.techzenacademy.management.entity.User;
import com.techzenacademy.management.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

//    @Query("""
//            SELECT COUNT(u)
//            FROM User u
//            WHERE u.status = :status
//            """)
//    Long countActiveAccounts(
//            @Param("status")
//            UserStatus status
//    );
    Long countByStatus(UserStatus userStatus);
}
