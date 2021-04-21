package com.zjh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagService {

    /**
     * 标签分页查询
     * @param page
     * @return
     */
    IPage<Tag> pageTags(Page<?> page);

    /**
     * 查询全部标签
     * @return
     */
    List<Tag> queryAllTag();

    /**
     * 保存标签
     * @param tag
     * @return
     */
    boolean saveTag(Tag tag);

    /**
     * 根据id删除标签
     * @param id
     * @return
     */
    boolean deleteTagById(@Param("id") Long id);

    /**
     * 修改更新 标签
     * @param tag
     * @return
     */
    boolean updateTag(Tag tag);

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    Tag queryTagById(@Param("id") Long id);

    //根据 字符串 1，2，3 查询 标签对象
    List<Tag> queryTagByIds(String ids,String title);

    //根据id 查询标签集合
    List<Tag> queryTagsById(Long id);

    //根据 标签 的id 查询博客数量
    int queryBlogCountById(Long id);



}
