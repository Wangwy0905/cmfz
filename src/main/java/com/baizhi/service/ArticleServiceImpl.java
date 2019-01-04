package com.baizhi.service;


import com.baizhi.entity.Article;
import com.baizhi.mapper.ArticleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements  ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserService userService;

    public List<Article> queryAllArticle() {

        return articleMapper.queryAllArticle();
    }

    @Override
    public List<Article> queryByGuruId(Integer guruId) {
        Article article=new Article();
        article.setGuruId(guruId);
        List<Article> select = articleMapper.select(article);
        return  select;
    }

    public List<Article> queryByNo(Integer guruId){
       List<Article> list= articleMapper.queryByNo(guruId);
       return list;
    }

}
