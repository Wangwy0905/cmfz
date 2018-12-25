package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.AlbumDto;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumController {

    @Autowired
    AlbumService albumService;
    @RequestMapping("queryAll")
    public List<Album> queryAll(){
        List<Album> albums = albumService.queryAll();
        return albums;
    }

    @RequestMapping("queryAlbumDto")
    public AlbumDto queryAlbumDto (int rows, int page){
        AlbumDto albumdto=albumService.queryAlbumDto(rows,page);

        return albumdto;
    }

    @RequestMapping("queryOneAlbum")
    public Album queryOneAlbum(Integer id){
        Album album= albumService.queryOneAlbum(id);
        System.out.println(id);
        System.out.println(album+"========");
        return album;
    }

    @RequestMapping("insertAlbum")
    public void insertAlbum(Album album, MultipartFile file, HttpSession session) throws IOException {

        ServletContext ctx=session.getServletContext();
        String realpath=ctx.getRealPath("audioCollection");
        String newFile=file.getOriginalFilename();
        File upFile=new File(realpath+"/"+newFile);

        file.transferTo(upFile);
        String filePath=newFile;
        album.setCoverImg(filePath);
        album.setPubDate(new Date());

        albumService.insertAlbum(album);
    }



}
