
package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.User;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ArticleService;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("firstPage")
public class FirstPageController {
    @Autowired
    BannerService bannerService;
    @Autowired
    ArticleService articleService;
    @Autowired
    AlbumService albumService;

    @RequestMapping("queryFirstPage")
    public  Object queryFirstPage(String uid, String type, String sub_type, HttpSession session){
        User user=(User) session.getAttribute("user1");

        if (uid == null || type == null) {
            return new Error("参数不能为空");
        } else {
            if (type.equals("all")) {
                Map<String, Object> map = new HashMap<>();
                map.put("banner", bannerService.queryAll());
                map.put("album", albumService.queryAll());
                map.put("article", articleService.queryAllArticle());
                return map;
            } else if (type.equals("wen")) {
                Map<String, Object> map = new HashMap<>();
                map.put("album", albumService.queryAll());
                return map;
            } else {
                if (sub_type != null) {

                    if (sub_type.equals("ssyj")) {
                        Map<String, Object> map = new HashMap<>();

                        Integer guruId=user.getGuruId();
                        map.put("album",articleService.queryByGuruId(guruId));
                        return map;
                    } else {
                        Map<String, Object> map = new HashMap<>();
                        Integer guruId=user.getGuruId();
                        map.put("album",articleService.queryByNo(guruId));
                        return map;
                    }

                }else {
                    return new Error("思的类型不能为空");
                }
            }
        }
    }
}


