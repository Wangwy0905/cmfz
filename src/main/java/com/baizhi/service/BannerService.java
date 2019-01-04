package com.baizhi.service;



import com.baizhi.entity.Banner;
import com.baizhi.entity.Dto;

import java.util.List;

public interface BannerService {
    List<Banner> queryAll();
    Dto queryDto(int rows, int page);
    void insert(Banner banner);
    void delete2(Integer id);
    void updateBanner(Banner banner);
}
