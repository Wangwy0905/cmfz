package com.baizhi.service;

import com.baizhi.entity.Album;

import com.baizhi.entity.AlbumDto;

import com.baizhi.entity.Dto;


import java.util.List;


public interface AlbumService {
    List<Album> queryAll();
    Album queryOneAlbum(Integer id);
    void insertAlbum(Album album);

    AlbumDto queryAlbumDto(int rows, int page);
    Object querDto(Integer uid, Integer id);

}
