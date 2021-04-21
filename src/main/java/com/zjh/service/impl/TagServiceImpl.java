package com.zjh.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.mapper.BlogMapper;
import com.zjh.mapper.TagMapper;
import com.zjh.pojo.Blog;
import com.zjh.pojo.Tag;
import com.zjh.service.BlogService;
import com.zjh.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private BlogMapper blogMapper;
    @Override
    public IPage<Tag> pageTags(Page<?> page) {
        return tagMapper.pageTags(page);
    }

    @Override
    public List<Tag> queryAllTag() {
        return tagMapper.queryAllTag();
    }

    @Override
    public boolean saveTag(Tag tag) {
        return tagMapper.saveTag(tag);
    }

    @Override
    public boolean deleteTagById(Long id) {
        return tagMapper.deleteTagById(id);
    }

    @Override
    public boolean updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public Tag queryTagById(Long id) {
        return tagMapper.queryTagById(id);
    }

    @Override
    public List<Tag> queryTagByIds(String ids,String title) {

        List<Tag> tags = new ArrayList<>();

        if (ids!=null&&!ids.equals("")) {
            Blog blog = blogMapper.queryBlogByTitle(title);
            List<String> strings = Arrays.asList(ids.split(","));
            for (String string : strings) {
                System.out.println(string);
                Tag tag = tagMapper.queryTagById(Long.valueOf(string));
                tags.add(tag);
                blogMapper.saveTagByBlogId(blog.getId(),Long.valueOf(string));

            }
        }

        return tags;
    }

    @Override
    public List<Tag> queryTagsById(Long id) {
        Long l = 22l;
        tagMapper.queryTagsById(l);
        return null;
    }

    @Override
    public int queryBlogCountById(Long id) {
        return tagMapper.queryBlogCountById(id);
    }
}
