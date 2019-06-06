package Servlet.lend;

import Dao.BookDao;
import Dao.LendDao;
import model.Book;
import model.Lend;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BorrowedBooksServlet", value = {"/BorrowedBooksServlet"})
public class BorrowedBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        LendDao lendDao = new LendDao();

        Student student = (Student) session.getAttribute("student");
        String studentName = student.getName();
        try {

            List<Lend> bookArrayList = lendDao.LendQueryAll(studentName);
            request.setAttribute("bookArrayList",bookArrayList);
            request.getRequestDispatcher("student/BorrowedBooks.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
