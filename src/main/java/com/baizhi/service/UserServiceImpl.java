package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;
import com.baizhi.entity.UserDtoPage;
import com.baizhi.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.apache.poi.util.PackageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements  UserService {
   @Autowired
    UserMapper userMapper;

    public Map<String,List> query() {

        List<UserDto> userDtos=userMapper.query();

        Map<String,List> map=new HashMap<String,List>();

        map.put("data",userDtos);

        return map;
    }


    public UserDtoPage queryAll(Integer rows, Integer page){
        UserDtoPage userDtoPage=new UserDtoPage();
        PageHelper.startPage(page,rows);

        List<User> list=userMapper.selectAll();
        int number=userMapper.selectCount(null);

        userDtoPage.setTotal(number);

        userDtoPage.setRows(list);


        return userDtoPage;




    }
}
