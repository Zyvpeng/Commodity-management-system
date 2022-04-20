package web;


import com.alibaba.fastjson.JSON;
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
import java.util.List;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    private AdminService adminService = new AdminService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        BufferedReader br= req.getReader();

        String params=br.readLine();

        System.out.println(params);
        Admin admin = JSON.parseObject(params, Admin.class);

        List<Admin> admins = adminService.SelectAllAdmin();

        for(Admin a:admins){

            if(a.getAdminName().equals(admin.getAdminName())&&a.getPassword().equals(admin.getPassword())){
                HttpSession session = req.getSession();
                session.setAttribute("adminName",admin.getAdminName());
                resp.getWriter().write("success");
                break;
            }

        }

        resp.getWriter().write("false");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
