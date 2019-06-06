package Servlet;

import Dao.StudentDao;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if(name == "" || pwd == ""){
            out.print("<script>" +
                    "alert('用户名或密码不能为空，点击确定按钮重新登录！');" +
                    "window.location.href='student.html'" +
                    "</script>");
        }else{
            Student student = new Student(name,pwd,email);
            StudentDao studentDao = new StudentDao();

            try {
                studentDao.add(student);

                out.print("<script>" +
                        "alert('注册成功，点击确定按钮调转登录界面！');" +
                        "window.location.href='student.html'" +
                        "</script>");
            } catch (SQLException e) {
                out.print("<script>" +
                        "alert('注册失败！请重新注册。');" +
                        "window.location.href='register.html'" +
                        "</script>");
                e.printStackTrace();
            }
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
