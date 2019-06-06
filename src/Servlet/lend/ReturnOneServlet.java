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

@WebServlet(name = "ReturnOneServlet", value = {"/ReturnOneServlet"})
public class ReturnOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String no = request.getParameter("book_no");
        BookDao bookDao = new BookDao();
        LendDao lendDao = new LendDao();
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        try {
            Book book = bookDao.findUserByNo(no);
            lendDao.Return(book,(Student) session.getAttribute("student"));
            out.print("还书成功");
        } catch (Exception e) {
            out.print("还书失败");
            e.printStackTrace();
        }
    }
}
