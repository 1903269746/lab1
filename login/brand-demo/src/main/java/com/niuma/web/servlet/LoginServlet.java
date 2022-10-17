package com.niuma.web.servlet;

import com.niuma.pojo.User;
import com.niuma.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service =new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String value = request.getParameter("remember");
        User user = service.login(username,password);

        //判断
        if(user != null){
            //成功，跳转到查询所有
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            if("1".equals(value)){
                //创建Cookie对象
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);

                //设置Cookie存活时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                //发送
                response.addCookie(c_password);
                response.addCookie(c_username);
            }
            String contexPath = request.getContextPath();
            response.sendRedirect(contexPath+"/selectAllServlet");
        }else{
            //失败
            request.setAttribute("login_msg","用户名或密码错误");
           request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
