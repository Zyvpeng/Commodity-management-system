package web;


import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.JSONFunctions;
import pojo.Admin;
import service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/adminSignUpServlet")
public class AdminSignUpServlet extends HttpServlet {

   private AdminService adminService= new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        BufferedReader br= req.getReader();

        String params=br.readLine();
        Admin admin1 = JSON.parseObject(params, Admin.class);

        if(adminService.SelectAdminByName(admin1.getAdminName())!=null){
            System.out.println("fail");
            resp.getWriter().write("false");

        }else {
            HttpSession session = req.getSession();
            session.setAttribute("adminName",admin1.getAdminName());

            Admin admin = new Admin(114514, admin1.getAdminName(), admin1.getPassword());
            adminService.InsertAdmin(admin);
            resp.getWriter().write("true");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        this.doGet(req,resp);
    }
}
