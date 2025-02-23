package com.example.school.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String createdAt;
    private String updatedAt;
}
