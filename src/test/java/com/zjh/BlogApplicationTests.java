package com.zjh;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.mapper.BlogMapper;
import com.zjh.mapper.TagMapper;
import com.zjh.mapper.TypeMapper;
import com.zjh.pojo.Blog;
import com.zjh.pojo.BlogTags;
import com.zjh.pojo.Tag;
import com.zjh.pojo.Type;
import com.zjh.service.BlogService;
import com.zjh.service.TypeService;
import com.zjh.utils.JwtsUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.assertj.core.condition.Join;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private BlogService blogService;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Test
    void contextLoads() {

//        List<String> array = new ArrayList();
//        array.add("1");
//        array.add("2");
//        array.add("3");
//        String join = StringUtils.join(array, ',');
//        System.out.println(join);
//
//        Blog blog = blogService.queryBlogById(22l);
//        List<Tag> tags = blog.getTags();
//        System.out.println(blog);


        Long l = 22l;
        List<Blog> blogs = tagMapper.queryTagsById(l);

        for (Blog blog : blogs) {
            System.out.println(blog.getTags());
            for (Tag tag : blog.getTags()) {
                System.out.println(tag.getId());
            }
        }
//        System.out.println(blogs);

//
//        Page<Object> objectPage = new Page<>(1, 2);

    }

    @Test
    void blogupdaste(){
        Long lo = 22l;
        Blog blog = blogService.queryBlogById(lo);
        System.out.println(blog.getTags());
        List<String> ids = new ArrayList<>();
        List<Tag> tags = blog.getTags();
        for (Tag tag : tags) {
            ids.add(String.valueOf(tag.getId()));
        }
        String join = StringUtils.join(ids, ',');
        System.out.println(join);
    }

    @Test
    void typeTest(){
//        int i = typeMapper.queryBlogCountById((long) 14);
//        System.out.println(i);
        Type type = blogMapper.queryTagById(Long.valueOf(22));
        System.out.println(type);
    }

    @Test
    void jwtTest(){
//        String token = new JwtsUtils().generateToken("123");
//        System.out.println(token);
        String token = new JwtsUtils().parserToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjMiLCJpYXQiOjE2MTg5MzQzNjd9.2i4Vrez1FtQYdN4-xkTD-m_PSqE9_qoTk-Wqo_6YxP0");
        System.out.println(token);
    }
}
