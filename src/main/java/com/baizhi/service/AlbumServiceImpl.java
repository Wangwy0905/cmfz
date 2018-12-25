package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.AlbumDto;
import com.baizhi.entity.Dto;
import com.baizhi.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumMapper albumMapper;
    public List<Album> queryAll(){
        List<Album> albums = albumMapper.queryAll();
        return albums;
    }
    @Override
    public AlbumDto queryAlbumDto(int rows, int page) {
        AlbumDto albumDto=new AlbumDto();
        albumDto.setTotal(albumMapper.queryNum());
        albumDto.setRows(albumMapper.queryAlbumByPage(rows,page));
        return albumDto;
    }

    @Override
    public Album queryOneAlbum(Integer id) {
        return albumMapper.selectByPrimaryKey(id);
    }
    public void insertAlbum(Album album){
        albumMapper.insert(album);
    }

}
