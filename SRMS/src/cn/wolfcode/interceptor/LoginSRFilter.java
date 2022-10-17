package cn.wolfcode.interceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 未登录不能访问静态资源(.jsp)
 * 可以访问(login login.jsp .css .js .png)
 */
@WebFilter("/*")
public class LoginSRFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest)servletRequest;

        //不用登陆-都可以访问的资源-以后缀方式判定
        //login login.jsp .css .js .png
        String [] sr=new String[]{"/login","login.jsp",".css",".js",".png",".jpg"} ;
        //判定这个请求是否以上述的资源结尾
        //定义一个标志-请求是否是以以上后缀结尾
        boolean flag=false ;
        for(String url_suffix:sr){
            if(req.getRequestURI().endsWith(url_suffix)){
                flag=true ;
            }
        }
        //判定是否允许放行  --
        if(flag){
            //直接放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //判定是否登陆
            Object userInfo = req.getSession().getAttribute("userInfo");
            if(userInfo == null){
                //说明没有登陆过
                //进行一个跳转 -登陆页面
                servletRequest.setAttribute("acount_msg","用户未登录");
                req.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
            }else{
               //放行
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
