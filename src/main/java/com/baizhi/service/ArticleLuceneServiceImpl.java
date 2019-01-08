package com.baizhi.service;

import com.baizhi.entity.Article;
import com.baizhi.mapper.ArticleLuceneMapper;
import org.apache.lucene.search.highlight.Highlighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ArticleLuceneServiceImpl implements  ArticleLuceneService{
    @Autowired
    ArticleLuceneMapper articleLuceneMapper;

    @Override
    public List<Article> searcherIndex(String param) {
        List<Article> list=articleLuceneMapper.searcherIndex(param);
        return  list;
    }
}
