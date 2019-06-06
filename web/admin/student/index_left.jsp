<%--
  Created by IntelliJ IDEA.
  User: ZC Wang
  Date: 2019/4/11
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        p{
            margin:5px 0 0 0;
            padding:0;
            text-indent:1em;
            line-height:150%;
            background-color: #1da1f2;
        }
    </style>
</head>
<body background="../../images/shuben-003.jpg"src="admin/index_right.html" name="right" scrolling="auto">
    <p><a href="../../ShowAllStudentServlet" target="right">全部用户</a></p>
    <p><a href="users_add.jsp" target="right">注册用户</a></p>
    <p><a href="users_delete.jsp" target="right">删除用户</a></p>
    <p><a href="users_update.jsp" target="right">更新用户</a></p>
    <p><a href="users_select.jsp" target="right">查询用户</a></p>
</body>
</html>
