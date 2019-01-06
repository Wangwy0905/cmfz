package com.baizhi.mapper;

import com.baizhi.conf.LuceneUtil;
import com.baizhi.entity.Product;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;


import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.util.Version;
import org.apache.poi.ss.formula.functions.T;
import org.wltea.analyzer.lucene.IKAnalyzer;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

public class LuceneMapper {
    //增加
    public void createIndex(Product product) {
        IndexWriter indexWriter= LuceneUtil.getIndexWriter();

        Document docFromPro = getDocFromPro(product);
       // System.out.println(docFromPro+"==========");
        try {
            indexWriter.addDocument(docFromPro);
            LuceneUtil.commit(indexWriter);
        } catch (IOException e) {
            e.printStackTrace();
            LuceneUtil.rollback(indexWriter);
        }
    }


    public   Highlighter  queryqq(String params){
        //Query query=new TermQuery(new Term("desc",params));
        String[] strs={"name","desc","address"};
        MultiFieldQueryParser multiFieldQueryParser=new MultiFieldQueryParser(Version.LUCENE_44,strs, new IKAnalyzer());
        Query query= null;
        try {
            query = multiFieldQueryParser.parse(params);
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }
        Formatter formatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
        Scorer scorer=new QueryScorer(query);
        Highlighter highlighter = new Highlighter(formatter, scorer);
        return highlighter;
        }


    public List<Product> searcherIndex(String params){

        IndexSearcher indexSearcher=LuceneUtil.getIndexSearcher();
        List<Product> list=null;
        try{

            TopDocs topDocs=indexSearcher.search(new TermQuery(new Term("desc",params)),100);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            System.out.println(scoreDocs);
            list=new ArrayList<>();
            for (int i = 0; i < scoreDocs.length; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                int doc=scoreDoc.doc;
                Document document=indexSearcher.doc(doc);
                Product product=getProFromDoc(document,params);
                list.add(product);
            }
            
        }catch(Exception e){
                e.printStackTrace();
        }
        return  list;
    }


    public Document getDocFromPro(Product product) {
        Document document = new Document();

        document.add(new StringField("id", product.getId(), Field.Store.YES));
        document.add(new TextField("name", product.getName(), Field.Store.YES));
        document.add(new DoubleField("price", product.getPrice(), Field.Store.YES));
        document.add(new TextField("desc", product.getDesc(), Field.Store.YES));
        document.add(new StringField("url", product.getUrl(), Field.Store.YES));
        document.add(new StringField("status", product.getStatus(), Field.Store.YES));
        SimpleDateFormat sdf=new SimpleDateFormat();
        document.add(new StringField("pubDate",sdf.format( product.getPubDate()) , Field.Store.YES));
        document.add(new StringField("address", product.getAddress(), Field.Store.YES));

        return document;
    }

    public Product getProFromDoc(Document document,String params) throws ParseException {
        Product product = new Product();
        Highlighter highlighter=queryqq(params);
        String bestFragment=null;
        String bestFragment1=null;
        try {
            bestFragment1=highlighter.getBestFragment(new IKAnalyzer(), "name", document.get("name"));
            bestFragment = highlighter.getBestFragment(new IKAnalyzer(), "desc", document.get("desc"));
            System.out.println("11111"+bestFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setId(document.get("id"));
        if(document.get("name").contains(params)){
            product.setName(bestFragment1 );
        }else{
            product.setName(document.get("name"));
        }
        product.setPrice(Double.valueOf(document.get("price")));
        if(document.get("desc").contains(params)){
            product.setDesc(bestFragment);
        }else{
            product.setDesc(document.get("desc"));
        }
        product.setUrl(document.get("url"));
        product.setStatus(document.get("status"));
        SimpleDateFormat format=new SimpleDateFormat();

        product.setPubDate(format.parse(document.get("pubDate")));
        product.setAddress(document.get("address"));
        return product;
    }
}
