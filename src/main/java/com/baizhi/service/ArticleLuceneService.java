package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.List;

public interface ArticleLuceneService {
    List<Article> searcherIndex(String param);
}
