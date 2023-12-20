package com.article.service.impl;

import com.article.dao.UserDao;
import com.article.entity.User;
import com.article.properties.UserProperties;
import com.article.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<User> queryAll() {
        List<User> users = userDao.queryAll();
        return users;
    }

    @Override
    public void insertUser(UserProperties userProperties) {
        userDao.insertUser(userProperties);
    }

    @Override
    public User queryOne(int id) {
        return userDao.queryOne(id);
    }
}
