package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDtoPage;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @RequestMapping("totalNum")
    public int[] totalNum(){
        int count=userMapper.totalNum();
        int count2=userMapper.totalNum2();
        int count3=userMapper.totalNum3();

        int[] arr=new int[3];

        arr[0]=count;
        arr[1]=count2;
        arr[2]=count3;

        return arr;
    }

    @RequestMapping("query")
    public Map<String,List> query(){
        Map<String,List> map=userService.query();
        System.out.println(map+"----------------");
        return map;
    }
    @RequestMapping("queryAllUser")
    public UserDtoPage queryAllUser(Integer rows, Integer page){
        UserDtoPage userDtoPage=userService.queryAll(rows,page);

        return userDtoPage;
    }
}
