
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script>
        function update(input,id,oldValue) {

            //获取得到输入框的数据
            var quantity = input.value;

            //询问用户是否真的修改
            var b = window.confirm("你确定修改吗？");

            //如果确定修改，就跳转到修改的Servlet上
            if(b) {
                window.location.href = "${pageContext.request.contextPath}/UpdateQuantity?bookid=" + id + "&quantity=" + quantity + "";
            }else {

                //如果不确定修改，把输入框的数据改成是原来的
                input.value = oldValue;
            }
        }
    </script>
    <style>
        table{
            margin:0 auto;/* 自动居中，不论网页的大小 */

            width:80%;/* 宽度只占当前页面的80% */

        }
    </style>
</head>

<body background="http://localhost:8080/JavaWebBook/images/shuben-003.jpg">
<table align="center" border="1">

    <tr><th>书号</th><th>书名</th><th>作者</th><th>ISBN</th><th>描述</th><th>是否可借</th><th>借阅</th><th>还书</th></tr>

    <c:forEach var="book" items="${bookArrayList}">
        <tr>
            <td>${book.no}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.isbn}</td>
            <td>${book.description}</td>
            <c:if test="${book.lent > 0}">
                <td>可借</td>
            </c:if>
            <c:if test="${book.lent < 1}">
                <td>已借</td>
            </c:if>
            <td><a href="${pageContext.request.contextPath}/LendOneServlet?book_no=${book.no}">借阅</a></td>
            <td><a href="${pageContext.request.contextPath}/ReturnOneServlet?book_no=${book.no}&book_name=${book.name}&book_quantity='1'">还书</a></td>

        </tr>

    </c:forEach>
</table>


</body>
</html>
