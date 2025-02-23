package com.example.school.mapper;

import com.example.school.dto.StudentCreateEditDto;
import com.example.school.entity.Student;
import org.springframework.stereotype.Component;

@Component

public class StudentCreateEditMapper implements Mapper<StudentCreateEditDto, Student> {

    @Override
    public Student map(StudentCreateEditDto fromObject, Student toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    @Override
    public Student map(StudentCreateEditDto object) {
        Student student = new Student();
        copy(object, student);
        return student;
    }

    private void copy(StudentCreateEditDto object, Student student) {
        student.setFirstName(object.getFirstName());
        student.setMiddleName(object.getMiddleName());
        student.setLastName(object.getLastName());
        student.setClassLevel(object.getClassLevel());
        student.setCreatedAt(object.getCreatedAt());
        student.setUpdatedAt(object.getUpdatedAt());
    }
}
