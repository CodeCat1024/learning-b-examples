package com.zjt.demo.mapper;

import com.zjt.demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    public ArticleInfo getArticleById(@Param("id") Integer id);
}