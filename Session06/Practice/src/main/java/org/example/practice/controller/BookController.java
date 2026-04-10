package org.example.practice.controller;

import org.example.practice.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/books")
public class BookController {
    List<Book> books = new ArrayList<>(
            Arrays.asList(
                    new Book(1, "Tắt đèn", "Ngô Tất Tố", 10000.0),
                    new Book(2, "Vợ nhặt", "Kim Lân", 20000.0),
                    new Book(3, "Chí Phèo", "Nam Cao", 50000.0),
                    new Book(4, "Những ngày thơ ấu", "Nguyên Hồng", 400000.0) // thêm 1 sách giá cao để test highlight
            )
    );

    @GetMapping
    public String list(Model model){
        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Danh sách sách");
        return "books/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model){
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("pageTitle", "Chi tiết sách");
        return "books/detail";
    }
}
