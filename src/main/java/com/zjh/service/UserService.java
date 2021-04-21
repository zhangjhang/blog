package com.zjh.service;

import com.zjh.pojo.vo.LoginUser;

public interface UserService {
    LoginUser queryUserByName(String username);
}
