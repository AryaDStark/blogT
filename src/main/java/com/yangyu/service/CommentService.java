package com.yangyu.service;

import com.yangyu.po.Comment;

import java.util.List;

public interface CommentService {


    List<Comment> findCommentsByBlogId(Long id);

    void   save(Comment comment);
}
