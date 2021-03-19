package com.yangyu.mapper;

import com.yangyu.po.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface CommentMapper {
    List<Comment> findByBlogId(@Param("id") Long id);

    void   save(Comment comment);
}
