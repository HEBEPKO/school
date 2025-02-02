package com.example.school.controller;

//import com.example.school.dao.StudentDAO;

import com.example.school.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public String greeting(Model model) {
        model.addAttribute("student", studentService.getAllStudents());
        return "students";
//        return studentService.getAllStudents().toString();
    }

    @GetMapping("/student/{id}")
    public String showStudents(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id).stream().
                filter(s->s.getId().equals(id)).findAny().orElse(null));
        return "show";
    }



}
