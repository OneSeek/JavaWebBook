
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <style>
        table{
            margin:0 auto;/* 自动居中，不论网页的大小 */

            width:80%;/* 宽度只占当前页面的80% */

        }
    </style>
</head>
<body background="images/shuben-003.jpg">



<table border="1">
    <tr>
    <tr><th>书号</th><th>书名</th><th>作者</th><th>ISBN</th><th>描述</th><th>是否可借</th></tr>
    </tr>

    <tr>
        <td>${book_no}</td>
        <td>${book_name}</td>
        <td>${book_author}</td>
        <td>${book_isbn}</td>
        <td>${book_description}</td>

        <c:if test="${book_lent >0}">
            <td>可借</td>
        </c:if>
        <c:if test="${book_lent <1}">
            <td>不可借</td>
        </c:if>

    </tr>
</table>
</body>

<%--<%--%>
<%--    User user = (User) request.getAttribute("user");--%>
<%--    out.print(user.getUserId());--%>
<%--    out.print(user.getUserName());--%>
<%--%>--%>
</html>
