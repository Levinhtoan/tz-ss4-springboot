package com.techzenacademy.management.mapper;

import com.techzenacademy.management.dto.student.StudentDetailResponse;
import com.techzenacademy.management.dto.student.StudentSearchResponse;
import com.techzenacademy.management.entity.Student;
import org.springframework.stereotype.Component;

@Component

public class StudentMapper {
    public StudentDetailResponse toDetailResponse(
            Student student
    ) {

        return StudentDetailResponse.builder()
                .id(student.getPersonId())
                .studentCode(student.getStudentCode())
                .enrollmentYear(student.getEnrollmentYear())
                .fullName(student.getPerson().getFullName())
                .dob(student.getPerson().getDob())
                .phone(student.getPerson().getPhone())
                .address(student.getPerson().getAddress())
                .username(student.getPerson().getUser().getUsername())
                .status(student.getPerson().getUser().getStatus().name())
                .build();
    }

    public StudentSearchResponse toSearchResponse(
            Student student
    ) {

        return StudentSearchResponse.builder()
                .id(student.getPersonId())
                .studentCode(student.getStudentCode())
                .fullName(student.getPerson().getFullName())
                .email(student.getPerson().getUser().getEmail())
                .enrollmentYear(student.getEnrollmentYear())
                .build();
    }
}
