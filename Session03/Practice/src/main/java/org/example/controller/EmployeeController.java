package org.example.controller;


import org.example.model.Employee;
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
        list.add(new Employee(1, "Nguyễn Thị Kim Lệ", "Đào tạo", 20000));
        list.add(new Employee(2, "Nguyễn Thị Phương", "Đào tạo", 8000));
        list.add(new Employee(3, "Vũ Văn Đoàn", "Đào tạo", 10000));

        model.addAttribute("employeeList", list);
        return "employee-list";
    }
}
