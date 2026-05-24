package com.techzenacademy.management.dto.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStatusRequest {
    private String status;
}
