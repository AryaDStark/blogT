package com.yangyu.web.adminUser;

import com.yangyu.po.Blog;
import com.yangyu.po.Type;
import com.yangyu.po.User;
import com.yangyu.service.TypeService;
import com.yangyu.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class ManagerIndex {


    @GetMapping("/index")
    @ResponseBody
    public Result indexShow(HttpSession session){
           User user=(User)session.getAttribute("user");
           if (user==null){ return Result.error().data("message","用户名或密码错误");}
           else {
               return Result.ok().data("user",user);
           }
    }


}
