package com.techzenacademy.management.controller;

import com.techzenacademy.management.dto.ApiResponse;
import com.techzenacademy.management.dto.Person.PersonDetailResponse;
import com.techzenacademy.management.dto.Person.PersonListItemResponse;
import com.techzenacademy.management.dto.Person.PersonRequest;
import com.techzenacademy.management.service.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/person")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "Person Management", description = "Person Management API")
public class PersonController {

    PersonService personService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PersonListItemResponse>>> getAllPeople() {
        List<PersonListItemResponse> responses = personService.getAllPerson();

        return ResponseEntity.ok(ApiResponse.<List<PersonListItemResponse>>builder()
                .success(true)
                .data(responses)
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PersonDetailResponse>> createPerson(@RequestBody PersonRequest request) {
        PersonDetailResponse personDetailResponse = personService.create(request);
        return ResponseEntity.ok(ApiResponse.<PersonDetailResponse>builder()
                .success(true)
                .data(personDetailResponse)
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PersonDetailResponse>> updatePerson(@PathVariable UUID id,
                                                                          @RequestBody PersonRequest request) {
        PersonDetailResponse personDetailResponse = personService.update(id, request);

        if (personDetailResponse == null) {
            return ResponseEntity.status(404).body(ApiResponse.<PersonDetailResponse>builder()
                    .success(false)
                    .error(ApiResponse.ApiError.builder()
                            .code("PERSON_NOT_FOUND")
                            .message("Person not found with id: " + id)
                            .path("/api/v1/people/" + id)
                            .build())
                    .build()
            );
        }
        return ResponseEntity.ok(ApiResponse.<PersonDetailResponse>builder()
                .success(true)
                .data(personDetailResponse)
                .build());
    }
}
