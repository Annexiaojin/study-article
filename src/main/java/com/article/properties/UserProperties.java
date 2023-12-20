package com.article.properties;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Setter
@Component
@ConfigurationProperties(prefix = "user")
public class UserProperties {
    private String id;
    private String userName;
}
