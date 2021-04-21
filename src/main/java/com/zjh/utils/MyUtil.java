package com.zjh.utils;

import com.zjh.pojo.Tag;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


public class MyUtil {

    public String jihebianString(List<Tag> tags){
        List<String> ids = new ArrayList<>();
        for (Tag tag : tags) {
//            System.out.println(tag.getId());
            ids.add(String.valueOf(tag.getId()));
        }
        String join = StringUtils.join(ids, ',');
        System.out.println("+++++++++++++++++++++++"+join);
        return join;
    }
}
