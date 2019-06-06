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
import java.util.List;

@WebServlet(name = "ShowAllBookServlet", value = {"/ShowAllBookServlet"})
public class ShowAllBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookDao bookDao = new BookDao();
        try {

            List<Book> bookArrayList = bookDao.QueryAll();
            request.setAttribute("bookArrayList",bookArrayList);
            request.getRequestDispatcher("admin/book/showAll.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
