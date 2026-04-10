package org.example.session05.Exercise03.service;


import org.example.session05.common.Dish;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishService {
    private List<Dish> dishList = new ArrayList<>(List.of(
            new Dish(1L, "Phở Bò", 55000.0, true),
            new Dish(2L, "Bún Chả", 45000.0, false),
            new Dish(3L, "Cơm Tấm", 40000.0, true)
    ));

    public List<Dish> getAll() {
        return dishList;
    }

    public Dish findById(Long id) {
        return dishList.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}