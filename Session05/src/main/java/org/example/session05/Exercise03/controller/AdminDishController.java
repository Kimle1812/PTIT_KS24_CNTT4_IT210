package org.example.session05.Exercise03.controller;


import org.example.session05.Exercise.service.AdminDishService;
import org.example.session05.common.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {

    @Autowired
    private AdminDishService adminDishService;

    // Hiển thị danh sách món ăn (Sửa lại từ Bài 2 cho Bài 3)
    @GetMapping("/dishes")
    public String listDishes(Model model) {
        model.addAttribute("listDish", adminDishService.getAll());
        return "dish-list-v2";
    }

    // Trang chỉnh sửa món ăn
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Dish dish = adminDishService.findById(id);
        if (dish == null) {
            model.addAttribute("errorMsg", "Không tìm thấy món ăn yêu cầu!");
            model.addAttribute("listDish", adminDishService.getAll());
            return "dish-list-v2"; // Quay lại trang danh sách kèm lỗi
        }

        model.addAttribute("dishObj", dish);
        return "edit-dish";
    }
}
