package com.baizhi.service;



import com.baizhi.entity.Banner;
import com.baizhi.entity.Dto;

import java.util.List;

public interface BannerService {
    public List<Banner> queryAll();
    public Dto queryDto(int rows,int page);
    public void insert(Banner banner);
    public void delete2(Integer id);
    public void updateBanner(Banner banner);
}
