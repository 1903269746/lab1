package com.niuma.web.servlet;

import com.niuma.pojo.User;
import com.niuma.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        //获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");

        //获取程序生成的验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        //判断验证码是否输入正确
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }


        if(service.register(user) == true){
            request.setAttribute("register_msg","注册成功，请重新登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            request.setAttribute("register_msg","该用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
