package com.example.ss6.controller;

import com.example.ss6.model.Course;
import com.example.ss6.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate; // Import LocalDate
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Chức năng 2: Danh sách & Lọc khóa học
    @GetMapping("/list")
    public String listCourses(@RequestParam(name = "level", required = false) String level, // Explicitly named
                              @RequestParam(name = "maxPrice", required = false) Double maxPrice, // Explicitly named
                              Model model) {
        List<Course> courses = courseService.filterCourses(level, maxPrice);
        model.addAttribute("courses", courses);
        model.addAttribute("level", level);
        model.addAttribute("maxPrice", maxPrice);
        return "course/list";
    }

    // Chức năng 3: Xem chi tiết lộ trình
    @GetMapping("/detail/{code}")
    public String getCourseDetail(@PathVariable("code") String code, Model model) { // Explicitly named
        Optional<Course> course = courseService.getCourseByCode(code);
        if (course.isPresent()) {
            model.addAttribute("course", course.get());
            return "course/detail";
        }
        return "redirect:/course/list";
    }

    // Chức năng 4: Cập nhật thông tin khóa học (Hiển thị Form)
    @GetMapping("/edit/{code}")
    public String showEditForm(@PathVariable("code") String code, Model model) { // Explicitly named
        Optional<Course> course = courseService.getCourseByCode(code);
        if (course.isPresent()) {
            model.addAttribute("course", course.get());
            return "course/edit";
        }
        return "redirect:/course/list";
    }

    // Chức năng 4: Cập nhật thông tin khóa học (Xử lý POST)
    // Sử dụng @RequestParam cho từng trường để tuân thủ yêu cầu "native HTML"
    @PostMapping("/update")
    public String updateCourse(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("code") String code,
            @RequestParam("level") String level,
            @RequestParam("price") double price,
            @RequestParam("description") String description,
            @RequestParam("instructor") String instructor,
            @RequestParam("duration") String duration,
            @RequestParam("isFull") boolean isFull,
            @RequestParam("studentCount") int studentCount,
            @RequestParam("startDate") LocalDate startDate, // Spring can convert String to LocalDate if format is standard (yyyy-MM-dd)
            RedirectAttributes redirectAttributes) {

        Course updatedCourse = new Course(id, name, code, level, price, description, instructor, duration, isFull, studentCount, startDate);
        courseService.updateCourse(updatedCourse);
        redirectAttributes.addFlashAttribute("message", "Cập nhật khóa học thành công!");
        return "redirect:/course/list";
    }

    // Chức năng 5: Xóa/Lưu trữ khóa học
    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id, RedirectAttributes redirectAttributes) { // Explicitly named
        boolean deleted = courseService.deleteCourse(id);
        if (deleted) {
            redirectAttributes.addFlashAttribute("message", "Hủy khóa học thành công!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Không thể hủy khóa học đã có học viên đăng ký!");
        }
        return "redirect:/course/list";
    }
}
