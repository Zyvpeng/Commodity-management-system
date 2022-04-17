package web;

import pojo.Brand;
import service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService service=new BrandService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Brand brand = service.SelectById(Integer.parseInt(id));

        //获取Session信息
        HttpSession session = req.getSession();
        String username=(String)session.getAttribute("username");

        //存储并转发
        req.setAttribute("brand",brand);
        req.setAttribute("username",username);

        req.getRequestDispatcher("update.jsp").forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
