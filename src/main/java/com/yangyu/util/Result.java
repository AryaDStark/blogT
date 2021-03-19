package com.yangyu.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//统一返回结果类
public class Result {

    private  Boolean success;
    private Integer code;
    private  String message;
    private Map<String,Object>data=new HashMap<String, Object>();

    //私有构造方法
    private Result(){}

    //成功静态方法
    public static Result ok(){
        Result result=new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("成功");
        return result;
    }



    //失败静态方法
    public static Result error(){
        Result result=new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.ERRPR);
        result.setMessage("失败");
        return result;
    }
    //*********************    链 子  链式编程**********************
    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message (String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return  this;
    }
    public Result data(String key, Object value){
        this.data.put(key,value);
        return this;
    }
    public Result data(Map<String,Object> map){
        this.setData(map);
        return this;
    }


    //************************     @Data     ******************
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
