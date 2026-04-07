<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Dashboard - StudentHub</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .card { border: 1px solid #ccc; padding: 20px; width: 300px; display: inline-block; margin-right: 20px; vertical-align: top;}
        .nav { margin-bottom: 20px; }
    </style>
</head>
<body>
<div class="nav">
    <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a> |
    <a href="${pageContext.request.contextPath}/students">Danh sách Sinh viên</a>
</div>

<h2>Báo cáo Tổng quan</h2>

<div class="card">
    <h3>Sĩ số & Điểm</h3>
    <p>Tổng sinh viên: <strong>${total}</strong></p>
    <p>GPA Trung bình: <strong>${avgGpa}</strong></p>
</div>

<div class="card">
    <h3>Tỷ lệ Trạng thái</h3>
    <ul>
        <c:forEach var="entry" items="${statusData}">
            <li>${entry.key}: <strong>${entry.value}%</strong></li>
        </c:forEach>
    </ul>
</div>

<div class="card">
    <h3>Thủ khoa Nhóm</h3>
    <p>Họ tên: <strong>${topStudent.fullName}</strong></p>
    <p>Khoa: ${topStudent.faculty}</p>
    <p>GPA: <span style="color:red; font-weight:bold;">${topStudent.gpa}</span></p>
</div>
</body>
</html>