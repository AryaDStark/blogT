package com.yangyu.service;


import com.yangyu.po.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BlogService {

   List<Blog> findBlog(int pageNumber,int num);

   void        save(Blog blog);

   void         delete(Long id);

   Blog       getById(Long id);

   void       update(Blog blog);

   List<Blog>  findBlogByType(Long id);

   List<Blog>  findBlogByTag(Long id);

   Integer         count();

    List<Blog>           findHotBlog();

   List<Blog>   findByKeywords(String keywords);

}
