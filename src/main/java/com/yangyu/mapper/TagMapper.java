package com.yangyu.mapper;

import com.yangyu.po.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface TagMapper {

    List<Tag> findAllTags(@Param("n")Integer pageNum);
    List<Tag> findTopTags();
    void      saveTag(@Param("name")String name);
    void      deleteTag(@Param("id")Long id);
    Tag       getById(@Param("id")Long id);
    Tag       getByName(@Param("name")String name);
    void      updateTag(Tag tag);
}
