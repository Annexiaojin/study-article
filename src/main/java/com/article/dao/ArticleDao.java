package com.article.dao;

import com.article.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleDao {
    @Insert("insert into article(title,content,coverImg,state,categoryId,createUser,createTime) values " +
            "(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime})")
    void add(Article article);
    @Select("select * from article where createUser = #{userId} and categoryId = #{categoryId} and state = #{state}")
    List<Article> list(Integer userId, Integer categoryId, String state);
}
