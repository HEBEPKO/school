package com.example.school.dto;

import lombok.Value;

@Value
public class StudentReadDto {
    Long id;
    String firstName;
    String middleName;
    String lastName;
    String classLevel;
    String createdAt;
    String updatedAt;
}
