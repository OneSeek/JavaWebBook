package Servlet;

import Dao.BookDao;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LendBookServlet", value = {"/LendBookServlet"})
public class  LendBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookDao bookDao = new BookDao();
        try {

            List<Book> bookArrayList = bookDao.QueryAll();
            request.setAttribute("bookArrayList",bookArrayList);
            request.getRequestDispatcher("student/showAll.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
