package com.baizhi.service;
import com.baizhi.entity.Article;
import java.util.List;


public interface ArticleService {
    List<Article> queryAllArticle();
    List<Article> queryByGuruId(Integer guruId);
    List<Article> queryByNo(Integer guruId);
}