package com.example.school.serviceImpl;

import com.example.school.model.Student;
import com.example.school.repository.StudentRepository;
import com.example.school.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().toList();
    }

    @Override
    public List<Student> getStudentById(Long id) {
        return studentRepository.findById(id).stream().toList();
    }

    @Override
    public Student SaveStudent(Student student) {
        return studentRepository.save(student);
    }


}
