package com.zjh.service.impl;


import com.zjh.mapper.UserMapper;
import com.zjh.service.UserService;
import com.zjh.pojo.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public LoginUser queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
