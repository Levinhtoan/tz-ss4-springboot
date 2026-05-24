package com.techzenacademy.management.service;


import com.techzenacademy.management.dto.student.*;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<StudentSearchResponse> getAllStudents();
    StudentDetailResponse findById(UUID id);
    StudentDetailResponse create(StudentCreateRequest request);
    StudentDetailResponse update(UUID id, StudentUpdateRequest request);
    StudentSummaryResponse getSummary();
}
