<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>Danh sách - StudentHub</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f4f4f4; }
        .nav { margin-bottom: 20px; }
        .status-dang-hoc { color: green; font-weight: bold; }
        .status-bao-luu { color: orange; font-weight: bold; }
        .status-tot-nghiep { color: blue; font-weight: bold; }
    </style>
</head>
<body>
<div class="nav">
    <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a> |
    <a href="${pageContext.request.contextPath}/students">Danh sách Sinh viên</a>
</div>

<h2>Quản lý Sinh viên</h2>

<form action="${pageContext.request.contextPath}/students" method="GET">
    <input type="text" name="search" placeholder="Nhập tên..." value="${currentSearch}">
    <select name="faculty">
        <option value="">Tất cả khoa</option>
        <option value="CNTT" ${currentFaculty == 'CNTT' ? 'selected' : ''}>CNTT</option>
        <option value="Kinh tế" ${currentFaculty == 'Kinh tế' ? 'selected' : ''}>Kinh tế</option>
        <option value="Ngoại ngữ" ${currentFaculty == 'Ngoại ngữ' ? 'selected' : ''}>Ngoại ngữ</option>
    </select>
    <button type="submit">Tìm kiếm / Lọc</button>
    <a href="${pageContext.request.contextPath}/students"><button type="button">Reset</button></a>
</form>

<c:if test="${not empty currentSearch or not empty currentFaculty}">
    <p><i>Tìm thấy ${resultCount} sinh viên.</i></p>
</c:if>

<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã SV</th>
        <th><a href="?sortBy=name&search=${currentSearch}&faculty=${currentFaculty}">Họ tên ↑</a></th>
        <th>Khoa</th>
        <th>Năm học</th>
        <th><a href="?sortBy=gpa&search=${currentSearch}&faculty=${currentFaculty}">GPA ↓</a></th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${students}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${s.studentCode}</td>
            <td>${s.fullName}</td>
            <td>${s.faculty}</td>
            <td>${s.enrollmentYear}</td>
            <td>${s.gpa}</td>
            <td>
                <c:choose>
                    <c:when test="${s.status == 'Đang học'}"><span class="status-dang-hoc">${s.status}</span></c:when>
                    <c:when test="${s.status == 'Bảo lưu'}"><span class="status-bao-luu">${s.status}</span></c:when>
                    <c:otherwise><span class="status-tot-nghiep">${s.status}</span></c:otherwise>
                </c:choose>
            </td>
            <td><a href="${pageContext.request.contextPath}/students/detail?id=${s.id}">Chi tiết</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>