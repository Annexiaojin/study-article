package com.article;

import com.article.entity.User;
import com.article.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudyArticleApplicationTests {
    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
    }
    @Test
    public List<User> queryAll(){
        List<User> users = userService.queryAll();
        System.out.println(users);
        return users;
    }

}
