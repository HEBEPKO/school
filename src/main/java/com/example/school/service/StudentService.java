package com.example.school.service;

import com.example.school.dto.StudentCreateEditDto;
import com.example.school.dto.StudentDTO;
import com.example.school.dto.StudentReadDto;
import com.example.school.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentReadDto> findAll();
    Optional<StudentReadDto> findById(Long id);
    StudentReadDto create(StudentCreateEditDto studentDTO);
    Optional<StudentReadDto> update(Long id, StudentCreateEditDto studentDTO);
    boolean delete(Long id);
}
