package web;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/axiosServlet")
public class AxiosServlet extends HttpServlet {

    private UserService userService=new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        //接收请求参数
        String username = req.getParameter("username");
        boolean exists = userService.CheckUser(username);
        System.out.println(username);
        //响应数据
        if (exists){
            resp.getWriter().write("true");
        }
        else {
            resp.getWriter().write("false");
        }



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");

        this.doGet(req,resp);
    }
}
