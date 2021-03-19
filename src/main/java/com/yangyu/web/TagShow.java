package com.yangyu.web;

import com.yangyu.service.BlogService;
import com.yangyu.service.TagService;
import com.yangyu.service.TypeService;
import com.yangyu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TagShow {


    @Autowired
    TagService tagService;
    @Autowired
    BlogService blogService;

    @GetMapping("/allTags")
    @ResponseBody
    public Result tag(){
        return Result.ok().data("tags",tagService.findTopTags());
    }

    //根据 tag 展示 博客
    @GetMapping("/allTags/{tagId}")
    @ResponseBody
    public Result findBlogsByTag(@PathVariable Long tagId){
        if (tagId==-1){return Result.ok().data("0","未给id");}
        return Result.ok().data("blogs",blogService.findBlogByTag(tagId));
    }

}
