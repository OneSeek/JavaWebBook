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

@WebServlet(name = "BookSelectServlet",value = {"/BookSelectServlet"})
public class BookSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String outMassage;

        String bookNo = request.getParameter("book_no");

        Book book;

        BookDao bookDao= new BookDao();


        try {
            book = bookDao.findUserByNo(bookNo);

            request.setAttribute("book_no",book.getNo());
            request.setAttribute("book_name",book.getName());
            request.setAttribute("book_author",book.getAuthor());
            request.setAttribute("book_isbn",book.getIsbn());
            request.setAttribute("book_description",book.getDescription());
            request.setAttribute("book_lent",book.getLent());
            request.getRequestDispatcher("admin/book/show.jsp").forward(request,response);

        } catch (Exception e) {
            PrintWriter out = response.getWriter();

            out.print("查询失败");

            e.printStackTrace();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
