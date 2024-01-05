package com.article.service.impl;

import com.article.dao.CategoryDao;
import com.article.entity.Category;
import com.article.service.CategoryService;
import com.article.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public void add(Category category) {
        category.setCreateTime(LocalDateTime.now());
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId= (Integer) map.get("id");
        category.setCreateUser(userId);
        categoryDao.add(category);
    }

    @Override
    public List<Category> list() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        List<Category> list = categoryDao.list(id);
        return list;
    }

    @Override
    public Category findById(Integer id) {
        Category category = categoryDao.findById(id);
        return category;
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }
}
