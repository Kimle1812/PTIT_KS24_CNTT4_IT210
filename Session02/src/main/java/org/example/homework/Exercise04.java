package org.example.ss02.btvn;

/**
 * PHẦN 1: BÁO CÁO PHÂN TÍCH BẢO MẬT (SECURITY REPORT)
 * * 1. XSS là gì? Tại sao <c:out> an toàn hơn ${}?
 * - XSS (Cross-Site Scripting): Là lỗ hổng cho phép hacker chèn mã script độc hại (JS) vào trang web.
 * Mã này sẽ thực thi trên trình duyệt của người dùng khác khi họ xem trang.
 * - <c:out value="${keyword}"/> an toàn vì nó mặc định có thuộc tính escapeXml="true".
 * Nó sẽ biến các ký tự đặc biệt như <, >, & thành các thực thể HTML (&lt;, &gt;).
 * - So sánh Output khi input là <script>alert(1)</script>:
 * + Dùng ${keyword}: Trình duyệt nhận được nguyên văn <script>... và thực thi popup.
 * + Dùng <c:out>: Trình duyệt nhận được &lt;script&gt;... và chỉ hiển thị nó như một đoạn văn bản thuần túy.
 * * 2. So sánh <c:if> và <c:choose>:
 * - <c:if>: Dùng cho các điều kiện đơn lẻ (có hoặc không).
 * - <c:choose>: Dùng cho các điều kiện rẽ nhánh phức tạp (if - else if - else).
 * - Áp dụng: Trong bài này, "Giá vé" và "Vé còn lại" nên dùng <c:choose> vì có ít nhất 3 trạng thái
 * (Hết vé, Sắp hết, Còn vé) cần hiển thị các màu sắc/nội dung khác nhau.
 * * 3. Lợi ích của <c:url> so với Hardcode href:
 * - <c:url> tự động chèn Context Path của ứng dụng vào trước đường dẫn.
 * - Nếu ứng dụng deploy tại /ticketing:
 * + Hardcode /events/1: Sẽ bị lỗi 404 vì thiếu context path.
 * + <c:url>: Tự động sinh ra /ticketing/events/1, đảm bảo link luôn đúng dù deploy ở bất cứ đâu.
 */

public class Main {

    /* PHẦN 2: THỰC THI - FILE EVENTS/SEARCH.JSP (THUẦN JSTL & EL)
       (Đoạn này được để trong comment để file .java hợp lệ)

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <html>
    <head>
        <title>Tìm kiếm sự kiện</title>
        <style>
            .sold-out { color: red; font-weight: bold; }
            .low-stock { color: orange; }
            .available { color: green; }
            .badge-free { background-color: #28a745; color: white; padding: 2px 5px; border-radius: 3px; }
            .disabled-link { color: gray; pointer-events: none; text-decoration: none; }
        </style>
    </head>
    <body>
        <h3>Kết quả tìm kiếm cho: "<c:out value="${keyword}" />"</h3>
        <p>Tìm thấy ${fn:length(events)} sự kiện.</p>
        <p>Độ dài từ khóa: ${fn:length(keyword)} ký tự.</p>

        <c:choose>
            <c:when test="${empty events}">
                <p>Không tìm thấy sự kiện nào phù hợp.</p>
            </c:when>
            <c:otherwise>
                <table border="1" cellpadding="10" style="border-collapse: collapse;">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên sự kiện</th>
                            <th>Ngày tổ chức</th>
                            <th>Giá vé</th>
                            <th>Vé còn lại</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="event" items="${events}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td><c:out value="${event.name}" /></td>
                                <td>${event.date}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${event.price == 0}">
                                            <span class="badge-free">MIỄN PHÍ</span>
                                        </c:when>
                                        <c:otherwise>
                                            <fmt:formatNumber value="${event.price}" type="number" /> VNĐ
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${event.remainingTickets == 0}">
                                            <span class="sold-out">HẾT VÉ</span>
                                        </c:when>
                                        <c:when test="${event.remainingTickets < 10}">
                                            <span class="low-stock">Sắp hết (còn ${event.remainingTickets} vé)</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="available">${event.remainingTickets}</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:url var="bookUrl" value="/events/${event.id}/book" />
                                    <c:choose>
                                        <c:when test="${event.remainingTickets == 0}">
                                            <a href="#" class="disabled-link">Đặt vé (Hết vé)</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="${bookUrl}">Đặt vé</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>

        <hr>
        <c:if test="${not empty events}">
            <p>Sự kiện nổi bật nhất:
               <strong>${fn:toUpperCase(events[0].name)}</strong>
            </p>
        </c:if>
    </body>
    </html>
    */
}