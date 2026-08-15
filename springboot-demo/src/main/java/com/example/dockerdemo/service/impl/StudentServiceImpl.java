package com.example.dockerdemo.service.impl;

import com.example.dockerdemo.dto.StudentRequest;
import com.example.dockerdemo.dto.StudentResponse;
import com.example.dockerdemo.entity.Student;
import com.example.dockerdemo.exception.StudentNotFoundException;
import com.example.dockerdemo.repository.StudentRepository;
import com.example.dockerdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public StudentResponse create(StudentRequest request) {

        Student student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .course(request.getCourse())
                .build();

        Student saved = repository.save(student);

        return map(saved);
    }

    @Override
    public List<StudentResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public StudentResponse findById(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        return map(student);
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setCourse(request.getCourse());

        return map(repository.save(student));
    }

    @Override
    public void delete(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        repository.delete(student);

    }

    private StudentResponse map(Student student) {

        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .course(student.getCourse())
                .build();
    }

}