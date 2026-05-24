package com.techzenacademy.management.dto.student;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentSummaryResponse {
    Long totalStudents;       // Tổng số học viên
    Long activeAccounts;      // Số lượng học viên có tài khoản ACTIVE
    String latestStudentName;
}
