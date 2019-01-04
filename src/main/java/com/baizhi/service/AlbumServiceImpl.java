package com.baizhi.service;

import com.baizhi.entity.*;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    ChapterMapper chapterMapper;
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
    public Object querDto(Integer uid,Integer id) {
        if (uid==null||id==null){
            ErrorDto errorDto=new ErrorDto();
            errorDto.setError("400");
            errorDto.setErrMsg("参数不能为空");
            return  errorDto;
        }
        else{
            DetailWenDto detailWenDto=new DetailWenDto();
            detailWenDto.setIntroduction(albumMapper.selectByPrimaryKey(id));
            Chapter chapter=new Chapter();
            chapter.setAlbumId(id);
            detailWenDto.setList(chapterMapper.select(chapter));
            return detailWenDto;
        }

    }

    @Override
    public Album queryOneAlbum(Integer id) {
        return albumMapper.selectByPrimaryKey(id);
    }
    public void insertAlbum(Album album){
        albumMapper.insert(album);
    }


}
