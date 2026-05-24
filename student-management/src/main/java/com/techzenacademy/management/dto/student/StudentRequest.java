package com.techzenacademy.management.dto.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    String fullName;
    String dob;
    String phone;
    String email;
    String address;
}
