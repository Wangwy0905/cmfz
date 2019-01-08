package com.baizhi.controller;

import com.baizhi.entity.ArticleDto;
import com.baizhi.entity.Dto;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @RequestMapping("queryAllArticle")
    public ArticleDto queryAllActicle(){
        ArticleDto articleDto = articleService.queryDto();
        return articleDto;

    }
}
