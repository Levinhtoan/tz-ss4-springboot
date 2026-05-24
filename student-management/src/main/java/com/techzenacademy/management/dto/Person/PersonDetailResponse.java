package com.techzenacademy.management.dto.Person;

import java.time.LocalDate;
import java.util.UUID;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDetailResponse {
    UUID id;
    String fullName;
    LocalDate dob;
    String phone;
    String contactEmail;
    String address;
}
