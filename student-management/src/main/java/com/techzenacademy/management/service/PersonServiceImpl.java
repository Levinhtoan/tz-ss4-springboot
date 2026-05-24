package com.techzenacademy.management.service;

import com.techzenacademy.management.dto.Person.PersonDetailResponse;
import com.techzenacademy.management.dto.Person.PersonListItemResponse;
import com.techzenacademy.management.dto.Person.PersonRequest;
import com.techzenacademy.management.entity.Person;
import com.techzenacademy.management.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<PersonListItemResponse> getAllPerson() {
        List<Person> personList = personRepository.findAll();

        List<PersonListItemResponse> personListItemResponses = new ArrayList<>();


        for (Person person : personList) {
            PersonListItemResponse response = new PersonListItemResponse();

            response.setId(person.getId());

            response.setFullName(person.getFullName());

            response.setPhone(person.getPhone());

            personListItemResponses.add(response);

        }
        return personListItemResponses;
    }

    @Override
    public PersonDetailResponse create(PersonRequest request) {
        Person person = new Person();

        person.setFullName(request.getFullName());

        person.setDob(request.getDob());

        person.setPhone(request.getPhone());

        person.setContactEmail(request.getContactEmail());

        person.setAddress(request.getAddress());

        person = personRepository.save(person);


        PersonDetailResponse response = new PersonDetailResponse();

        response.setId(person.getId());

        response.setFullName(person.getFullName());

        response.setDob(person.getDob());

        response.setPhone(person.getPhone());

        response.setContactEmail(person.getContactEmail());

        response.setAddress(person.getAddress());

        return response;

    }

    @Override
    public PersonDetailResponse update(UUID id, PersonRequest request) {
        Person person = personRepository.findById(id).orElse(null);

        if (person == null) {
            return null;
        }

        person.setFullName(request.getFullName());

        person.setDob(request.getDob());

        person.setPhone(request.getPhone());

        person.setContactEmail(request.getContactEmail());

        person.setAddress(request.getAddress());

        person = personRepository.save(person);


        PersonDetailResponse response = new PersonDetailResponse();

        response.setId(person.getId());

        response.setFullName(person.getFullName());

        response.setDob(person.getDob());

        response.setPhone(person.getPhone());

        response.setContactEmail(person.getContactEmail());

        response.setAddress(person.getAddress());

        return response;
    }
}
