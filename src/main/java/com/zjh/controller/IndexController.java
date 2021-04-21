package com.zjh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.pojo.Blog;
import com.zjh.pojo.Tag;
import com.zjh.pojo.Type;
import com.zjh.service.BlogService;
import com.zjh.service.TagService;
import com.zjh.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @RequestMapping({"/index","/"})
    public String index(Model model){

//        List<Type> types = typeService.queryAllType();
        List<Type> types = typeService.pageTypes(new Page<>(1, 6)).getRecords();

        for (Type type : types) {
            type.setBlogCount(typeService.queryBlogCountById(type.getId()));
        }
        System.out.println("显示，分类："+types);

        List<Tag> tags = tagService.pageTags(new Page<>(1, 10)).getRecords();
        for (Tag tag : tags) {
            tag.setBlogCount(tagService.queryBlogCountById(tag.getId()));

        }

        List<Blog> recommendBlogs = blogService.queryPublishedTrue();
        System.out.println(recommendBlogs);

        IPage<Blog> blogs = blogService.pageBlog(new Page<>(1, 10));
        for (Blog blog : blogs.getRecords()) {



            blog.setType(blogService.queryTagById(blog.getId()));
            blog.setUser(blogService.queryUserById(blog.getId()));
        }

        model.addAttribute("blogs",blogs);
        model.addAttribute("recommendBlogs",recommendBlogs);
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);

        return "index";
    }

    @RequestMapping("/blog")
    public String getBlog(Model model,Long id){

        model.addAttribute("blog",blogService.getAndConvert(id));
        return "/blog";
    }


}
