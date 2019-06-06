package Servlet.student;

import Dao.StudentDao;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentUpdateServlet", value = {"/StudentUpdateServlet"})
public class StudentUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("user_name");
        String userPwd = request.getParameter("user_pwd");
        String userEmail = request.getParameter("user_email");

        Student student = new Student(userName,userPwd,userEmail);
        StudentDao studentDao = new StudentDao();
        String outMassage;
        try {
            studentDao.update(student);
            outMassage = "修改成功";

            request.setAttribute("user_name",student.getName());
            request.setAttribute("user_pwd",student.getPwd());
           request.setAttribute("user_email",student.getEmail());
            request.setAttribute("outMassage",outMassage);

            request.getRequestDispatcher("admin/student/show.jsp").forward(request,response);

        } catch (Exception e) {
            outMassage = "修改失败";
            request.setAttribute("outputMessage",outMassage);

            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
