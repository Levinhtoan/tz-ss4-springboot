package com.techzenacademy.management.dto.Person;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonListItemResponse {
    UUID id;
    String fullName;
    String phone;
}
