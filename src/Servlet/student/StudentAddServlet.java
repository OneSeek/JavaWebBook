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
import java.sql.SQLException;

@WebServlet(name = "StudentAddServlet", value = {"/StudentAddServlet"} )
public class StudentAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("user_name");
        String pwd = request.getParameter("user_pwd");
        String email = request.getParameter("user_email");

        if(name == "" || pwd == ""){
            out.print("用户名或密码不能为空，添加失败");
        }else{
            Student student = new Student(name,pwd,email);
            StudentDao studentDao = new StudentDao();


            try {
                studentDao.add(student);

                out.print("添加成功");
            } catch (SQLException e) {
                out.print("添加失败");
                e.printStackTrace();
            }


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
