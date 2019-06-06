package Servlet;

import model.AdminConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminServlet",value = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if(name.equals(AdminConstant.name)&&pwd.equals(AdminConstant.pwd)){
            request.getRequestDispatcher("admin/index.html").forward(request, response);
        }else{
            out.print("登录失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
