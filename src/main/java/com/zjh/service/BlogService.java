package com.zjh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.pojo.Blog;
import com.zjh.pojo.Tag;
import com.zjh.pojo.Type;
import com.zjh.pojo.User;

import java.util.List;

public interface BlogService {
    //博客分类
    IPage<Blog> pageBlog(Page<?> page);

    //查询全部博客
    List<Blog> queryAllBlog();

    //博客的添加 保存
    boolean saveBlog(Blog blog);

    //根据id删除博客
    boolean deleteBlogById(Long id);

    //根据id查询博客
    Blog queryBlogById(Long id);

    //修改博客
    boolean updateBlog(Blog blog);

    //查询 状态为 发布的 并且推荐 的博客
    List<Blog> queryPublishedTrue();

    //根据 博客的id 查询用户
    User queryUserById(Long id);

    //转换
    Blog getAndConvert(Long id);

    //根据 博客 id查询 分类
    Type queryTagById(Long id);
}
