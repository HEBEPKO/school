package com.example.school.dao;

import com.example.school.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class StudentDAO {

    final int COUNT = 0;

    List<Student> students ;

    {
        students = new ArrayList<>();

        students.add(new Student("Alex", COUNT + 1));
        students.add(new Student("Bob", COUNT + 2));
        students.add(new Student("Charlie", COUNT + 3));
        students.add(new Student("David", COUNT + 4));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(int id) {
        return students.stream().filter(student -> student.getId() == id).findAny().orElse(null);
    }
}
