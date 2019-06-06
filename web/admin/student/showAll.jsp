
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
<table border="1">

    <tr><th>姓名</th><th>密码</th><th>Email</th></tr>
    <c:forEach var="student" items="${studentArrayList}">
        <tr>
            <td>${student.name}</td>
            <td>${student.pwd}</td>
            <td>${student.email}</td>
        </tr>

    </c:forEach>
</table>


</body>
</html>
