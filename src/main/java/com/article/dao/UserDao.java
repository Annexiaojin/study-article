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
    @Select("select * from user where name = #{name} and password = #{password} ")
    User queryOne(User user);
    @Select("select * from user where name = #{userName} ")
    User queryByName(String userName);
}
