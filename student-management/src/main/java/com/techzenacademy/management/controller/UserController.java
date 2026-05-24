package com.techzenacademy.management.controller;

import com.techzenacademy.management.dto.ApiResponse;
import com.techzenacademy.management.dto.user.UserRequest;
import com.techzenacademy.management.dto.user.UserResponse;
import com.techzenacademy.management.dto.user.UserStatusRequest;
import com.techzenacademy.management.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "User Management", description = "User Management API")
public class UserController {
    UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {

        List<UserResponse> responses = userService.getAllUsers();

        return ResponseEntity.ok(ApiResponse.<List<UserResponse>>builder()
                        .success(true)
                        .data(responses)
                        .build()
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<UserResponse>> updateStatus(@PathVariable UUID id, @RequestBody UserStatusRequest request) {

        UserResponse response = userService.updateStatus(id, request);

        if (response == null) {
            return ResponseEntity.status(404).body(ApiResponse.<UserResponse>builder()
                            .success(false)
                            .error(ApiResponse.ApiError.builder()
                                            .code("USER_NOT_FOUND")
                                            .message("User not found with id: " + id)
                                            .path("/api/v1/users/" + id + "/status")
                                            .build())
                            .build()
            );
        }

        return ResponseEntity.ok(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .data(response)
                        .build()
        );
    }
}
