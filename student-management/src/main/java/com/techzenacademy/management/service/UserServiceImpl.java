package com.techzenacademy.management.service;

import com.techzenacademy.management.dto.user.UserResponse;
import com.techzenacademy.management.dto.user.UserStatusRequest;
import com.techzenacademy.management.entity.User;
import com.techzenacademy.management.entity.UserStatus;
import com.techzenacademy.management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {

        List<User> users =
                userRepository.findAll();

        List<UserResponse> responses =
                new ArrayList<>();

        for (User user : users) {

            UserResponse response =
                    new UserResponse();

            response.setId(user.getId());

            response.setUsername(
                    user.getUsername()
            );

            response.setEmail(
                    user.getEmail()
            );

            response.setStatus(
                    user.getStatus().name()
            );

            responses.add(response);
        }

        return responses;
    }

    @Override
    public UserResponse updateStatus(UUID id, UserStatusRequest request) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        //String -> Enum
        UserStatus status = UserStatus.valueOf(request.getStatus());

        user.setStatus(status);

        user = userRepository.save(user);

        UserResponse response = new UserResponse();

        response.setId(user.getId());

        response.setUsername(user.getUsername());

        response.setEmail(user.getEmail());

        response.setStatus(user.getStatus().name());

        return response;
    }
}
