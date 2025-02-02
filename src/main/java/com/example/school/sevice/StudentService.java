package com.example.school.sevice;

import com.example.school.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Iterable<Student> getAllStudents();
    List<Student> getStudentById(Long id);
    Student SaveStudent(Student student);
}
