package com.baizhi;


import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.service.AdminService;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {

    @Autowired
    AdminService adminService;
    @Autowired
    BannerService bannerService;
    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    AlbumMapper albumMapper;

   @Test
    public void contextLoads1() {
        System.out.println(bannerMapper.queryAllByPage(1,3));
    }



    @Test

   public void test() {
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }
    }
    @Test
    public void test2(){
        List<Album> albumList = albumMapper.queryAll();
        System.out.println(albumList+"111111111111");
    }

}


