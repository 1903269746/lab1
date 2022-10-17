package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo2")
public class ServletDemo2 implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world~~~");
    }

    public void destroy() {

    }

    public ServletConfig getServletConfig() {
        return null;
    }



    public String getServletInfo() {
        return null;
    }


}
