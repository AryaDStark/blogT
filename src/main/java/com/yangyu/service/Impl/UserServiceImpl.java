package com.yangyu.service.Impl;

import com.yangyu.mapper.UserMapper;
import com.yangyu.po.User;
import com.yangyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        return userMapper.checkUser(username,password);
    }
}
