package com.zjh.controller;

import com.zjh.service.UserService;
import com.zjh.pojo.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping()
    public String toLogin(){
        return "admin/login";
    }



    //登录
    @RequestMapping("/login")
    public String login(LoginUser loginUser, RedirectAttributes redirectAttributes, HttpSession session){
        System.out.println("登录的用户信息："+loginUser);

        LoginUser user = userService.queryUserByName(loginUser.getUsername());
        System.out.println(user);
        if(user==null){
            redirectAttributes.addFlashAttribute("message","用户名不存在！！");
            return "redirect:/admin/";
        }
        if(loginUser.getPassword()!=null ){
            if(!loginUser.getPassword().equals(user.getPassword())){
                redirectAttributes.addFlashAttribute("message","密码错误！！");
                return "redirect:/admin/";
            }
        }

        user.setPassword(null);
        session.setAttribute("user",user);

        return "admin/index";
    }
}
