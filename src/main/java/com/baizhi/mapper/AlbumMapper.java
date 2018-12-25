package com.baizhi.mapper;

import com.baizhi.entity.Album;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
    public List<Album> queryAll();
    public List<Album>  queryAlbumByPage(@Param(value="rows") int rows , @Param(value="page") int page);
    public Integer queryNum();


}
