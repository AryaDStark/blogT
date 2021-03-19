package com.yangyu.service.Impl;

import com.yangyu.mapper.TagMapper;
import com.yangyu.po.Tag;
import com.yangyu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> findTopTags() {
        return tagMapper.findTopTags();
    }

    @Override
    public List<Tag> findAllTags(int pageNum) {
        int n1=pageNum*3+1;
        return tagMapper.findAllTags(n1);
    }

    @Override
    public void saveTag(String name) {
        tagMapper.saveTag(name);
    }

    @Override
    public void deleteTag(Long id) {
        tagMapper.deleteTag(id);
    }

    @Override
    public Tag getById(Long id) {
        return tagMapper.getById(id);
    }

    @Override
    public Tag getByName(String name) {
        return tagMapper.getByName(name);
    }

    @Override
    public void updateTag(Tag tag) {
           tagMapper.updateTag(tag);
    }
}
