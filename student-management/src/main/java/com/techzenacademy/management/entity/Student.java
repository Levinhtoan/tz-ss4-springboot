package com.techzenacademy.management.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "person_id")
    UUID personId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "person_id")
    Person person;

    @Column(name = "student_code", nullable = false, unique = true)
    String studentCode;

    @Column(name = "enrollment_year")
    Integer enrollmentYear;

    @Column(name = "created_at", insertable = false, updatable = false)
    Instant createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    Instant updatedAt;
}
