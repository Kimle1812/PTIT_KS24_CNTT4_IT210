package org.example.session05.Exercise02.service;


import org.example.session05.common.Dish;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {
    public List<Dish> getDishes() {
        List<Dish> list = new ArrayList<>();
        list.add(new Dish(1L, "Phở Bò", 55000.0, true));
        list.add(new Dish(2L, "Bún Chả", 45000.0, false)); // Món này hết hàng
        list.add(new Dish(3L, "Cơm Tấm", 40000.0, true));
        return list;
    }
}