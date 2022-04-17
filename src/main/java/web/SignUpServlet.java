package web;


import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserService userService=new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(userService.CheckUser(username)){
            req.setAttribute("signUp_msg","用户已被注册，注册失败");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }else{
            userService.InsertUser(username,password);
            req.setAttribute("login_msg","注册成功，请登录");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
