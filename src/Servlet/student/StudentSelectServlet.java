package Servlet.student;

import Dao.StudentDao;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentSelectServlet",value = {"/StudentSelectServlet"})
public class StudentSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String outMassage;

        String userName = request.getParameter("user_name");

        Student student;

        StudentDao studentDao = new StudentDao();


        try {
            student = studentDao.findUserByName(userName);

            request.setAttribute("user_name",student.getName());
            request.setAttribute("user_pwd",student.getPwd());
            request.setAttribute("user_email",student.getEmail());
            request.getRequestDispatcher("admin/student/show.jsp").forward(request,response);

        } catch (Exception e) {
            PrintWriter out = response.getWriter();

            out.print("查询失败");

            e.printStackTrace();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
