package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleLuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("articleLucene")
public class ArticleLuceneController {
    @Autowired
    ArticleLuceneService articleLuceneService;
    @RequestMapping("showArticleLucene")
    public List<Article>  showArticleLucene(String param){
        List<Article> list = articleLuceneService.searcherIndex(param);
        return  list;

    }
}
