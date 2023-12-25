package com.article.service.impl;

import com.article.dao.UserDao;
import com.article.entity.Result;
import com.article.entity.User;
import com.article.properties.UserProperties;
import com.article.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> queryAll() {
        List<User> users = userDao.queryAll();
        return users;
    }

    @Override
    public void insertUser(UserProperties userProperties) {
        User user = userDao.queryByName(userProperties.getUserName());
        if (user == null){
            userDao.insertUser(userProperties);
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Override
    public User queryOne(User user) {
        return userDao.queryOne(user);
    }
}
