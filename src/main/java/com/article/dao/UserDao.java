package com.article.dao;

import com.article.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> queryAll();
}
