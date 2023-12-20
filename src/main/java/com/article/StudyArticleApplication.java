package com.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan(basePackages = "com.article.dao")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class StudyArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyArticleApplication.class, args);
        System.out.println("启动成功！！！");
    }

}
