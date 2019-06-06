package Servlet.book;

import Dao.BookDao;
import Dao.StudentDao;
import model.Book;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "BookAddServlet", value = {"/BookAddServlet"} )
public class BookAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String no = request.getParameter("book_no");
        String name = request.getParameter("book_name");
        String author = request.getParameter("book_author");
        String isbn = request.getParameter("book_isbn");
        String description = request.getParameter("book_description");

        Book book= new Book(no,name,author,description,"1",isbn);
        BookDao bookDao = new BookDao();


        try {
            bookDao.add(book);

            out.print("添加成功");
        } catch (Exception e) {
            out.print("添加失败");
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
