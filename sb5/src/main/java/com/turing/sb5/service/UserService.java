package com.turing.sb5.service;

import com.turing.sb5.entity.User;


//管理员接口
public interface UserService {

    /**
     * 用户登陆
     * @param username 用户名
     * @param paddword 用户密码
     * @return
     */
    public User login(User user);
}
