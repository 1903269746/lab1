package com.itheima.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet(urlPatterns = "/req2")
public class requestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET请求逻辑
        System.out.println("get...");

        //1.获取所有参数的map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key:map.keySet()){
            //username:xxxx
            System.out.print(key+":");

            //获取值
            String[] values = map.get(key);
            for(String value : values){
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");

        //2.获取对应参数值
       String[] hobbies = req.getParameterValues("hobby");
       for(String hobby : hobbies){
           System.out.println(hobby);
       }

       //3.根据key获取单个参数值
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        //4.处理乱码
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        username= new String(bytes,StandardCharsets.UTF_8);

//        username= new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        System.out.println(password);
        System.out.println(username);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST请求逻辑
        this.doGet(req,resp);
    }
}
