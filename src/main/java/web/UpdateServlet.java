package web;

import pojo.Brand;
import service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandService service=new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String id= req.getParameter("id");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        Brand brand=new Brand(Integer.parseInt(id),brandName,companyName,Integer.parseInt(ordered),description,Integer.parseInt(status));

        service.Update(brand);

        req.getRequestDispatcher("/selectAllServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
