package com.zjh.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.pojo.Type;
import com.zjh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/types")
public class TypeController {

    @Autowired
    private TypeService typeService;


    /**
     * 分页查询 分类
     * @param currentPage
     * @param model
     * @param session
     * @return
     */
    @RequestMapping()
    public String toType(Integer currentPage, Model model, HttpSession session){

        if (currentPage==null){
            currentPage=1;
        }

        model.addAttribute("types",typeService.pageTypes(new Page<>(currentPage, 5)));
        session.setAttribute("menu","2");
        return "admin/types";

    }

    /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping("/toTypeAdd")
    public String toTypeAdd(){
        return "admin/types-input";
    }

    /**
     * 分类的添加
     * @param type
     * @return
     */
    @RequestMapping("/typeAdd")
    public String typeAdd(Type type){

        boolean b = typeService.saveType(type);
        System.out.println(b);
        return "redirect:/admin/types";
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @RequestMapping("/typeDelete")
    public String typeDelete(Long id){
        boolean b = typeService.deleteTypeById(id);
        if(b){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        return "redirect:/admin/types";
    }

    /**
     * 跳转到分类的保存页面
     * @param model
     * @return
     */
    @RequestMapping("/toTypeUpdate")
    public String typeUpdate(Long id,Model model){
        model.addAttribute("type",typeService.queryTypeById(id));
        return "admin/types-input";
    }

    /**
     * 分类的更新
     * @param type
     * @return
     */
    @RequestMapping("/typeUpdate")
    public String typeUpdate(Type type){
        System.out.println(type);
        typeService.updateType(type);
        return "redirect:/admin/types";
    }


}
