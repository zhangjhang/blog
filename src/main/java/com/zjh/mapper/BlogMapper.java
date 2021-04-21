package com.zjh.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjh.pojo.Blog;
import com.zjh.pojo.Tag;
import com.zjh.pojo.Type;
import com.zjh.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

import java.util.List;

@Repository
public interface BlogMapper {

    //博客分类
    IPage<Blog> pageBlog(Page<?> page);

    //查询全部博客
    List<Blog> queryAllBlog();

    //博客的添加 保存
    boolean saveBlog(Blog blog);

    //根据id删除博客
    boolean deleteBlogById(Long id);

    //根据id查询博客
    Blog queryBlogById(Long id);

    //根据 title 查询博客
    Blog queryBlogByTitle(@Param("title") String title);

    //根据博客 id 保存 标签id
    boolean saveTagByBlogId(Long blogId,Long tagId);


    //修改博客
    boolean updateBlog(Blog blog);

    //查询 状态为 发布的 并且推荐 的博客
    @Select("select * from t_blog where published = true and recommend = true ")
    List<Blog> queryPublishedTrue();

    //根据 博客的id 查询用户
    @Select("select * from t_blog b,t_user u where b.user_id = u.id and b.id = #{id}")
    User queryUserById(Long id);

    //根据 博客 id查询 分类
    @Select("select t.id,t.name from t_blog b,t_type t where b.type_id = t.id and b.id = #{id}")
    Type queryTagById(Long id);


}
