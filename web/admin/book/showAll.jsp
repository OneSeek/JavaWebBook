
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
<table border="1" background="images/shuben-003.jpg">

    <tr><th>书号</th><th>书名</th><th>作者</th><th>ISBN</th><th>描述</th><th>是否可借</th></tr>

    <c:forEach var="book" items="${bookArrayList}">
        <tr>
            <td>${book.no}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.isbn}</td>
            <td>${book.description}</td>
            <c:if test="${book.lent > 0}">
                <td>可借</td>
            </c:if>
            <c:if test="${book.lent < 1}">
                <td>已借</td>
            </c:if>

        </tr>

    </c:forEach>
</table>


</body>
</html>
