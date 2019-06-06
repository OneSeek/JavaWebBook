
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <style>
        table{
            margin:0 auto;/* 自动居中，不论网页的大小 */

            width:80%;/* 宽度只占当前页面的80% */

        }
    </style>
</head>

<body background="http://localhost:8080/JavaWebBook/images/shuben-003.jpg">
<table align="center" border="1">

    <tr><th>书号</th><th>书名</th><th>借阅时间</th><th>应还时间</th><th>还书</th></tr>
    <c:forEach var="book" items="${bookArrayList}">
        <tr>
            <td>${book.bookno}</td>
            <td>${book.bookname}</td>
            <td>${book.starttime}</td>
            <td>${book.outtime}</td>
            <td><a href="${pageContext.request.contextPath}/ReturnOneServlet?book_no=${book.bookno}">还书</a></td>
        </tr>

    </c:forEach>

</table>


</body>
</html>
