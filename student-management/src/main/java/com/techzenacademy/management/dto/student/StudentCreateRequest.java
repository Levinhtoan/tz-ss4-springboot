package com.techzenacademy.management.dto.student;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRequest {
    String studentCode;
    Integer enrollmentYear;
    String fullName;
    LocalDate dob;
    String phone;
    String email;
    String address;
    String username;
    String password;
}
