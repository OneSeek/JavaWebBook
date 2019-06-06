package Servlet;

import Dao.StudentDao;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentServlet", value = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();



        StudentDao studentDao = new StudentDao();
        try {
            Student student = studentDao.findUserByName(name);
            if (student.getPwd().equals(pwd)){
                HttpSession session = request.getSession();
                session.setAttribute("student",student);
                request.getRequestDispatcher("student/index.html").forward(request, response);

            }else {
                out.print("密码错误");
            }
        } catch (Exception e) {
            out.print("登录失败，请前往注册或检查账号");
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
