<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Chi tiết - StudentHub</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 40px; }
    .detail-box { border: 1px solid #000; padding: 20px; width: 400px; background-color: #f9f9f9;}
  </style>
</head>
<body>
<h2>Chi tiết Sinh viên: ${student.fullName}</h2>

<div class="detail-box">
  <p><strong>Mã SV:</strong> ${student.studentCode}</p>
  <p><strong>Họ tên:</strong> ${student.fullName}</p>
  <p><strong>Khoa:</strong> ${student.faculty}</p>
  <p><strong>Năm nhập học:</strong> ${student.enrollmentYear}</p>
  <p><strong>Điểm GPA:</strong> ${student.gpa}</p>
  <p><strong>Trạng thái:</strong> ${student.status}</p>
</div>

<br/>
<a href="${pageContext.request.contextPath}/students">
  <button>&laquo; Quay lại</button>
</a>
</body>
</html>