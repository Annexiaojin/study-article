package com.article.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class User {
    @NotNull
    private Integer id;
    private String name;
    @JsonIgnore//转换为JSON格式时忽略字段
    private String password;
    @NotEmpty
    @Pattern(regexp = "^\\S{3,16}$")
    private String nickname;
    @NotEmpty
    @Email
    private String email;
    private String userPic;
    @TableField("create_time")
    private LocalDate createTime;
    @TableField("update_time")
    private LocalDate updateTime;
}
