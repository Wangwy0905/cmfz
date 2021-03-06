package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Album;
import com.baizhi.entity.User;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.UserMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
@RestController
@RequestMapping("export")
public class exportController {

    @Autowired
    AlbumMapper albumMapper;

    @Autowired
    UserMapper userMapper;
    @RequestMapping("exportAlbum")

    //专辑导出
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
        OutputStream out=null;
        try {
            out=response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
           workbook.write(out);
        }catch(Exception e){
                e.printStackTrace();
        }

    }

    //用户导出
    @RequestMapping("exportUser")
    public void  exportUser(HttpSession session,HttpServletResponse response)  {
        List<User> users = userMapper.selectAll();
        ServletContext ctx=session.getServletContext();
        for (User user : users) {
            user.getHeadPic();
            String realPath = ctx.getRealPath("shangshi");
            realPath=realPath+"/"+user.getHeadPic();
            user.setHeadPic(realPath);
        }
        Workbook workbook=ExcelExportUtil.exportExcel(new ExportParams("用户信息","用户表"),User.class,users);
        response.setContentType("application/vnd.ms-excel");
        try{
            response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode("用户表.xls","utf-8"));

        }catch (Exception e){
            e.printStackTrace();
        }
        File file=new File("F:/用户表.xls");
        OutputStream outputStream=null;
        try {
            outputStream=response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            workbook.write(outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
