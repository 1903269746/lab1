package com.xxx.controller;

import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userServiceImpl ;


    @RequestMapping("/test")
    public ModelAndView test(){
        //查询操作
        int userCount = userServiceImpl.getUserCount();
        //数据库t_user表中的数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");
        modelAndView.addObject("number",userCount);
        return modelAndView;
    }

}
