package cn.wolfcode.controller;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //新增用户
    @RequestMapping("/userAdd")
    public ModelAndView addUser(@RequestParam(name = "userId") String ucode,
                                @RequestParam(name = "userName",required = false) String uname,
                                @RequestParam(name = "userpassword",required = false)String upwd,
                                @RequestParam(name = "userRemi",required = false)String uremi,
                                @RequestParam(name = "userSex")String usex,
                                @RequestParam(name = "data",required = false)Date ubirthday,
                                @RequestParam(name = "userphone",required = false)String uphone,
                                @RequestParam(name = "userAddress",required = false)String uaddress,
                                @RequestParam(name = "userlei",required = false)String rid,
                                HttpServletRequest request
                                ) throws UnsupportedEncodingException {

        ModelAndView mav = new ModelAndView();
        request.setCharacterEncoding("utf-8");

        //将数据封装到t_user
        T_User t_user =new T_User();
        t_user.setUcode(ucode);
        t_user.setUname(uname);
        t_user.setUaddress(uaddress);
        t_user.setUpwd(upwd);
        t_user.setUbirthday(ubirthday);
        t_user.setUphone(uphone);
        if(usex.equals("man")){
            t_user.setUsex((short)1);
        }
        if(usex.equals("woman"))
        {
            t_user.setUsex((short)0);
        }
        if (rid.equals("super")){
            t_user.setRid(1);
        }
        if(rid.equals("normal"))
        {
            t_user.setRid(2);
        }
        mav.addObject("t_user",t_user);

        //判断密码长度是否复合要求

        if(upwd.length()<4 || upwd.length()>16){
            mav.setViewName("userAdd.jsp");
            mav.addObject("error_msg","密码长度不符合要求");
            return mav;
        }
        //判断两次输入密码是否相同
        if(!upwd.equals(uremi)){
            mav.setViewName("userAdd.jsp");
            mav.addObject("error_msg","两次输入的密码不相同");
            return mav;
        }else{
            //判断用户是否已存在
            if(userService.selectUserByCondition(ucode)!=null){
                mav.setViewName("userAdd.jsp");
                mav.addObject("error_msg","用户已存在");
                return mav;
            }else{
                //用户不存在，可以注册
                userService.addUser(t_user);
                mav.setViewName("selectAll");
                return mav;
            }
        }

    }

    @RequestMapping("/selectAll")
    ModelAndView SelectAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<T_User> t_userList = userService.selectAll();

        modelAndView.addObject("userList",t_userList);
        modelAndView.setViewName("forward:userList.jsp");
        return modelAndView;
    }

    @RequestMapping("/editUser")
    ModelAndView EditUser(@RequestParam(name="ucode") String ucode,
                          @RequestParam(name = "userName",required = false) String uname,
                          @RequestParam(name = "usex")String usex,
                          @RequestParam(name = "data",required = false)Date ubirthday,
                          @RequestParam(name = "userphone",required = false)String uphone,
                          @RequestParam(name = "userAddress",required = false)String uaddress,
                          @RequestParam(name = "userlei",required = false)String rid,
                          @RequestParam(name="ustatus",required = false) String ustatus){
        T_User t_user =new T_User();
        ModelAndView modelAndView = new ModelAndView();
        t_user.setUcode(ucode);
        t_user.setUname(uname);
        t_user.setUaddress(uaddress);
        t_user.setUbirthday(ubirthday);
        t_user.setUphone(uphone);
        if(usex.equals("man")){
            t_user.setUsex((short)1);
        }
        if(usex.equals("woman"))
        {
            t_user.setUsex((short)0);
        }
        if (rid.equals("super")){
            t_user.setRid(1);
        }
        if(rid.equals("normal"))
        {
            t_user.setRid(2);
        }
        if(ustatus.equals("on")){
            t_user.setUstatus((short)1);
        }
        if(ustatus.equals("off"))
        {
            t_user.setUstatus((short)0);
        }
        userService.editUser(t_user);
        modelAndView.addObject("user",t_user);
        modelAndView.setViewName("forward:selectAll");
        return modelAndView;
    }

    @RequestMapping("/selectByUcode")
    ModelAndView SelectByUcode(String ucode){
        T_User t_user = userService.selectByUcode(ucode);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", t_user);
        modelAndView.setViewName("userUpdate.jsp");
    return modelAndView;
    }

    @RequestMapping("/selectByUcode2")
    ModelAndView SelectByUcode2(String ucode){
        T_User t_user = userService.selectByUcode(ucode);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", t_user);
        modelAndView.setViewName("userView.jsp");
        return modelAndView;
    }

    @RequestMapping("/selectByUcode3")
    ModelAndView SelectByUcode3(String ucode){
        T_User t_user = userService.selectByUcode(ucode);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", t_user);
        modelAndView.setViewName("userDelete.jsp");
        return modelAndView;
    }

    @RequestMapping("/deleteByUcode")
    ModelAndView DeleteByUcode(@RequestParam(name="ucode") String ucode){
        ModelAndView modelAndView = new ModelAndView();
        userService.deleteByUcode(ucode);
        modelAndView.setViewName("selectAll");
        return modelAndView;
    }

    @RequestMapping("/selectBySingle")
    void SelectBySingle(@RequestParam(name="str") String str,
                        HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {

        List<T_User> userList = userService.selectBySingle(str);
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("userList.jsp").forward(request,response);

        System.out.println(userList);


    }
}
