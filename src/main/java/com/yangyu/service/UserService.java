package com.yangyu.service;

import com.yangyu.po.User;

public interface UserService {

    User checkUser(String username,String password);
}
