<%--
  Created by IntelliJ IDEA.
  User: ZC Wang
  Date: 2019/4/11
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="../../images/shuben-003.jpg">
<form name="form1" action="../../BookSelectServlet" method="post">
    书号：<input type="text" name="book_no"><br/>
    <input type="submit" value="查询">
    <input type="reset" value="取消">
</form>
</body>
</html>
