package com.turing.sb5.controller;

import com.turing.sb5.entity.User;
import com.turing.sb5.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    //测试控制器
//    @GetMapping("/index")
//    public String test(){
//          return "index";
//    }

    @PostMapping("/Login2")
    @ResponseBody
    public String login2(User user, HttpServletRequest request){
        log.info("我来了。。。。。");
        User login = userService.login(user);
        if(login==null){
            log.info("登陆失败!");
            return "error";
        }else{
            //绑定参数
            request.getSession().setAttribute("login",login);
            log.info("登陆成功!");
            return "success";
        }
    }

    //登陆控制器
    @PostMapping("/Login")
    public String login(User user, HttpServletRequest request){
        User login = userService.login(user);
        if(login==null){
            log.info("登陆失败!");
            return "login";
        }else{
            //绑定参数
            request.getSession().setAttribute("login",login);
            log.info("登陆成功!");
            return "redirect:/emp/";
        }
    }
}
