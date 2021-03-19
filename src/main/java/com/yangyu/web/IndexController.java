package com.yangyu.web;




import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangyu.po.Blog;
import com.yangyu.po.Type;
import com.yangyu.service.BlogService;
import com.yangyu.service.TagService;
import com.yangyu.service.TypeService;
import com.yangyu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;

    //展示 type
    @GetMapping("/types")
    @ResponseBody
    public Result showIndexTypes()  {
     //   System.out.println(typeService.findTopTypes());
        return Result.ok().data("types",typeService.findTopTypes());
    }
    @GetMapping("/tags")
    @ResponseBody
    public Result showIndexTags()  {
    //    System.out.println(typeService.findTopTags());
        return Result.ok().data("tags",tagService.findTopTags());
    }


    //展示 blog
   @GetMapping("/blogPage/{pageNumber}")
   @ResponseBody
    public Result showBlog(@PathVariable int pageNumber){
          if (pageNumber==-1){pageNumber=0;}
//          model.addAttribute("page",blogService.findBlog(pageNumber,3));
         return  Result.ok().data("blogs",blogService.findBlog(pageNumber,10)).data("count",blogService.count());
    }


    //根据views 排热门blog
    @GetMapping("/hotBlogs")
    @ResponseBody
    public Result hotBlog(){
        return Result.ok().data("hotBlogs",blogService.findHotBlog());
    }



    //测试----------------------------
/*
    @GetMapping("/")
    public void showBlog(Model model){

     System.out.println( blogService.findBlog(0,2));
    }
*/
/*
    @GetMapping("/")
    @ResponseBody
     public Result show(){
        return  Result.ok().data("message","welcome").data("page","index");
    }
*/
}
