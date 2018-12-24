package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
@RestController
@RequestMapping("export")
public class exportController {

    @Autowired
    AlbumMapper albumMapper;
    @RequestMapping("exportAlbum")
    public void exportAlbum(HttpSession session, HttpServletResponse response){
        List<Album> albums = albumMapper.queryAll();
        ServletContext ctx=session.getServletContext();
        for (Album album : albums) {

            String realPath=ctx.getRealPath("audioCollection");
            realPath=realPath+"/"+album.getCoverImg();
            album.setCoverImg(realPath);

        }

        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("章节信息","章节表"),Album.class,albums);
        response.setContentType("application/vnd.ms-excel");
        try {
            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode("专辑表.xls","utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        File file=new File("E:/专辑表.xls");

        try{
            workbook.write(new FileOutputStream(file));
        }catch(Exception e){
                e.printStackTrace();
        }

    }

}
