package com.zjh.pojo.vo;

import com.zjh.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser extends User {
    private Long id;
    private String username;
    private String password;

}
