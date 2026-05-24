package com.techzenacademy.management.dto.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentUpdateRequest {
    Integer enrollmentYear;
    String fullName;
    LocalDate dob;
    String phone;
    String email;
    String address;
}
