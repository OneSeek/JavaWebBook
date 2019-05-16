<%@ page import="JavaBean.User" %>
<%@ page import="JavaBean.Student" %><%--
  Created by IntelliJ IDEA.
  User: ZC Wang
  Date: 2019/5/10
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
    <script>

    </script>

</head>
<body>
<%
    String name = request.getParameter("name");
    String pwd = request.getParameter("pwd");
    String email = request.getParameter("email");
    User user = new Student(name,pwd,email);
    out.print(name);
%>
</body>
</html>
