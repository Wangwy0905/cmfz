package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<Banner> {
    List<Banner>  queryAllByPage(@Param(value = "rows") int rows, @Param(value = "page") int page);
    Integer queryNum();
    void delete2(Integer id);


}
