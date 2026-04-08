<%--
  Created by IntelliJ IDEA.
  User: MMC
  Date: 4/8/2026
  Time: 8:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>

    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.fullName}</td>
            <td>${s.age}</td>
            <td>${s.gender}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
