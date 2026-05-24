package com.techzenacademy.management.service;

import com.techzenacademy.management.dto.Person.PersonDetailResponse;
import com.techzenacademy.management.dto.Person.PersonListItemResponse;
import com.techzenacademy.management.dto.Person.PersonRequest;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<PersonListItemResponse> getAllPerson();

    PersonDetailResponse create(PersonRequest request);

    PersonDetailResponse update(UUID id, PersonRequest request);
}
