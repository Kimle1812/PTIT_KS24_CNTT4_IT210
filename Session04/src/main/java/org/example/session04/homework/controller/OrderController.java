package org.example.session04.homework.controller;


import org.example.session04.homework.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Bài 1
    @GetMapping("/homework01/orders")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "homework01";
    }

    @GetMapping("/homework01/orders/{id}")
    public String getOrderById(@PathVariable int id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        return "homework01";
    }

    @PostMapping("/homework01/orders")
    public String createOrder(Model model) {
        model.addAttribute("message", "Tạo mới đơn hàng thành công!");
        return "homework01";
    }

    // Bài 2
    @GetMapping("/homework02/menu")
    public String getMenu(
            @RequestParam(value = "category", required = false, defaultValue = "chay") String category,
            Model model) {
        model.addAttribute("category", category);
        return "homework02";
    }

    // Bài 3
    // Trong cách A: số 5 nằm ở đường dẫn còn trong cách B thì số 5 nằm ở tham số sau dấu ?
    // Khi lấy ID của một đối tượng cụ thể, cách phù hợp hơn là cách A với @PathVariable
    // vì nó biểu diễn rõ ràng tài nguyên và tuân theo chuẩn RESTful
    @GetMapping("/homework03/orders/{id}")
    public String getOrderByIdHW3(@PathVariable int id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        return "homework01";
    }

    @GetMapping("/homework04/products")
    public String getProducts(
            @RequestParam("category") String category,
            @RequestParam("limit") int limit,
            ModelMap model) {

        model.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tìm kiếm thành công");

        return "productList";
    }
}
