package org.example.ss03.ktra.controller;

import org.example.ss03.ktra.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Đoàn", "Đào tạo", 15000));
        list.add(new Employee(2, "Hiền", "Đào tạo", 8000));
        list.add(new Employee(3, "Nam", "Đào tạo", 12000));

        model.addAttribute("employeeList", list);
        return "employee-list";
    }
}