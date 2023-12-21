package com.article.dao;

import com.article.entity.User;
import com.article.properties.UserProperties;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> queryAll();
    @Insert("insert into user values (#{id},#{userName})")
    void insertUser(UserProperties userProperties);
    @Select("select * from user where id = #{id}")
    User queryOne(int id);
}
