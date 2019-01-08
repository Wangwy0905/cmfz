package com.baizhi.mapper;

import com.baizhi.conf.LuceneUtil;
import com.baizhi.entity.Article;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.apache.lucene.search.highlight.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ArticleLuceneMapper {

    //封装Highlighter
    public Highlighter query(String param){
        String[] s={"content","title"};
        MultiFieldQueryParser multiFieldQueryParser=new MultiFieldQueryParser(Version.LUCENE_44,s, new IKAnalyzer());
        Query query= null;
        try {

            query =  multiFieldQueryParser.parse(param);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        Formatter formatter = new SimpleHTMLFormatter("<font color='blue'>", "</font>");
        Scorer scorer=new QueryScorer(query);
        org.apache.lucene.search.highlight.Highlighter highlighter = new org.apache.lucene.search.highlight.Highlighter(formatter, scorer);
        return highlighter;
    }

    //添加
    public  void  importIndex(Article article){
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        Document document=getDocFromPro(article);
        System.out.println("======"+document);
        try {
            indexWriter.addDocument(document);
            LuceneUtil.commit(indexWriter);
        } catch (Exception e) {
            e.printStackTrace();
            LuceneUtil.rollback(indexWriter);
        }
    }



    public Document getDocFromPro(Article article) {
        Document document = new Document();

        document.add(new StringField("id",String.valueOf(article.getId()), Field.Store.YES));
        document.add(new TextField("title", article.getTitle(), Field.Store.YES));

        document.add(new TextField("content", article.getContent(), Field.Store.YES));
        document.add(new StringField("insertImg",article.getInsertImg(), Field.Store.YES));
        SimpleDateFormat sdf=new SimpleDateFormat();
        document.add(new StringField("pubDate",sdf.format( article.getPubDate()) , Field.Store.YES));
        System.out.println(document+"-----------");
        return document;
    }
    //查询
    public List<Article> searcherIndex(String param){
        System.out.println(param);
        IndexSearcher indexSearcher=LuceneUtil.getIndexSearcher();
        List<Article> list=null;
        try{
            TopDocs topDocs=indexSearcher.search(new TermQuery(new Term("content",param)),100);
            ScoreDoc[] scoreDocs =topDocs.scoreDocs;
            list=new ArrayList<>();
            for (int i = 0; i < scoreDocs.length; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                int doc=scoreDoc.doc;
                Document document=indexSearcher.doc(doc);
                Article article=getProFromDoc(document,param);
                list.add(article);
            }
            System.out.println(list);

        }catch(Exception e){
            e.printStackTrace();
        }
        return  list;

    }


    public Article getProFromDoc(Document document, String param) throws ParseException {
       Article article=new Article();
        Highlighter highlighter=query(param);
        String bestFragment=null;
        String bestFragment1=null;
        try {
            bestFragment1=highlighter.getBestFragment(new IKAnalyzer(), "title", document.get("title"));
            bestFragment = highlighter.getBestFragment(new IKAnalyzer(), "content", document.get("content"));
            //System.out.println("11111"+bestFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        article.setId(Integer.valueOf(document.get("id")));
        if(document.get("title").contains(param)){
            article.setTitle(bestFragment1 );
        }else{
            article.setTitle(document.get("title"));
        }

        if(document.get("content").contains(param)){
            article.setContent(bestFragment);
        }else{
            article.setContent(document.get("content"));
        }
        article.setInsertImg(document.get("insertImg"));

        SimpleDateFormat format=new SimpleDateFormat();
        article.setPubDate(format.parse(document.get("pubDate")));

        return article;
    }
}

