package com.example.school.controller;

import com.example.school.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    private final StudentDAO studentDAO;
    @Autowired
    public GreetingController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }


    @GetMapping
    public String greeting(Model model) {
        model.addAttribute("person", studentDAO.getAllStudents());
        return "greeting";
    }

    @GetMapping("/{id}")
    public String showStudents(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentDAO.getStudent(id));
        return "show";
    }

}
