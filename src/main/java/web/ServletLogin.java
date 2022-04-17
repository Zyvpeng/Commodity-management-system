package web;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    private UserService userService =new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取复选框数据
        String remember = req.getParameter("remember");
        boolean exists = userService.SelectUser(username, password);

        if (exists){
            //这样做不好，因为没有数据要共享，直接重定向就行
//            req.getRequestDispatcher("/selectAllServlet").forward(req,resp);

            //判断是否记住账号
            if ("1".equals(remember)){
                //发送Cookie
                 Cookie c_username=new Cookie("username",username);
                 Cookie c_password=new Cookie("password",password);

                 //设置存活时间
                c_username.setMaxAge(60*60*24);
                c_password.setMaxAge(60*60*24);
                resp.addCookie(c_username);
                resp.addCookie(c_password);
            }
            //将user对象存储到session中
            HttpSession session = req.getSession();
            session.setAttribute("username",username);

            resp.sendRedirect("/ServletCRUD/selectAllServlet");
        }else{
            //将登录错误的提示转发给jsp      转发
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
