package com.yangyu.mapper;

import com.yangyu.po.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ConsumerMapper {

    void save(Consumer consumer);

    Consumer findByConsumer(Consumer consumer);

    Consumer checkConsumer(@Param("u")String username,@Param("p")String password);

    Consumer findByName(@Param("name")String name);
}
