package com.example.school.mapper;

import com.example.school.entity.Student;
import com.example.school.dto.StudentDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO toDto(Student student);

    Student toEntity(StudentDTO studentDTO);

//    List<StudentDTO> toDtoList(List<Student> students);
//    List<Student> toEntityList(List<StudentDTO> studentDTOs);
}
