package com.zjh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.pojo.Type;
import com.zjh.pojo.vo.LoginUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeService {
    /**
     * 分类分页查询
     * @param page
     * @return
     */
    IPage<Type> pageTypes(Page<?> page);

    /**
     * 查询全部分类
     * @return
     */
    List<Type> queryAllType();

    /**
     * 保存分类
     * @param type
     * @return
     */
    boolean saveType(Type type);

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    boolean deleteTypeById(Long id);

    /**
     * 修改更新 分类
     * @param type
     * @return
     */
    boolean updateType(Type type);

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    Type queryTypeById(Long id);

    //根据 分类id 查询 博客的数量
    int queryBlogCountById(Long id);



}
