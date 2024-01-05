package com.article.service.impl;

import com.article.dao.ArticleDao;
import com.article.entity.Article;
import com.article.entity.PageBean;
import com.article.service.ArticleService;
import com.article.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService   {
    @Autowired
    private ArticleDao articleDao;
    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);
        articleDao.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        /*创建pageBean对象*/
        PageBean<Article> pageBean = new PageBean<>();
        /*调用mapper*/
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        /*开启分页查询*/
        PageHelper.startPage(pageNum,pageSize);
        List<Article> list = articleDao.list(userId,categoryId,state);
        pageBean.setTotal(list.size());
        List<Article> objects = new ArrayList<>();
        for(Article article :list){
            objects.add(article);
        }
        pageBean.setItems(objects);
        return pageBean;
    }
}
