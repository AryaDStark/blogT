package com.yangyu.mapper;

import com.yangyu.po.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface TypeMapper {

    List<Type> findAllTypes(@Param("page") Integer pageNum);
    List<Type> findTopTypes();
    void       saveType(@Param("name") String name);
    Type        getById(@Param("id")Long id);
    Type        getByName(@Param("name")String name);
    void       deleteType(@Param("id") Long id);
    void        updateType(Type type);

}
