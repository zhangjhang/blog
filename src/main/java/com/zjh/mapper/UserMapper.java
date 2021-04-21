package com.zjh.mapper;

import com.zjh.pojo.vo.LoginUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    LoginUser queryUserByName(String username);
}
