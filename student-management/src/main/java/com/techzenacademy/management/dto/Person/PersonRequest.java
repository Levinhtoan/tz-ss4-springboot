package com.techzenacademy.management.dto.Person;

import java.time.LocalDate;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonRequest {
    String fullName;
    LocalDate dob;
    String phone;
    String contactEmail;
    String address;
}
