<%@ page import="Dao.StudentDao" %>
<%@ page import="model.Student" %>
<%@ page import="model.Book" %>
<%@ page import="Dao.BookDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="../../images/shuben-003.jpg">
<%
    BookDao bookDao = new BookDao();
    Book book = bookDao.findUserByNo(request.getParameter("book_no"));
%>
<form action="../../BookUpdateServlet" method="post">
    <tr><td>书号:&nbsp;&nbsp;</td><td><input type="text" name="book_no" value=<%=book.getNo()%>></td></tr></br>
    <tr><td>书名:&nbsp;&nbsp;</td><td><input type="text" name="book_name" value=<%=book.getName()%>></td></tr></br>
    <tr><td>作者:&nbsp;&nbsp;</td><td><input type="text" name="book_author" value=<%=book.getAuthor()%>></td></tr></br>
    <tr><td>ISBN:&nbsp;</td><td><input type="text" name="book_isbn" value=<%=book.getIsbn()%>></td></tr></br>
    <tr><td>描述:&nbsp;&nbsp;</td><td><input type="text" name="book_description" value=<%=book.getDescription()%>></td></tr></br>
    <tr><td>是否可借:&nbsp;</td><td><input type="text" name="book_lent" value=<%=book.getLent()%>></td></tr></br>

    <tr><td colspan="2">
        <input type="submit" value="更新">
        <input type="reset" value="取消">
    </td></tr>
</form>
</body>
</html>
