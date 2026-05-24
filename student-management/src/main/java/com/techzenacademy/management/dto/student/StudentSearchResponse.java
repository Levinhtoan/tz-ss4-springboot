package com.techzenacademy.management.dto.student;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentSearchResponse {
    UUID id;
    String studentCode;
    String fullName;
    String email;
    Integer enrollmentYear;
}
