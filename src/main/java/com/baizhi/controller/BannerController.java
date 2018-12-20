package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Dto;
import com.baizhi.service.BannerService;
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
@RequestMapping("banner")
public class BannerController {
    @Autowired
    BannerService bannerService;
    @RequestMapping("queryAll")
    public List<Banner> queryAll(){
        List<Banner> list = bannerService.queryAll();
        return  list;
    }
    @RequestMapping("queryDto")
    public Dto queryDto (int rows,int page){
        Dto dto=bannerService.queryDto(rows,page);

        return dto;
    }
    @RequestMapping("insert")
    public void insert(Banner banner, MultipartFile file, HttpSession session) throws IOException {
        ServletContext ctx=session.getServletContext();
        String realpath=ctx.getRealPath("shouye");
        String newFile=file.getOriginalFilename();
        File upFile=new File(realpath+"/"+newFile);

        file.transferTo(upFile);
        String filePath="/shouye/"+newFile;
        banner.setImgPath(filePath);
        banner.setPubDate(new Date());

        bannerService.insert(banner);

    }
    @RequestMapping("delete2")
    public void delete2(Integer id){
        bannerService.delete2(id);
    }
    @RequestMapping("updateBanner")
    public void updateBanner(Banner banner){
        System.out.println(banner);
        bannerService.updateBanner(banner);
    }
}
