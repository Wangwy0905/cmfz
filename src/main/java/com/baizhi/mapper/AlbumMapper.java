package com.baizhi.mapper;

import com.baizhi.entity.Album;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
    List<Album> queryAll();
    List<Album>  queryAlbumByPage(@Param(value = "rows") int rows, @Param(value = "page") int page);
    Integer queryNum();


}
