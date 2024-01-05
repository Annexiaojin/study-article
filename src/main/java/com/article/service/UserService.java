package com.article.service;

import com.article.entity.User;
import com.article.properties.UserProperties;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> queryAll();

    void insertUser(UserProperties userProperties);

    User queryOne(User user);
    User queryByName(User user);

    void register(User user);

    void update(User user);

    void updateAvator(String url);

    void updatePwd(String newPwd);
}
