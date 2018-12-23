package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    ChapterService chapterService;
    @RequestMapping("insertChapter")
    public void insertChapter(Chapter chapter, MultipartFile file, HttpSession session,Integer albumId) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        //System.out.println(chapter+"=======");
        //数字格式转换（保留小数前两位）
        DecimalFormat df   = new DecimalFormat("#0.00");

        ServletContext ctx=session.getServletContext();
        String realpath=ctx.getRealPath("video");
        //System.out.println(file.getSize()+"----------");
        //获取视频文件的大小
        chapter.setSize((df.format(file.getSize()/1024.0/1024.0))+"MB");


        String newFile=file.getOriginalFilename();
        File upFile=new File(realpath+"/"+newFile);
        //获取MP3文件的时长
        MP3File mp3File= (MP3File) AudioFileIO.read(upFile);
        MP3AudioHeader mp3AudioHeader=mp3File.getMP3AudioHeader();
        String Mp3Length=String.valueOf(mp3AudioHeader.getTrackLength());


        file.transferTo(upFile);
        String filePath=newFile;
        String uuid = UUID.randomUUID().toString();
        String realuuid=uuid.replaceAll("-", "");
        chapter.setId(realuuid);
        chapter.setAlbumId(albumId);
        chapter.setUrl(filePath);
        chapter.setDuration(Mp3Length);

        chapter.setUploadDate(new Date());

        chapterService.insertChapter(chapter);

    }
    @RequestMapping("downLoad")
    public void downLoad(String name, HttpServletResponse response,HttpSession session) throws IOException {
            ServletContext ctx=session.getServletContext();
            String realPath=ctx.getRealPath("video");
             // String path=realPath.replaceAll("\\video","");

            File sFile=new File(realPath+"/"+name);
            byte[] bs= FileCopyUtils.copyToByteArray(sFile);

            //设置响应头
            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(name,"utf-8"));
            //获取输出流  输出文件内容
            ServletOutputStream out=null;
            try{
                out=response.getOutputStream();
                out.write(bs);
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                if (out!=null) out.flush();
                if(out!=null) out.close();
            }


    }
}
