package com.example.ss6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToCourseList() {
        return "redirect:/course/list";
    }
}
