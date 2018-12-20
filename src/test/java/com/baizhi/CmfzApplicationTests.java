package com.baizhi;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.service.AdminService;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {

    @Autowired
    AdminService adminService;
    @Autowired
    BannerService bannerService;
    @Autowired
    BannerMapper bannerMapper;

   @Test
    public void contextLoads1() {
        System.out.println(bannerMapper.queryAllByPage(1,3));
    }

}

