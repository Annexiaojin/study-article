package com.article.entity;

import lombok.Data;

import java.util.List;
@Data
public class PageBean<T> {
    private long total;//总记录数
    private List<T> items;//记录数集合
}
