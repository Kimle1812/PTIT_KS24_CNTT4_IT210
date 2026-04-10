package org.example.session05.controller;


import org.example.session05.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    // Hiển thị danh sách sản phẩm ra màn hình
    /**
     * Class Product
     * - id
     * - name
     * - price
     * - stock
     * - status
     * */
    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(1, "Kim Le", 10000, 1, true),
                    new Product(2, "Kim Kim", 8000, 1, true),
                    new Product(3, "Kim Nguyen", 20000, 1, true),
                    new Product(4, "Kim Thi", 5000, 1, true)
            )
    );
    @GetMapping
    public String home(Model model){
        model.addAllAttributes("shop", products);
        return "home";
    }

    @GetMapping("delete/{id}")
    public String handleDelete(
            @PathVariable int id
    ){
        products.stream().filter(p -> p.getId()  != id).toList();

    }
}
