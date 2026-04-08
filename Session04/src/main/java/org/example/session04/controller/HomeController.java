package org.example.session04.controller;

import org.example.session04.model.Student;
import org.example.session04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        List<Student> students = studentService.getAllStudent();

        model.addAttribute("students", students);

        return "home";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(name ="keyword", defaultValue = "") String keyword
    ){
        System.out.println("Noi dung: " + keyword);
        return "home";
    }
}