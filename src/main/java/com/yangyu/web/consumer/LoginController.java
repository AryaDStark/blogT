package com.yangyu.web.consumer;

import com.yangyu.po.Consumer;
import com.yangyu.po.User;
import com.yangyu.service.ConsumerService;
import com.yangyu.service.UserService;
import com.yangyu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    UserService userService;

    @Autowired
    private HttpServletRequest request;

//    @Autowired
//     private HttpServletResponse response;

    // 登陆
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam String username,@RequestParam String password,HttpSession session){
       //是否为管理员登陆
        User user = userService.checkUser(username,password);
        if (user!=null){
            session.setAttribute("adminUser",user);
//            Cookie cookie =new Cookie("adminUsername",username);
//               response .addCookie(cookie);
            return Result.ok().data("ok",0).data("管理员对象信息",user);
        }
        else {
            //不是管理员  是否为普通用户
              Consumer consumer =  consumerService.checkConsumer(username,password);
              if (consumer!=null){
                  session.setAttribute("普通用户",consumer);
//                  Cookie cookie =new Cookie("username",username);
//                  response .addCookie(cookie);
                  return Result.ok().data("ok",1).data("consumer",consumer);
              }
              else {
                  return Result.error().data("账号密码错误","请确认");
              }
        }
    }


    //登出
    @GetMapping("/logout")
    @ResponseBody
    public Result logout(HttpSession session){
        if (session.getAttribute("adminUser")!=null) {session.removeAttribute("adminUser");}
        if (session.getAttribute("consumer")!=null){session.removeAttribute("consumer");}
        return Result.ok().data("ok","over");
    }

    //普通用户注册
    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody Consumer consumer, HttpSession session){
//        if (consumer==null){ return Result.error().data("message","妹拿到consumer啊");}
        Consumer consumer1=consumerService.findByName(consumer.getConsumername());
        if (consumer1!=null){ return  Result.error().data("不行","username重了");}
        else {
            consumerService.save(consumer);
            session.setAttribute("consumer",consumer);
            return  Result.ok().data("O了","ok").data("consumer",consumer);
        }
    }

    //确认 是否登陆 的方法
    @GetMapping("/status")
    @ResponseBody
    public Result status(HttpSession session){
        if (session.getAttribute("adminUser")!=null){

            return Result.ok().data("messageOne","管理员已登陆").data("管理员",session.getAttribute("adminUser"));  }
        else {
            if (session.getAttribute("consumer")!=null){
               return Result.ok().data("messageTwo","普通用户已登录").data("普通用户",session.getAttribute("consumer"));
            }
            return Result.error().data("messageThree","无人在线");
        }

    }

}
