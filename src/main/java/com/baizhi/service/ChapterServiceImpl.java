package com.baizhi.service;

import com.baizhi.entity.Chapter;
import com.baizhi.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Action;

@Service
@Transactional
public class ChapterServiceImpl implements  ChapterService {
    @Autowired
    ChapterMapper chapterMapper;
     public void insertChapter(Chapter chapter){
         chapterMapper.insert(chapter);
     }
}
