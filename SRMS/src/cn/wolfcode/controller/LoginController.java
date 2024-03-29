package cn.wolfcode.controller;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_priviage;
import cn.wolfcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userServiceImpl;



    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(name = "username", required = true) String account,
                              @RequestParam(name = "password", required = true) String password,
                              HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();
        //调用service层  (账号以及密码同时传入service/dao/)
        T_User user = userServiceImpl.getuser(account);
        //判定账号是否存在
        if (user == null) {
            //说明这个账号是不存在的
            //返回跳转到登陆页面 -且提示账号不存在
            modelAndView.setViewName("login.jsp");
            modelAndView.addObject("account_msg", "账号不存在");
            return modelAndView;
        }

        //判定账号是否锁定
        if (user.getUstatus() == 0) {
            //跳转到登陆页面
            //提示账号锁定
            modelAndView.setViewName("login.jsp");
            modelAndView.addObject("account_msg", "账号已经锁定");
            return modelAndView;
        }

        //执行账号存在的逻辑
        //判断该账号对应的密码是否匹配  （从浏览器端接收到的密码是否正确）
        if (!user.getUpwd().equals(password)) {
            //密码不匹配怎么办 ？
            ServletContext servletContext = req.getServletContext();
            //剩余次数判定
            Object obj_limit = servletContext.getAttribute("limit_" + user.getUcode());
            //如果账号是第一次/第二次错误  ---只是需要提示-以及剩余次数
            //设置用户一共有N次机会
            int n = 5;
            if (obj_limit == null) {
                //提示-剩余次数
                modelAndView.setViewName("login.jsp");
                modelAndView.addObject("account_msg", "剩余登陆次数为" + (n - 1) + "次");
                //设置session中用户的剩余次数
                servletContext.setAttribute("limit_" + user.getUcode(), n - 1);
                return modelAndView;
            }
            //obj_limit不为null
            //目前剩余的次数
            int limit = (int) obj_limit;
            //如果减一等于 0 说明剩余次数用完了
            if (limit - 1 == 0) {
                //说明当前是最后一次机会
                //如果账号是第三次错误 --除了提示-该该用户的状态 -改为 0  -锁定
                //锁定账号
                userServiceImpl.updateUser(user.getUcode(), (short) 0);
                //设置页面提示信息
                modelAndView.addObject("account_msg", "次数用完,账号锁定");
                //清理session的限制
                servletContext.removeAttribute("limit_" + user.getUcode());
            } else {
                //limit -1>0  说明还有机会  //计算剩余次数-提示
                modelAndView.addObject("account_msg", "密码错误-剩余" + (limit - 1) + "次数");
                //更新session
                servletContext.setAttribute("limit_" + user.getUcode(), limit - 1);
            }
            //跳转到登陆页面 -提示密码不正确
            modelAndView.setViewName("login.jsp");
            return modelAndView;
        }
        //密码正确的逻辑
        //再跳转到主页(操作页面)首先先查询该用户对应的权限
        List<T_priviage> userPri = userServiceImpl.getUserPri(user.getRid());
        //赋值到该用户中的权限属性
        user.setPriList(userPri);
        //跳转 （到主页/登陆）
        //在session中设置用户信息
        req.getSession().setAttribute("userInfo",user);
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }


}
