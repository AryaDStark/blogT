package com.yangyu.web;

import com.yangyu.service.BlogService;
import com.yangyu.service.TypeService;
import com.yangyu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TypeShow {

    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;

    @GetMapping("/allTypes")
    @ResponseBody
    public Result type(){
        return Result.ok().data("types",typeService.findTopTypes());
    }


    //根据 type展示博客
    @GetMapping("/allTypes/{typeId}")
    @ResponseBody
    public Result findBlogsByType(@PathVariable Long typeId){
        if (typeId==-1){return Result.ok().data("0","未给id");}
        return Result.ok().data("blogs",blogService.findBlogByType(typeId));
    }

}

