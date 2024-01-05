package com.article.controller;

import com.article.entity.Article;
import com.article.entity.PageBean;
import com.article.entity.Result;
import com.article.service.ArticleService;
import com.article.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    /*
    * 新增文章
    * */
    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }
    /*
    * 分页查询文章列表
    * */
    @GetMapping
    public Result<PageBean<Article>> list(Integer pageNum,
                                          Integer pageSize,
                                          @RequestParam(required = false) Integer categoryId,
                                          @RequestParam(required = false) String state){
        PageBean<Article> list = articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(list);
    }
}
