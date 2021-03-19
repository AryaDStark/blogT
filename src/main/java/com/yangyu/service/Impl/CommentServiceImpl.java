package com.yangyu.service.Impl;

import com.yangyu.mapper.CommentMapper;
import com.yangyu.po.Comment;
import com.yangyu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentsByBlogId(Long id) {
        return commentMapper.findByBlogId(id);
    }

    @Override
    public void save(Comment comment) {
        commentMapper.save(comment);
    }
}
