package com.example.dockerdemo.service;

import com.example.dockerdemo.dto.StudentRequest;
import com.example.dockerdemo.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse create(StudentRequest request);

    List<StudentResponse> findAll();

    StudentResponse findById(Long id);

    StudentResponse update(Long id, StudentRequest request);

    void delete(Long id);

}