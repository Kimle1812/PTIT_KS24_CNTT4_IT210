<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/7/2026
  Time: 7:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Quản lý nhân sự</title>
    <style>
        table { border-collapse: collapse; width: 70%; margin: auto; }
        th, td { border: 1px solid black; padding: 10px; text-align: left; }
        .high-salary { color: red; font-weight: bold; }
    </style>
</head>
<body>
<h1 style="text-align: center;">Danh sách nhân viên phòng Đào tạo</h1>
<table>
    <tr>
        <th>ID</th> <th>Họ tên</th> <th>Phòng</th> <th>Lương</th> <th>Đánh giá</th>
    </tr>
    <c:forEach items="${employeeList}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.fullName}</td>
            <td>${e.department}</td>
            <td>${e.salary}</td>
            <td>
                <c:choose>
                    <c:when test="${e.salary >= 10000}">
                        <span>Mức lương cao</span>
                    </c:when>
                    <c:otherwise>Mức lương cơ bản</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
