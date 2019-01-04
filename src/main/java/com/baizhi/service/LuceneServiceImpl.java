package com.baizhi.service;

import com.baizhi.entity.Product;
import com.baizhi.mapper.LuceneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LuceneServiceImpl implements  LuceneService {

    @Autowired
    LuceneMapper luceneMapper;
    @Override
    public void addProAndIndex(Product product) {
         luceneMapper.createIndex(product);
    }

    @Override
    public List<Product> showProAndIndex(String params) {
        System.out.println(params+"-----------1");
         return luceneMapper.searcherIndex(params);
    }
}
