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
</head>
<body background="../../images/shuben-003.jpg">
<form name="form1" action="../../StudentAddServlet" method="post" >
    <table>
        <tr><td>用户名</td><td><input type="text" name="user_name"></td></tr>
        <tr><td>密码</td><td><input type="text" name="user_pwd"></td></tr>
        <tr><td>Email</td><td><input type="text" name="user_email"></td></tr>

        <tr><td colspan="2">
            <input type="submit" value="提交">
            <input type="reset" value="取消">
        </td></tr>
    </table>
</form>

</body>
</html>
