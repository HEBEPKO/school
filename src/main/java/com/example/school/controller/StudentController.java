package com.example.school.controller;

import com.example.school.dto.StudentCreateEditDto;
import com.example.school.entity.Student;
import com.example.school.serviceimpl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;

    @GetMapping
    public String findAll(Model model) {
            model.addAttribute("students", studentServiceImpl.findAll());
//            model.addAttribute("students", studentServiceImpl.findAll(filter()));
        return "students/students";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        return studentServiceImpl.findById(id)
                .map(student -> {
                    model.addAttribute("student", student);
                    return "students/student";
                })
                .orElseThrow(()-> new RuntimeException("Student not found"));
    }

    @PostMapping
    public String create(@ModelAttribute StudentCreateEditDto student) {
        studentServiceImpl.create(student);
        return "redirect:/person";
    }

//    @PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute StudentCreateEditDto student) {
        return studentServiceImpl.update(id, student)
                .map(it -> "redirect:/person/{id}")
                .orElseThrow(()-> new RuntimeException("Student not found"));

    }
//    @DeleteMapping("/{id}")
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        System.out.println("Работает метод");
        studentServiceImpl.delete(id);
        return "redirect:/person";
    }

    @GetMapping("/created")
    public String created(Model model) {
        model.addAttribute("student", new Student());
        return "students/created";
    }
}
