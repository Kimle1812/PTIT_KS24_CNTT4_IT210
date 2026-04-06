package org.example.ss02.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// đánh dấu nó là controller
@Controller
// đánh dấu đường gốc URL (Ngõ)
@RequestMapping("/home") // nếu không ghi gì thì đường dẫn là /home
public class HomeController {

    // HTTP Method (GET, POST) đại diện cho ngách
    @GetMapping // Đại diện cho ngách và phương thức GET
    public String home(HttpServletRequest request) {
        List<String> names = new ArrayList<>(
                Arrays.asList(
                        "Vũ Việt Tiến",
                        "Nguyễn Doanh Tuấn",
                        "Hoàng Thái Minh",
                        "Phạm Thị Hồng Nhung"
                )
        );
        request.setAttribute("names", names);
        request.setAttribute("money",1200000);
        return "students";
    }

    @GetMapping("/add")
    public String formAdd() {
        return "form_add";
    }

}
