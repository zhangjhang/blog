package com.zjh.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.pojo.Blog;
import com.zjh.pojo.Tag;
import com.zjh.pojo.Type;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper {

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

    //根据id 查询标签集合
    List<Blog> queryTagsById(Long id);

    //根据 标签 的id 查询博客数量
    int queryBlogCountById(Long id);




}
