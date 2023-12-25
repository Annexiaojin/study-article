package com.article.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String name;
    private String password;
    private String nickname;
    private String email;
    private String userPic;
    private LocalDate createTime;
    private LocalDate updateTime;
}
