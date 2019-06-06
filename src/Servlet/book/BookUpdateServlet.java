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

@WebServlet(name = "BookUpdateServlet", value = {"/BookUpdateServlet"})
public class BookUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        request.setCharacterEncoding("utf-8");
        String bookNo = request.getParameter("book_no");
        String bookName = request.getParameter("book_name");
        String book_author = request.getParameter("book_author");
        String book_isbn = request.getParameter("book_isbn");
        String book_description = request.getParameter("book_description");
        String book_lent = request.getParameter("book_lent");

        Book book = new Book(bookNo,bookName,book_author,book_isbn,book_description,book_lent);
        BookDao bookDao = new BookDao();
        String outMassage;
        try {
            bookDao.update(book);
            outMassage = "修改成功";

            request.setAttribute("book_no",book.getNo());
            request.setAttribute("book_name",book.getName());
            request.setAttribute("book_author",book.getAuthor());
            request.setAttribute("book_isbn",book.getIsbn());
            request.setAttribute("book_description",book.getDescription());
            request.setAttribute("book_lent",book.getLent());



            request.setAttribute("outMassage",outMassage);

            request.getRequestDispatcher("admin/book/show.jsp").forward(request,response);

        } catch (Exception e) {
            outMassage = "修改失败";
            request.setAttribute("outputMessage",outMassage);

            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
