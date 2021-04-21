package com.zjh.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.mapper.BlogMapper;
import com.zjh.mapper.BlogTagsMapper;
import com.zjh.pojo.Blog;
import com.zjh.pojo.Tag;
import com.zjh.pojo.Type;
import com.zjh.pojo.User;
import com.zjh.service.BlogService;
import com.zjh.utils.MarkdownUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BlogTagsMapper blogTagsMapper;

    @Override
    public IPage<Blog> pageBlog(Page<?> page) {
        return blogMapper.pageBlog(page);
    }

    @Override
    public List<Blog> queryAllBlog() {
        return null;
    }

    @Transactional
    @Override
    public boolean saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        return blogMapper.saveBlog(blog);
    }

    @Transactional
    @Override
    public boolean deleteBlogById(Long id) {
        blogTagsMapper.deleteBlogTagsByBlogId(id);
        return blogMapper.deleteBlogById(id);
    }

    @Transactional
    @Override
    public Blog queryBlogById(Long id) {

        System.out.println(id);
        return blogMapper.queryBlogById(id);
    }

    @Override
    public boolean updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        return blogMapper.updateBlog(blog);
    }

    @Override
    public List<Blog> queryPublishedTrue() {
        return blogMapper.queryPublishedTrue();
    }

    @Override
    public User queryUserById(Long id) {
        return blogMapper.queryUserById(id);
    }

    @Transactional
    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogMapper.queryBlogById(id);

        System.out.println(blog);
        if(blog==null){
//            throw new NotFoundException("该博客不存在！");
            System.out.println("该博客不存在！！！");
        }

        blog.setUser(blogMapper.queryUserById(id));

        Blog b = new Blog();
        BeanUtils.copyProperties(blog,b);
        String content = b.getContent();


        System.out.println("++++++++++++++++++++++++++++++++++++"+b.getUpdateTime());

        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return b;
    }

    @Override
    public Type queryTagById(Long id) {
        return blogMapper.queryTagById(id);
    }
}
