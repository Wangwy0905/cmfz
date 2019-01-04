package com.baizhi.controller;


import com.baizhi.entity.Product;
import com.baizhi.service.LuceneService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("lucene")
public class LuceneController  {
    @Autowired
    LuceneService luceneService;
    @Autowired
    FastFileStorageClient fastFileStorageClient;

    @RequestMapping("lucene")
    public void saveProAndIndex(Product product,MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

        StorePath jpg = fastFileStorageClient.uploadFile(inputStream, file.getSize(), "jpg", null);
        //System.out.println(jpg.getFullPath()+"11111111111");
        product.setId(String.valueOf(3));
        product.setUrl(jpg.getFullPath());

        luceneService.addProAndIndex(product);
    }
    @RequestMapping("showLucene")
    public List<Product> showProAndIndex(String params){
       // System.out.println(params+"-----------");
        List<Product> list=luceneService.showProAndIndex(params);
        //System.out.println(list+"------===");
        return list;
    }

}
