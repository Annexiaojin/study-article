package com.article.config;

import com.article.utils.QCloudCosUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 腾讯云对象存储
 */
@Configuration

@Slf4j
public class QCloudCosUtilsConfig {
    @ConfigurationProperties(prefix = "sky.qcloud")
    @Bean
    public QCloudCosUtils qcloudCosUtils() {
        log.info("开始创建腾讯云存储对象");
        return new QCloudCosUtils ();
    }
}


