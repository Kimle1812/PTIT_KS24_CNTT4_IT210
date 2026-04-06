package org.example.homework;

import com.mysql.cj.xdevapi.Client;

/**
 * PHẦN 1: PHÂN TÍCH LOGIC CÁC VẤN ĐỀ TRONG REPORT.JSP
 * * 1. Vị trí: <%! private int requestCounter = 0; %>
 * Loại vấn đề: Race Condition (Xung đột luồng).
 * Hệ quả: Biến dùng chung cho mọi user, dẫn đến đếm sai khi nhiều người truy cập cùng lúc.
 * * 2. Vị trí: * Loại vấn đề: Bảo mật (HTML Comment).
 * Hệ quả: Lộ thông tin logic cho người dùng khi họ kiểm tra mã nguồn trang web (View Source).
 * * 3. Vị trí: <%= user.getName(); %>
 * Loại vấn đề: Lỗ hổng XSS (Cross-Site Scripting).
 * Hệ quả: Hacker có thể chèn mã độc vào tên user để tấn công người dùng khác.
 * * 4. Vị trí: Lồng ghép if/else và for (Scriptlet) để render HTML.
 * Loại vấn đề: Vi phạm nguyên tắc thiết kế View (Spaghetti Code).
 * Hệ quả: Code cực kỳ khó đọc, khó bảo trì và dễ gây lỗi cú pháp khi đóng/mở ngoặc nhọn {}.
 * * 5. Vị trí: <%= score; %>
 * Loại vấn đề: Cú pháp lỗi thời.
 * Hệ quả: Không tận dụng được sự gọn gàng và an toàn của Expression Language (EL).
 */

public class Main {

    // PHẦN 2: THỰC THI - NỘI DUNG FILE REPORT.JSP (ĐÃ REFACTOR)

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <html>
    <head>
    <title>Báo cáo điểm sinh viên</title>
    </head>
    <body>
        <%-- JSP Comment: An toàn, không hiển thị ở phía Client --%>
    <h2>Báo cáo kết quả học tập</h2>

        <table border="1">
            <thead>
                <tr>
                    <th>STT</th>
    <th>Họ tên</th>
                    <th>Điểm</th>
    <th>Trạng thái</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="s" items="${studentList}" varStatus="status">
                    <tr>
    <td>${status.index + 1}</td>
                        <td><c:out value="${s.name}" /></td>
            <td>${s.score}</td>
                        <td>
                            <c:choose>
                                <c:when test="${s.score >= 5}">
            <span style="color: blue;">Đạt</span>
                                </c:when>
                                <c:otherwise>
                                    <span style="color: red;">Trượt</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <c:if test="${empty studentList}">
    <p>Danh sách trống.</p>
        </c:if>
    </body>
    </html>
}