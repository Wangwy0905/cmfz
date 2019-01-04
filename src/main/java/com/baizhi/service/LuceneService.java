package com.baizhi.service;

import com.baizhi.entity.Product;

import java.util.List;

public interface LuceneService {
    void addProAndIndex(Product product);
    List<Product> showProAndIndex(String params);
}
