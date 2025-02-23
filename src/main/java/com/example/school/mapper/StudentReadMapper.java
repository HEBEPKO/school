package com.example.school.mapper;

import com.example.school.dto.StudentReadDto;
import com.example.school.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentReadMapper implements Mapper<Student, StudentReadDto> {
    @Override
    public StudentReadDto map(Student object) {
        return new StudentReadDto(
                object.getId(),
                object.getFirstName(),
                object.getMiddleName(),
                object.getLastName(),
                object.getClassLevel(),
                object.getCreatedAt(),
                object.getUpdatedAt()
        );
    }
}
