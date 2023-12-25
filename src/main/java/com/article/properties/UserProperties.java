package com.article.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "user")
public class UserProperties {
    /*@Value("${user.id}")   获取yml文件中的值*/
    private String id;
    private String userName;
}
