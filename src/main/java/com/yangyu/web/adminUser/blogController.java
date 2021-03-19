package com.yangyu.web.adminUser;

import com.yangyu.po.Blog;
import com.yangyu.po.Tag;
import com.yangyu.service.BlogService;
import com.yangyu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class blogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blog/{pageNum}")
    @ResponseBody
    public Result showAllBlogs(@PathVariable int pageNum){
        if (pageNum==-1){pageNum=0;}
        return Result.ok().data("blogs",blogService.findBlog(pageNum,3));
    }


    //增加
    @GetMapping("/addBlog/{blog}")
    @ResponseBody
    public Result addBlog(@PathVariable Blog blog){
        blogService.save(blog);
        return  Result.ok().data("message","成功");
    }

    //删除
    @GetMapping("/delete/{id}")
    @ResponseBody
    public Result deleteTag(@PathVariable Long id){
        blogService.delete(id);
        return  Result.ok().data("message","成功");
    }

    //填充 未作修改 的页面
    @GetMapping("/updateBlog/{id}")
    @ResponseBody
    public Result showThisTag(@PathVariable Long id){
        return  Result.ok().data("tag",blogService.getById(id));
    }

    //提交修改后的 blog
    @GetMapping("/updateBlog/{blog}")
    @ResponseBody
    public Result updateTag(@PathVariable Blog blog){
        blogService.update(blog);
        return Result.ok().data("message","ok");
    }






}
