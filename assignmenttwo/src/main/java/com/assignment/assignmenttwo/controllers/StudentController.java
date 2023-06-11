package com.assignment.assignmenttwo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assignment.assignmenttwo.models.Student;
import com.assignment.assignmenttwo.models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/")
    public String getAllStudents(Model model){
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);

        return "students/showAllStudents";
    }

    @PostMapping("/students/add")
    public String addStudent(@RequestParam Map <String, String> newStudent, HttpServletResponse response){
        String name = newStudent.get("name");
        Float weight = Float.parseFloat(newStudent.get("weight"));
        Float height = Float.parseFloat(newStudent.get("height"));
        String hairColor = newStudent.get("hairColor");
        Float gpa = Float.parseFloat(newStudent.get("gpa"));

        studentRepo.save(new Student(name, weight, height, hairColor,gpa));
        return "redirect:/";
    }

    @GetMapping("/students/update/{id}")
    public String getUpdateForm(@PathVariable("id") int uid, Model model){
        Student student = studentRepo.findByUid(uid);
        model.addAttribute("students", student);
        return "students/update";
    }

    @GetMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable("id") int uid, Model model){
        Student student = studentRepo.findByUid(uid);
        studentRepo.delete(student);
        return "redirect:/";
    }
    
    @PostMapping("/students/edit/{id}")
    public String editStudent(@PathVariable("id") int uid, Model model, @RequestParam Map <String, String> updateStudent){
        String name = updateStudent.get("name");
        Float weight = Float.parseFloat(updateStudent.get("weight"));
        Float height = Float.parseFloat(updateStudent.get("height"));
        String hairColor = updateStudent.get("hairColor");
        Float gpa = Float.parseFloat(updateStudent.get("gpa"));

        Student target = studentRepo.findByUid(uid);
        target.setName(name);
        target.setWeight(weight);
        target.setHeight(height);
        target.setHairColor(hairColor);
        target.setGpa(gpa);

        studentRepo.save(target);
        return "redirect:/";
    }
}
