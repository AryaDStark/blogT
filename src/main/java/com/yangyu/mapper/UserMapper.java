package com.yangyu.mapper;

import com.yangyu.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    User checkUser(@Param("u") String username,@Param("p") String password);
}
