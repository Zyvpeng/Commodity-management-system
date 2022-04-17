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
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService=new BrandService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //查询session
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        //查询品牌信息

        List<Brand> brands = brandService.selectAll();

        //存入request域中
        req.setAttribute("brands",brands);
        req.setAttribute("username",username);

        //转发
        req.getRequestDispatcher("/brand.jsp").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
