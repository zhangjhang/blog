package com.zjh.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.pojo.Tag;
import com.zjh.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 标签的分页查询
     * @param currentPage
     * @param model
     * @return
     */
    @RequestMapping
    public String pageTags(Integer currentPage, Model model){
        System.out.println("当前页："+currentPage);
        if(currentPage==null){
            currentPage=1;
        }

        model.addAttribute("tags",tagService.pageTags(new Page<>(currentPage,5)));
        return "/admin/tags";
    }

    /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping("/toTagAdd")
    public String toTagAdd(){
        return "admin/tags-input";
    }

    /**
     * 标签的添加
     * @param tag
     * @return
     */
    @RequestMapping("/tagAdd")
    public String tagAdd(Tag tag){

        boolean b = tagService.saveTag(tag);
        System.out.println(b);
        return "redirect:/admin/tags";
    }

    /**
     * 删除标签
     * @param id
     * @return
     */
    @RequestMapping("/tagDelete")
    public String tagDelete(Long id){
        boolean b = tagService.deleteTagById(id);
        if(b){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        return "redirect:/admin/tags";
    }

    /**
     * 跳转到标签的保存页面
     * @param model
     * @return
     */
    @RequestMapping("/toTagUpdate")
    public String tagUpdate(Long id,Model model){
        model.addAttribute("tag",tagService.queryTagById(id));
        return "admin/tags-input";
    }

    /**
     * 标签的更新
     * @param tag
     * @return
     */
    @RequestMapping("/tagUpdate")
    public String tagUpdate(Tag tag){
        System.out.println(tag);
        tagService.updateTag(tag);
        return "redirect:/admin/tags";
    }


}
