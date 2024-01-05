package com.article.service.impl;

import com.article.dao.UserDao;
import com.article.entity.Result;
import com.article.entity.User;
import com.article.properties.UserProperties;
import com.article.service.UserService;
import com.article.utils.Md5Util;
import com.article.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    @Override
    public User queryByName(User user) {
        return userDao.queryByName(user.getName());
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDate.now());
        userDao.update(user);
    }

    @Override
    public void updateAvator(String url) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userDao.updateAvator(url,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userDao.updatePwd(Md5Util.encryptToMD5(newPwd),id);
    }
}
