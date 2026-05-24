package com.techzenacademy.management.controller;

import com.techzenacademy.management.dto.ApiResponse;
import com.techzenacademy.management.dto.student.*;
import com.techzenacademy.management.entity.Student;
import com.techzenacademy.management.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/students")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "Student Management", description = "Student Management API")
public class StudentController {
//    StudentService studentService;
//
//    @GetMapping
//    @Operation(summary = "Get all students", description = "Retrieve a list of all students from mock data")
//
//    public ResponseEntity<ApiResponse<List<StudentResponse>>> student() {
//        return ResponseEntity.ok(ApiResponse.<List<StudentResponse>>builder()
//                .success(true)
//                .data(studentService.findAll())
//                .build());
//    }
//
//    @GetMapping("/{id}")
//    @Operation(summary = "Get students by ID", description = "Retrieve a specific students by their UUID")
//    public ResponseEntity<ApiResponse<StudentResponse>> student(@PathVariable UUID id) {
//        StudentResponse studentResponse = studentService.findById(id);
//        if (studentResponse == null) {
//            return ResponseEntity.status(404).body(ApiResponse.<StudentResponse>builder()
//                    .success(false)
//                    .error(ApiResponse.ApiError.builder()
//                            .code("students_NOT_FOUND")
//                            .message("User not found with id: " + id)
//                            .path("/api/v1/users/" + id)
//                            .build())
//                    .build());
//        }
//        return ResponseEntity.ok(ApiResponse.<StudentResponse>builder()
//                .success(true)
//                .data(studentResponse)
//                .build());
//
//
//    }
//
//    @PostMapping
//    @Operation(summary = "Create students", description = "Add a new user to mock data")
//    public ResponseEntity<ApiResponse<StudentResponse>> createStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
//        StudentResponse studentResponse = studentService.createStudent(studentCreateRequest);
//        return ResponseEntity.status(201).body(ApiResponse.<StudentResponse>builder()
//                .success(true)
//                .data(studentResponse)
//                .build());
//    }
//
//    @PutMapping("/{id}")
//    @Operation(summary = "Update students", description = "Update an existing user's details")
//    public ResponseEntity<ApiResponse<StudentResponse>> update(@PathVariable UUID id, @RequestBody StudentUpdateRequest request) {
//        StudentResponse update = studentService.updateStudent(id, request);
//        if (update == null) {
//            return ResponseEntity.status(404).body(ApiResponse.<StudentResponse>builder()
//                    .success(false)
//                    .error(ApiResponse.ApiError.builder()
//                            .code("USER_NOT_FOUND")
//                            .message("User not found with id: " + id)
//                            .path("/api/v1/users/" + id)
//                            .build())
//                    .build());
//        }
//        return ResponseEntity.ok(ApiResponse.<StudentResponse>builder()
//                .success(true)
//                .data(update)
//                .build());
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete student", description = "Remove a student from mock data")
//    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable UUID id) {
//        boolean deleted = studentService.deleteById(id);
//        if (!deleted) {
//            return ResponseEntity.status(404).body(ApiResponse.<Void>builder()
//                    .success(false)
//                    .error(ApiResponse.ApiError.builder()
//                            .code("USER_NOT_FOUND")
//                            .message("User not found with id: " + id)
//                            .path("/api/v1/users/" + id)
//                            .build())
//                    .build());
//        }
//        return ResponseEntity.status(204).body(ApiResponse.<Void>builder()
//                .success(true)
//                .build());
//    }
//
//    @GetMapping("/exists")
//    @Operation(
//            summary = "Check email exists",
//            description = "Check whether a student email already exists"
//    )
//    public ResponseEntity<ApiResponse<Boolean>> existsByEmail(
//            @RequestParam String email
//    ) {
//
//        boolean exists =
//                studentService.existsByEmail(email);
//
//        return ResponseEntity.ok(
//                ApiResponse.<Boolean>builder()
//                        .success(true)
//                        .data(exists)
//                        .build()
//        );
//    }
//
//    @GetMapping("/email")
//    @Operation(
//            summary = "Get student by email",
//            description = "Retrieve a specific student by email"
//    )
//    public ResponseEntity<ApiResponse<StudentResponse>> findByEmail(
//            @RequestParam String email
//    ) {
//
//        StudentResponse studentResponse =
//                studentService.findByEmail(email);
//
//        return ResponseEntity.ok(
//                ApiResponse.<StudentResponse>builder()
//                        .success(true)
//                        .data(studentResponse)
//                        .build()
//        );
//    }
    StudentService studentService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentSearchResponse>>> getAllStudents(){

        List<StudentSearchResponse> students = studentService.getAllStudents();

        return ResponseEntity.ok(ApiResponse.<List<StudentSearchResponse>>builder()
                .success(true)
                .data(students)
                .build());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDetailResponse>> getStudentById(@PathVariable UUID id){
        StudentDetailResponse studentDetailResponse = studentService.findById(id);

        if(studentDetailResponse == null){
            return ResponseEntity.status(404).body(ApiResponse.<StudentDetailResponse>builder()
                    .success(false)
                    .error(ApiResponse.ApiError.builder()
                                    .code("USER_NOT_FOUND")
                            .message("User not found with id: " + id)
                            .path("/api/v1/users/" + id)
                            .build()).build());
        }

        return ResponseEntity.ok(ApiResponse.<StudentDetailResponse>builder()
                .success(true)
                .data(studentDetailResponse)
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentDetailResponse>> createStudent(@RequestBody StudentCreateRequest request){
        StudentDetailResponse studentDetailResponse = studentService.create(request);
        return ResponseEntity.ok(ApiResponse.<StudentDetailResponse>builder()
                .success(true)
                .data(studentDetailResponse)
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDetailResponse>> updateStudent(@PathVariable UUID id,
                                                                            @RequestBody StudentUpdateRequest request){
        StudentDetailResponse studentDetailResponse = studentService.update(id, request);

        if(studentDetailResponse == null){
            return ResponseEntity.status(404).body(ApiResponse.<StudentDetailResponse>builder()
                    .success(false)
                    .error(ApiResponse.ApiError.builder()
                            .code("STUDENT_NOT_FOUND")
                            .message("Student not found with id: " + id)
                            .path("/api/v1/students/" + id)
                            .build())
                    .build()
            );
        }
        return ResponseEntity.ok(ApiResponse.<StudentDetailResponse>builder()
                .success(true)
                .data(studentDetailResponse)
                .build());
    }

    @GetMapping("/summary")
    public ResponseEntity<ApiResponse<StudentSummaryResponse>> getAllStudentsSummary(){
        StudentSummaryResponse response = studentService.getSummary();

        return  ResponseEntity.ok(ApiResponse.<StudentSummaryResponse>builder()
                .success(true)
                .data(response)
                .build());
    }
}
