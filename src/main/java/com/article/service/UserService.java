package com.article.service;

import com.article.entity.User;
import com.article.properties.UserProperties;

import java.util.List;

public interface UserService {
    List<User> queryAll();

    void insertUser(UserProperties userProperties);

    User queryOne(User user);
    User queryByName(User user);

    void register(User user);
}
