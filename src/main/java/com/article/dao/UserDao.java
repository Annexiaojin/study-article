package com.article.dao;

import com.article.entity.User;
import com.article.properties.UserProperties;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

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
    @Insert("insert into user(name,password,create_time) values (#{name},#{password},now())")
    void register(User user);
    @Update("update user set nickname = #{nickname},email =#{email},update_time =#{updateTime} where id = #{id} ")
    void update(User user);
    @Update("update user set userpic = #{url},update_time = now() where id = #{id}")
    void updateAvator(String url, Integer id);
    @Update("update user set password = #{newPwd},update_time = now() where id =#{id}")
    void updatePwd(String newPwd, Integer id);
}
