package com.turing.sb5.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

        //注册拦截器
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new LoginInterceptor())
                    .addPathPatterns("/user/**")//拦截所有
                    .excludePathPatterns("/Login2","/user/Login","/user/login","/css/**","/js/**");//例外的，不需要拦截的
        }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/Login").setViewName("login");
//        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/user/login").setViewName("login");
        registry.addViewController("/Login2").setViewName("Login2");
        registry.addViewController("/basic").setViewName("basic");
        registry.addViewController("/index2").setViewName("index2");
        registry.addViewController("/nav").setViewName("nav");
        registry.addViewController("/tabs").setViewName("dialog");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index3").setViewName("index3");
        registry.addViewController("/dialog").setViewName("dialog");



    }
    }

