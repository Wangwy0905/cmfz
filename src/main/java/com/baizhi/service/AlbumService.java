package com.baizhi.service;

import com.baizhi.entity.Album;

import com.baizhi.entity.AlbumDto;
import com.baizhi.entity.Dto;


import java.util.List;


public interface AlbumService {
    public List<Album> queryAll();
    public Album queryOneAlbum(Integer id);
    public void insertAlbum(Album album);

    public AlbumDto queryAlbumDto(int rows, int page);
}
