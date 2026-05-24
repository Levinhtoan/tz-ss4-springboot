package com.techzenacademy.management.service;

import com.techzenacademy.management.dto.student.*;
import com.techzenacademy.management.entity.Person;
import com.techzenacademy.management.entity.Student;
import com.techzenacademy.management.entity.User;
import com.techzenacademy.management.entity.UserStatus;
import com.techzenacademy.management.mapper.StudentMapper;
import com.techzenacademy.management.repository.PersonRepository;
import com.techzenacademy.management.repository.StudentRepository;
import com.techzenacademy.management.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentSearchResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        List<StudentSearchResponse> responses = new ArrayList<>();

        for (Student student : students) {
            responses.add(studentMapper.toSearchResponse(student)
            );

        }
        return responses;
    }

    @Override
    public StudentDetailResponse findById(UUID id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        return studentMapper.toDetailResponse(student);
    }

    @Transactional
    @Override
    public StudentDetailResponse create(StudentCreateRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        //USER
        User newUser = new User();

        newUser.setUsername(request.getUsername());


        newUser.setEmail(request.getEmail());

        newUser.setPasswordHash(request.getPassword());

        newUser.setStatus(UserStatus.ACTIVE);

        newUser = userRepository.save(newUser);


        //PERSON
        Person person = new Person();

        person.setFullName(request.getFullName());

        person.setDob(request.getDob());

        person.setPhone(request.getPhone());

        person.setContactEmail(request.getEmail());

        person.setAddress(request.getAddress());

        person.setUser(newUser);

        person = personRepository.save(person);


        //STUDENT
        Student student = new Student();

        student.setPerson(person);

        student.setStudentCode(
                request.getStudentCode()
        );

        student.setEnrollmentYear(
                request.getEnrollmentYear()
        );

        student = studentRepository.save(student);
        //RESPONSE
        return studentMapper.toDetailResponse(student);

    }

    @Transactional
    @Override
    public StudentDetailResponse update(UUID id, StudentUpdateRequest request) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setEnrollmentYear(request.getEnrollmentYear());

        student = studentRepository.save(student);


        Person person = student.getPerson();

        person.setFullName(request.getFullName());

        person.setDob(request.getDob());

        person.setPhone(request.getPhone());

        person.setAddress(request.getAddress());

        person.setContactEmail(request.getEmail());

        personRepository.save(person);

        return studentMapper.toDetailResponse(student);
    }

    @Override
    public StudentSummaryResponse getSummary() {
        Long totalStudents = studentRepository.count();

        Long activeAccounts = userRepository.countByStatus(UserStatus.ACTIVE);

        Student latestStudent = studentRepository.findlastestStudent();


        return StudentSummaryResponse.builder()
                .totalStudents(totalStudents)
                .activeAccounts(activeAccounts)
                .latestStudentName(
                        latestStudent.getPerson().getFullName()
                )
                .build();
    }

}
