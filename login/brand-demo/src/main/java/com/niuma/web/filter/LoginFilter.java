package com.niuma.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.LinkedTransferQueue;

/**
 * 登录验证过滤器
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //判断访问路径是否与登录注册有关
        String[] urls = {"/login.jsp","/loginServlet","/css/","/imgs/","/register.jsp","/registerServlet","/checkCodeServlet","/register.html","/selectUserServlet","/login.html"};
        String u = req.getRequestURL().toString();
        for (String url : urls) {
            if(u.contains(url)){
                chain.doFilter(req, response);
                return;
            }
        }

        //判断是否登录
        HttpSession session =req.getSession();
        Object user =  session.getAttribute("user");
        if(user != null){
            chain.doFilter(req, response);
        }else{
            req.setAttribute("login_msg","您还未登录");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
