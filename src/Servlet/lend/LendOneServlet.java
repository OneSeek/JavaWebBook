package Servlet.lend;

import Dao.BookDao;
import Dao.LendDao;
import model.Book;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LendOneServlet", value = {"/LendOneServlet"})
public class LendOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String no = request.getParameter("book_no");
        BookDao bookDao = new BookDao();
        LendDao lendDao = new LendDao();
        Student student = (Student) session.getAttribute("student");
        try {
            Book book = bookDao.findUserByNo(no);
            lendDao.Lend(book,student);
            PrintWriter out = response.getWriter();
            out.print("借阅成功");
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.print("借阅失败");
            e.printStackTrace();
        }
    }
}
