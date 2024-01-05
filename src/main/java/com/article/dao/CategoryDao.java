package com.article.dao;

import com.article.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryDao {
    @Insert("insert into category(categoryName,categoryAlias,createUser,createTime) values " +
            "(#{categoryName} ,#{categoryAlias} ,#{createUser} ,#{createTime} )")
    void add(Category category);
    @Select("select * from category where createUser = #{userId}")
    List<Category> list(Integer userId);
    @Select("select * from category where id =#{id}")
    Category findById(Integer id);
    @Update("update category set categoryName = #{categoryName},categoryAlias = #{categoryAlias},updateTime = now() where id =#{id}")
    void update(Category category);
}
