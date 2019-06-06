<%@ page import="Dao.StudentDao" %>
<%@ page import="model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="../../images/shuben-003.jpg">
<%
    StudentDao studentDao = new StudentDao();
    Student student = studentDao.findUserByName(request.getParameter("user_name"));
%>
<form action="../../StudentUpdateServlet" method="post">
    <tr><td>用户名</td><td><input type="text" name="user_name" value=<%=student.getName()%>></td></tr>
    <tr><td>密码</td><td><input type="text" name="user_pwd" value=<%=student.getPwd()%>></td></tr>
    <tr><td>Email</td><td><input type="text" name="user_email" value=<%=student.getEmail()%>></td></tr>

    <tr><td colspan="2">
        <input type="submit" value="更新">
        <input type="reset" value="取消">
    </td></tr>
</form>
</body>
</html>
