package com.turing.sb5.config;

import com.turing.sb5.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    //在Handler执行前会自动调用的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("login");

        if(user == null){
            response.sendRedirect(request.getContextPath()+"/user/Login");//跳转登录控制器
            log.info("拦截器拦截");
            return false;//拦截
        }else{
            log.info("拦截器放行");
            return true;//不拦截
        }
    }
}

