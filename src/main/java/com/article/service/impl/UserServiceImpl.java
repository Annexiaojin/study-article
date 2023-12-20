package com.article.service.impl;

import com.article.dao.UserDao;
import com.article.entity.User;
import com.article.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
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
}
