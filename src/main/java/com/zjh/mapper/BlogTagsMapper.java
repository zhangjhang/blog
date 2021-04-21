package com.zjh.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface BlogTagsMapper {
    boolean deleteBlogTagsByBlogId(Long blogId);
}
