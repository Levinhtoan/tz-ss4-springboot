package com.techzenacademy.management.service;

import com.techzenacademy.management.dto.user.UserResponse;
import com.techzenacademy.management.dto.user.UserStatusRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse updateStatus(UUID id, UserStatusRequest request
    );
}
