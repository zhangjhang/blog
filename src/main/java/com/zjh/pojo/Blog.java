package com.zjh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Long id;

    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;

    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;

    private Date createTime;
    private Date updateTime;

    private User user;
    private Type type;
    private List<Tag> tags = new ArrayList<>();

    private String ids;
}
