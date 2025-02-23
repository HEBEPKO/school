package com.example.school.serviceimpl;

import com.example.school.dto.StudentCreateEditDto;
import com.example.school.dto.StudentDTO;
import com.example.school.dto.StudentReadDto;
import com.example.school.mapper.StudentCreateEditMapper;
import com.example.school.mapper.StudentMapper;
import com.example.school.mapper.StudentReadMapper;
import com.example.school.reppository.StudentRepository;
import com.example.school.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentReadMapper studentReadMapper;
    private final StudentCreateEditMapper studentCreateEditMapper;

    @Override
    public List<StudentReadDto> findAll() {
        return studentRepository.findAll().stream()
                .map(studentReadMapper::map)
                .toList();
    }

    @Override
    public Optional<StudentReadDto> findById(Long id) {
        return studentRepository.findById(id)
                .map(studentReadMapper::map);
    }

    @Transactional
    @Override
    public StudentReadDto create(StudentCreateEditDto studentDTO) {
        return Optional.of(studentDTO)
                .map(studentCreateEditMapper::map)
                .map(studentRepository::save)
                .map(studentReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    @Override
    public Optional<StudentReadDto> update(Long id, StudentCreateEditDto studentDTO) {
        return studentRepository.findById(id)
                .map(student -> studentCreateEditMapper.map(studentDTO, student))
                .map(studentRepository::saveAndFlush)
                .map(studentReadMapper::map);
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
//                    studentRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
