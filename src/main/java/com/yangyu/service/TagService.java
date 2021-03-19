package com.yangyu.service;

import com.yangyu.po.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findTopTags();
    List<Tag> findAllTags(int pageNum);
    void      saveTag(String name);
    void      deleteTag(Long id);
    Tag       getById(Long id);
    Tag       getByName(String name);
    void      updateTag(Tag tag);
}
