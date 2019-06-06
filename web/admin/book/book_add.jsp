<%--
  Created by IntelliJ IDEA.
  User: ZC Wang
  Date: 2019/4/11
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            text-align:center;
            margin-left:auto;
            margin-right:auto;
        }
    </style>
</head>
<body background="../../images/shuben-003.jpg" >
<form name="form1" action="../../BookAddServlet" method="post" >
    <table>
        <tr><td>书号</td><td><input type="text" name="book_no"></td></tr>
        <tr><td>书名</td><td><input type="text" name="book_name"></td></tr>
        <tr><td>作者</td><td><input type="text" name="book_author"></td></tr>
        <tr><td>isbn</td><td><input type="text" name="book_isbn"></td></tr>
        <tr><td>描述</td><td><input type="text" name="book_description"></td></tr>

        <tr><td colspan="2">
            <input type="submit" value="提交">
            <input type="reset" value="取消">
        </td></tr>
    </table>
</form>

</body>
</html>
