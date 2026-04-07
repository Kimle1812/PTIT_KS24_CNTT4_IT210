package org.example.studenthub.controller;

import org.example.studenthub.models.Student;
import org.example.studenthub.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // UC-04: Dashboard (Trang chủ)
    @GetMapping(value = {"/", "/dashboard"})
    public String dashboard(Model model) {
        model.addAttribute("total", studentService.getTotalStudents());
        model.addAttribute("avgGpa", String.format("%.2f", studentService.getAverageGpa()));
        model.addAttribute("topStudent", studentService.getTopStudent());
        model.addAttribute("statusData", studentService.getStatusPercentages());
        return "dashboard";
    }

    // UC-01 & UC-03: Danh sách & Lọc & Sắp xếp (Đã fix lỗi Spring 6.1 Parameter Name)
    @GetMapping("/students")
    public String listStudents(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "faculty", required = false) String faculty,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            Model model) {

        // Gọi Service xử lý logic lọc và sắp xếp
        List<Student> students = studentService.getFilteredAndSortedStudents(search, faculty, sortBy);

        // Đẩy dữ liệu sang View
        model.addAttribute("students", students);
        model.addAttribute("resultCount", students.size());

        // Trả lại các param để giữ trạng thái trên thanh tìm kiếm của View
        model.addAttribute("currentSearch", search);
        model.addAttribute("currentFaculty", faculty);

        return "list";
    }

    @GetMapping("/students/detail")
    public String detailStudent(@RequestParam(value = "id") int id, Model model) {
        Student student = studentService.getStudentById(id);

        // Nếu nhập ID linh tinh trên URL không có trong list -> quay về danh sách
        if (student == null) {
            return "redirect:/students";
        }

        model.addAttribute("student", student);
        return "detail";
    }
}