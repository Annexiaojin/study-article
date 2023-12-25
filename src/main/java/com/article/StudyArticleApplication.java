package com.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*不自动配置数据库连接*/

@SpringBootApplication/*自动扫描启动类所在的包及其子包*/
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class StudyArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyArticleApplication.class, args);
        System.out.println("启动成功！！！");
    }

}
