package com.zjh.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zjh.pojo.Blog;
import com.zjh.pojo.Tag;
import com.zjh.pojo.User;
import com.zjh.service.BlogService;
import com.zjh.service.TagService;
import com.zjh.service.TypeService;
import com.zjh.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;
    @Autowired
    private TypeService typeService;

    //博客的分页显示
    @RequestMapping()
    public String pageBlog(Integer currentPage, Model model){
        if(currentPage==null){
            currentPage=1;
        }
        System.out.println(blogService.pageBlog(new Page<>(currentPage, 5)).getRecords());
        model.addAttribute("blogs",blogService.pageBlog(new Page<>(currentPage,5)));
        return "admin/blogs";
    }

    //跳转到添加博客页面
    @RequestMapping("/toBlogAdd")
    public String toBlogAdd(Model model){
        model.addAttribute("types",typeService.queryAllType());
        model.addAttribute("tags",tagService.queryAllTag());
        return "admin/blogs-input";
    }

    //博客的添加
    @RequestMapping("/blogAdd")
    public String BlogAdd(Blog blog, HttpSession session){



//        System.out.println("ids:"+ids);
//        Object user = session.getAttribute("user");
        blog.setUser((User) session.getAttribute("user"));
//        if(ids!=null&&!ids.equals("")){

//        }


        System.out.println(blog);
        System.out.println(blog.getType());
        //保存博客
        boolean b = blogService.saveBlog(blog);
//        blog.setTags(tagService.queryTagByIds(blog.getIds(),blog.getTitle()));
        //保存博客标签 关系
        tagService.queryTagByIds(blog.getIds(),blog.getTitle());

        return "redirect:/admin/blogs";
    }

    //删除博客
    @RequestMapping("/blogDelete")
    public String BlogDelete(Long id){
        System.out.println(id);
        blogService.deleteBlogById(id);
        return "redirect:/admin/blogs";
    }

    //跳转到修改更新博客页面
    @RequestMapping("/toBlogUpdate")
    public String toBlogUpdate(Model model,Long id){
        System.out.println(id);
        Blog blog = blogService.queryBlogById(id);

        List<Tag> tags = blog.getTags();
        String ids = new MyUtil().jihebianString(tags);



        System.out.println("--------------------------"+blog.getTags());
//        blog.setIds(ids);
//        System.out.println(blog.getTags());
//        blog.setType(typeService.queryTypeById(blog.getType().getId()));
//        System.out.println(blog);
//        tagService.queryTagById();

//        List<Tag> tags = tagService.queryTagsById(id);
//        for (Tag tag : tags) {
//            System.out.println(tag);
//        }
//        System.out.println("tags"+tags);
//        blog.setTags(tags);
        System.out.println("**************************"+blog.getIds());
        model.addAttribute("ides",ids);
        model.addAttribute("upTypes",typeService.queryAllType());
        model.addAttribute("upTags",tagService.queryAllTag());
        model.addAttribute("upBlog",blogService.queryBlogById(id));
        return "admin/blogs-input";
    }


    //博客的修改
    @RequestMapping("/blogUpdate")
    public String BlogUpdate(Blog blog,HttpSession session){
        System.out.println(blog);



        blog.setUser((User) session.getAttribute("user"));



        System.out.println(blog);
        System.out.println(blog.getType());
        //更新保存博客
        boolean b = blogService.updateBlog(blog);

        //保存博客标签 关系
//        tagService.queryTagByIds(blog.getIds(),blog.getTitle());


        return "redirect:/admin/blogs";
    }

}
