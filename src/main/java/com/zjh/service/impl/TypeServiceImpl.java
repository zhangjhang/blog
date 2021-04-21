package com.zjh.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.mapper.TypeMapper;
import com.zjh.mapper.UserMapper;
import com.zjh.pojo.Type;
import com.zjh.pojo.vo.LoginUser;
import com.zjh.service.TypeService;
import com.zjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public IPage<Type> pageTypes(Page<?> page) {
        return typeMapper.pageTypes(page);
    }

    @Override
    public List<Type> queryAllType() {
        return typeMapper.queryAllType();
    }

    @Override
    public boolean saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Override
    public boolean deleteTypeById(Long id) {
        return typeMapper.deleteTypeById(id);
    }

    @Override
    public boolean updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public Type queryTypeById(Long id) {
        return typeMapper.queryTypeById(id);
    }

    @Override
    public int queryBlogCountById(Long id) {
        return typeMapper.queryBlogCountById(id);
    }
}
