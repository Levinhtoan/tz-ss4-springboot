package com.techzenacademy.management.dto.student;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDetailResponse {

    private UUID id;

    private String studentCode;

    private Integer enrollmentYear;

    private String fullName;

    private LocalDate dob;

    private String phone;

    private String address;

    private String username;

    private String status;
}
