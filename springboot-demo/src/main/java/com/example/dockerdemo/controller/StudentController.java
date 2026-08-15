package com.example.dockerdemo.controller;

import com.example.dockerdemo.dto.StudentRequest;
import com.example.dockerdemo.dto.StudentResponse;
import com.example.dockerdemo.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public StudentResponse create(
            @Valid @RequestBody StudentRequest request) {

        return service.create(request);
    }

    @GetMapping
    public List<StudentResponse> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public StudentResponse update(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}