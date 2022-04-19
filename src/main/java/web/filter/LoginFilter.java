package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证的filter
 */

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest) servletRequest;
        //判断资源路径是否和登录注册相关

        String[] urls={"/axiosServlet","index.html","/login.jsp","/imgs/","/css/","/ServletLogin","register.jsp","register.html","/registerServlet","AdminRegister.html","/adminSignUpServlet","/axios-0.18.0.js"};

        String url = req.getRequestURL().toString();
//        System.out.println(url);
        for (String u:urls){
            if(url.contains(u)){
                filterChain.doFilter(req,servletResponse);
                return;
            }
        }






        HttpSession se = req.getSession();
        Object user = se.getAttribute("username");
        Object adminName = se.getAttribute("adminName");

        if(user!=null||adminName!=null){
            //用户登录过了
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //采取重定向的方式，不改变url
            req.setAttribute("login_msg","您尚未登录!");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);


            //不能采取转发的方式，因为会改变url地址，导致filter拦截，这样就会形成一个死循环
//          HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
//          httpServletResponse.sendRedirect("login.jsp");
        }

    }

    @Override
    public void destroy() {

    }
}
