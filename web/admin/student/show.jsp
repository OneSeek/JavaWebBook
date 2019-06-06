
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        <td>学生名</td><td>密码</td><td>用户邮箱</td>
    </tr>

    <tr>
        <td>${user_name}</td>
        <td>${user_pwd}</td>
        <td>${user_email}</td>
    </tr>
</table>

</body>
<%--<%--%>
<%--    User user = (User) request.getAttribute("user");--%>
<%--    out.print(user.getUserId());--%>
<%--    out.print(user.getUserName());--%>
<%--%>--%>
</html>
