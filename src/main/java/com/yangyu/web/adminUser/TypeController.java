package com.yangyu.web.adminUser;

import com.mysql.cj.util.DnsSrv;
import com.yangyu.po.Type;
import com.yangyu.service.TypeService;
import com.yangyu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class TypeController {


    @Autowired
    TypeService typeService;

    //分页展示
    @GetMapping("/typeControl/{pageNum}")
    @ResponseBody
    public Result showAllTypes(@PathVariable int pageNum){
        if(pageNum==-1){  pageNum=0;  }
        return Result.ok().data("types",typeService.findAllTypes(pageNum));
    }

    //增加
    @GetMapping("/addType/{name}")
    @ResponseBody
    public Result addType(@PathVariable String name){
        typeService.saveType(name);
        return  Result.ok().data("message","成功");
    }

    //删除
    @GetMapping("/deleteType/{id}")
    @ResponseBody
    public Result deleteType(@PathVariable Long id){
        typeService.deleteType(id);
        return  Result.ok().data("message","成功");
    }

    //填充 未作修改 的页面
    @GetMapping("/updateType/{id}")
    @ResponseBody
    public Result showThisType(@PathVariable Long id){
        return  Result.ok().data("type",typeService.getById(id));
    }
/*
*
*  处理接收的数据
*
* */

    //提交修改后的 type
    @GetMapping("/updateType/{type}")
    @ResponseBody
    public Result updateType(@PathVariable Type type){
         if (typeService.getByName(type.getName())==null){
             typeService.updateType(type);
             return Result.ok().data("message","over");
         }
         else{ return Result.error().data("message","名儿重了 换个");}
    }


}
