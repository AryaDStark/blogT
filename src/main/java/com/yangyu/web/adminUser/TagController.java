package com.yangyu.web.adminUser;

import com.yangyu.po.Tag;
import com.yangyu.po.Type;
import com.yangyu.service.TagService;
import com.yangyu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/tagControl/{pageNum}")
    @ResponseBody
    public Result showAllTags(@PathVariable int pageNum){
        if (pageNum==-1){pageNum=0;}
        return Result.ok().data("tags",tagService.findAllTags(pageNum));
    }

    //增加
    @GetMapping("/addTag/{name}")
    @ResponseBody
    public Result addTag(@PathVariable String name){
        tagService.saveTag(name);
        return  Result.ok().data("message","成功");
    }

    //删除
    @GetMapping("/deleteTag/{id}")
    @ResponseBody
    public Result deleteTag(@PathVariable long id){
        tagService.deleteTag(id);
        return  Result.ok().data("message","成功");
    }

    //填充 未作修改 的页面
    @GetMapping("/updateTag/{id}")
    @ResponseBody
    public Result showThisTag(@PathVariable Long id){
        return  Result.ok().data("tag",tagService.getById(id));
    }


    //提交修改后的 tag
    @GetMapping("/updateTag/{tag}")
    @ResponseBody
    public Result updateTag(@PathVariable Tag tag){
        if (tagService.getByName(tag.getName())==null){
            tagService.updateTag(tag);
            return Result.ok().data("message","over");
        }
        else{ return Result.error().data("message","名儿重了 换个");}
    }

}
