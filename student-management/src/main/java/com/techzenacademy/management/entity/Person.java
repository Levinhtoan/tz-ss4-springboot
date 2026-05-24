package com.techzenacademy.management.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue
    UUID id;
    String fullName;
    LocalDate dob;
    String phone;
    String contactEmail;
    String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "created_at", insertable = false, updatable = false)
    Instant createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    Instant updatedAt;
}
