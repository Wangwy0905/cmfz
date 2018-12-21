package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    ChapterService chapterService;
    @RequestMapping("insertChapter")
    public void insertChapter(Chapter chapter, MultipartFile file, HttpSession session,Integer albumId) throws IOException {
        System.out.println(chapter+"=======");

        DecimalFormat df   = new DecimalFormat("#0.00");

        ServletContext ctx=session.getServletContext();
        String realpath=ctx.getRealPath("video");
        System.out.println(file.getSize()+"----------");
        chapter.setSize((df.format(file.getSize()/1024.0/1024.0))+"MB");
        String newFile=file.getOriginalFilename();
        File upFile=new File(realpath+"/"+newFile);
        file.transferTo(upFile);
        String filePath="/video/"+newFile;
        String uuid = UUID.randomUUID().toString();
        String realuuid=uuid.replaceAll("-", "");
        chapter.setId(realuuid);
        chapter.setAlbumId(albumId);
        chapter.setUrl(filePath);

        chapter.setUploadDate(new Date());

        chapterService.insertChapter(chapter);

    }
}
