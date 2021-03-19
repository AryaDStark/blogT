package com.yangyu.service;

import com.yangyu.po.Type;

import java.util.List;

public interface TypeService {

    List<Type> findAllTypes(int pageNum);

    List<Type> findTopTypes();

    void saveType(String name);

    void deleteType(Long id);


    Type getByName(String name);

    Type getById(Long id);

    void updateType(Type type);
 }
