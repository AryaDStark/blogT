package com.yangyu.service;

import com.yangyu.po.Consumer;

public interface ConsumerService {

    void save(Consumer consumer);

    Consumer findByConsumer(Consumer consumer);

    Consumer checkConsumer(String username,String password);

    Consumer findByName(String name);

}
