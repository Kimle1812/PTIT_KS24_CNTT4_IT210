package org.example.session05.Exercise02.controller;


import org.example.session05.Exercise02.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Exercise02")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/dishes")
    public String listDishes(Model model) {
        model.addAttribute("listDish", dishService.getDishes());
        return "dish-list";
    }
}