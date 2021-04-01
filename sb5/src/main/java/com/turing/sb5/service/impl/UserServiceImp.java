package com.turing.sb5.service.impl;

import com.turing.sb5.entity.User;
import com.turing.sb5.entity.UserExample;
import com.turing.sb5.mapper.UserMapper;
import com.turing.sb5.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//管理员实现接口
@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        UserExample example=new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(example);
        if(users.size()==1&&users!=null){
            log.info("在吗---");
            return users.get(0);
        }else{
            return null;
        }

    }
}
