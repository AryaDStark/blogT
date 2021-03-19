package com.yangyu.service.Impl;

import com.yangyu.mapper.TypeMapper;
import com.yangyu.po.Type;
import com.yangyu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
   @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Type> findTopTypes() {
        return typeMapper.findTopTypes();
    }

    @Override
    public List<Type> findAllTypes(int pageNum) {
        int n1=pageNum*3+1;
        return typeMapper.findAllTypes(n1);
    }

    @Override
    public void saveType(String name) {
        typeMapper.saveType(name);
    }

    @Override
    public void deleteType(Long id) {
        typeMapper.deleteType(id);
    }

    @Override
    public Type getById(Long id) {
        return typeMapper.getById(id);
    }

    @Override
    public Type getByName(String name) {
        return typeMapper.getByName(name);
    }
/**
 * 处理接收的数据
 */

    @Override
    public void updateType(Type type) {
        typeMapper.updateType(type);
    }
}
