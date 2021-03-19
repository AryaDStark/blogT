package com.yangyu.service.Impl;

import com.yangyu.mapper.ConsumerMapper;
import com.yangyu.po.Consumer;
import com.yangyu.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ConsumerMapper consumerMapper;

    @Override
    public void save(Consumer consumer) {
        consumerMapper.save(consumer);
    }

    @Override
    public Consumer findByConsumer(Consumer consumer) {
        return consumerMapper.findByConsumer(consumer);
    }

    @Override
    public Consumer checkConsumer(String username, String password) {
        return consumerMapper.checkConsumer(username,password);
    }

    @Override
    public Consumer findByName(String name) {
        return consumerMapper.findByName(name);
    }
}
