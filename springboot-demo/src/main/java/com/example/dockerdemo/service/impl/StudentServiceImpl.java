package com.example.dockerdemo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.dockerdemo.dto.StudentRequest;
import com.example.dockerdemo.dto.StudentResponse;
import com.example.dockerdemo.entity.Student;
import com.example.dockerdemo.exception.StudentNotFoundException;
import com.example.dockerdemo.repository.StudentRepository;
import com.example.dockerdemo.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private static final Logger log =
            LoggerFactory.getLogger(
                    StudentServiceImpl.class);

    @Override
    public StudentResponse create(StudentRequest request) {

        Student student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .course(request.getCourse())
                .build();

        log.info("Creating student {}", request.getEmail());
        Student saved = repository.save(student);
        log.info("Student created with id {}", saved.getId());
        return map(saved);
    }

    @Override
    public List<StudentResponse> findAll() {
    	log.info("Fetching all students");
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public StudentResponse findById(Long id) {
    	log.info("Fetching student {}", id);
        Student student = repository.findById(id)
        		.orElseThrow(() -> {
                    log.error("Student not found {}", id);
                    return new StudentNotFoundException(id);
                });

        return map(student);
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {
    	log.info("Updating student {}", id);
        Student student = repository.findById(id)
        		.orElseThrow(() -> {
                    log.error("Student not found {}", id);
                    return new StudentNotFoundException(id);
                });

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setCourse(request.getCourse());
        log.info("Student updated {}", id);
        return map(repository.save(student));
    }

    @Override
    public void delete(Long id) {
    	log.warn("Deleting student {}", id);
        Student student = repository.findById(id)
        		.orElseThrow(() -> {
                    log.error("Student not found {}", id);
                    return new StudentNotFoundException(id);
                });
        
        repository.delete(student);
        log.info("Student deleted {}", id);
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