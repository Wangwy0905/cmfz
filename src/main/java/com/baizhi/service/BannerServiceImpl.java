package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Dto;
import com.baizhi.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements  BannerService {
    @Autowired
    BannerMapper bannerMapper;
    public List<Banner>  queryAll(){
        List<Banner> list=bannerMapper.selectAll();
        return list;
    }

    @Override
    public Dto queryDto(int rows, int page) {
        Dto dto=new Dto();
        dto.setTotal(bannerMapper.queryNum());
        dto.setRows(bannerMapper.queryAllByPage(rows,page));
        return dto;
    }

    @Override
    public void insert(Banner banner) {
        bannerMapper.insert(banner);
    }

    @Override
    public void delete2(Integer id) {
        bannerMapper.delete2(id);
    }

    @Override
    public void updateBanner(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

}
