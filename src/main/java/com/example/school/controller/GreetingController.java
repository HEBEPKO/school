package com.example.school.controller;

//import com.example.school.dao.StudentDAO;

import com.example.school.model.Student;
import com.example.school.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController {

    private final StudentService studentService;
    @Autowired
    public GreetingController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("person", studentService.getAllStudents());
        return "greeting";
//        return studentService.getAllStudents().toString();
    }

    @GetMapping("/greeting/{id}")
    public String showStudents(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id).stream().
                filter(s->s.getId().equals(id)).findAny().orElse(null));
        return "show";
    }



}
