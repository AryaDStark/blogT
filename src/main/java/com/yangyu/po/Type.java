package com.yangyu.po;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

//类型
//@Entity
//@Table(name = "T_type")
public class Type {
    @Id
    @GeneratedValue
    //id

    private long id;
    //名字
    //@NotBlank(message = "分类名称不能为空")
   // @NotEmpty(message = "分类名称不能为空")---------------------------------------------+++++++++++++++++++++++++++++++++++++++

    private String name;
    //博客

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();

    public Type() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
