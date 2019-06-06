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
<body background="../../images/shuben-003.jpg" src="admin/index_right.html" name="right" scrolling="auto">
    <p><a href="../../ShowAllBookServlet" target="right">全部书籍</a></p>
    <p><a href="book_add.jsp" target="right">添加书籍</a></p>
    <p><a href="book_delete.jsp" target="right">删除书籍</a></p>
    <p><a href="book_update.jsp" target="right">更新书籍</a></p>
    <p><a href="book_select.jsp" target="right">查询书籍</a></p>
</body>
</html>
