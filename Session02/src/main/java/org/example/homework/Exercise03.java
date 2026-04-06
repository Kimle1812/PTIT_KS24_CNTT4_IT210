package org.example.homework;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PHẦN 1: BÁO CÁO PHÂN TÍCH (ANALYSIS)
 * * 1. Tại sao thông báo lỗi đăng nhập dùng Request Scope thay vì Session Scope?
 * - Request Scope: Chỉ tồn tại trong một vòng đời request. Khi người dùng F5 hoặc chuyển trang,
 * thông báo lỗi sẽ tự mất đi, giúp giao diện sạch sẽ và đúng ngữ cảnh.
 * - Nếu dùng Session: Thông báo lỗi sẽ tồn tại mãi cho đến khi bị xóa thủ công hoặc session hết hạn.
 * Người dùng đã đăng nhập lại thành công vẫn có thể thấy thông báo "Sai mật khẩu" cũ.
 * * 2. Tại sao totalViewCount dùng Application Scope thay vì Session Scope?
 * - Application Scope: Lưu trữ dữ liệu dùng chung cho toàn bộ ứng dụng. Mọi nhân viên đều
 * truy cập vào cùng một biến đếm duy nhất.
 * - Nếu dùng Session: Mỗi nhân viên sẽ có một bộ đếm riêng. Nhân viên A xem 3 lần thấy số 3,
 * nhân viên B vào lần đầu thấy số 1. Không thể thống kê tổng lượt xem toàn hệ thống.
 * * 3. Race Condition và cách khắc phục:
 * - Race Condition: Xảy ra khi nhiều luồng (người dùng) cùng đọc và ghi vào một biến dùng chung
 * (totalViewCount) tại cùng một thời điểm, dẫn đến mất dữ liệu tăng tiến.
 * - Khắc phục: Sử dụng khối lệnh 'synchronized (application)' để đảm bảo tại một thời điểm
 * chỉ có duy nhất một luồng được quyền cập nhật giá trị của biến đếm.
 */

public class Main {

    // 4.1. MODULE ĐĂNG NHẬP (AUTHCONTROLLER)
    @Controller
    public static class AuthController {

        @PostMapping("/login")
        public String handleLogin(@RequestParam String username,
                                  @RequestParam String password,
                                  HttpSession session,
                                  Model model) {

            // Hardcode tài khoản: admin/admin123 hoặc staff/staff123
            if (("admin".equals(username) && "admin123".equals(password)) ||
                    ("staff".equals(username) && "staff123".equals(password))) {

                // Lưu vào Session: Tồn tại xuyên suốt phiên làm việc
                session.setAttribute("loggedUser", username);
                session.setAttribute("role", "admin".equals(username) ? "Quản lý" : "Nhân viên");

                return "redirect:/orders";
            } else {
                // Lưu vào Request Scope (Model): Chỉ tồn tại trong 1 request trả về trang login
                model.addAttribute("errorMessage", "Tài khoản hoặc mật khẩu không chính xác!");
                return "login";
            }
        }

        @GetMapping("/logout")
        public String logout(HttpSession session) {
            session.invalidate(); // Hủy toàn bộ phiên làm việc
            return "redirect:/login";
        }
    }

    // 4.2. MODULE DANH SÁCH ĐƠN HÀNG (ORDERCONTROLLER)
    @Controller
    public static class OrderController {

        @GetMapping("/orders")
        public String showOrders(HttpSession session, ServletContext application, Model model) {
            // Kiểm tra session (Bẫy dữ liệu 1 & 5)
            if (session.getAttribute("loggedUser") == null) {
                return "redirect:/login";
            }

            // Tạo danh sách đơn hàng giả
            List<Order> orders = new ArrayList<>();
            orders.add(new Order("ORD-01", "Laptop ThinkPad", 25000000, new Date()));
            orders.add(new Order("ORD-02", "Chuột Fuhlen", 500000, new Date()));
            orders.add(new Order("ORD-03", "Bàn phím cơ", 1200000, new Date()));

            // Đẩy vào Request Scope để hiển thị trên JSP
            model.addAttribute("orderList", orders);

            // Cập nhật bộ đếm toàn cục - Chống Race Condition
            synchronized (application) {
                Integer count = (Integer) application.getAttribute("totalViewCount");
                if (count == null) count = 0;
                application.setAttribute("totalViewCount", count + 1);
            }

            return "orders";
        }
    }

    // Class Model đơn giản để chứa dữ liệu đơn hàng
    public static class Order {
        private String id;
        private String name;
        private double price;
        private Date date;

        public Order(String id, String name, double price, Date date) {
            this.id = id; this.name = name; this.price = price; this.date = date;
        }
        public String getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public Date getDate() { return date; }
    }

    /* 4.3. TRANG JSP (ORDERS.JSP) - EL & JSTL
    ----------------------------------------------------------
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <html>
    <head><title>Quản lý đơn hàng</title></head>
    <body>
        <h2>Xin chào, ${sessionScope.loggedUser}! (Vai trò: ${sessionScope.role})</h2>

        <table border="1" cellpadding="10">
            <thead>
                <tr>
                    <th>Mã đơn</th>
                    <th>Sản phẩm</th>
                    <th>Tổng tiền</th>
                    <th>Ngày đặt</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${orderList}">
                    <tr>
                        <td>${item.id}</td>
                        <td><c:out value="${item.name}" /></td>
                        <td><fmt:formatNumber value="${item.price}" type="currency" currencySymbol="VNĐ" /></td>
                        <td><fmt:formatDate value="${item.date}" pattern="dd/MM/yyyy" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><strong>Tổng lượt xem hệ thống:</strong> ${applicationScope.totalViewCount}</p>

        <a href="<c:url value='/logout'/>">Đăng xuất</a>
    </body>
    </html>
    */
}