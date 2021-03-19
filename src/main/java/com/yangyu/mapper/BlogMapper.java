package com.yangyu.mapper;
import com.yangyu.po.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Component
@Mapper
public interface BlogMapper {

    List<Blog> findBlog(@Param("n1") Integer n1,@Param("n")int num );

    void       save(Blog blog);

    void        delete(@Param("id")Long id);

    Blog        getById(@Param("id")Long id);

    void        update(Blog blog);

    List<Blog>  findBlogByType(@Param("id") Long id);

    List<Blog>  findBlogByTag(@Param("id")Long id);

    Integer     count();

    List<Blog>   findHotBlog();

    List<Blog>   findByKeywords(@Param("key") String keywords);
}
