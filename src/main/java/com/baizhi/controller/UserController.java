package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDtoPage;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.UserService;
import com.google.gson.JsonObject;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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

    @RequestMapping("updateUser")
    public void updateUser(Integer id,Integer status){
        System.out.println("======"+id);
        userService.updateUser(id,status);

        int count =userMapper.totalNum();
        int count2=userMapper.totalNum2();
        int count3=userMapper.totalNum3();
        List list=new ArrayList();

        list.add(count);
        list.add(count2);
        list.add(count3);

        String string=JSONObject.toJSONString(list);
        GoEasy goEasy=new GoEasy("http://rest-hangzhou.goeasy.io","BC-ed05bee3bbf2424a8b7aba1b41673fe4");

        goEasy.publish("cmfz",string);

        Map<String,List> map=userService.query();
        String string1 = JSONObject.toJSONString(map);

        GoEasy goEasy1=new GoEasy("http://rest-hangzhou.goeasy.io","BC-ed05bee3bbf2424a8b7aba1b41673fe4");

        goEasy1.publish("cmfz2",string1);


    }



    @RequestMapping("query")
    public Map<String,List> query(){
        Map<String,List> map=userService.query();

        return map;
    }


    @RequestMapping("queryAllUser")
    public UserDtoPage queryAllUser(Integer rows, Integer page){
        UserDtoPage userDtoPage=userService.queryAll(rows,page);

        return userDtoPage;
    }
    @RequestMapping("queryOneUser")
    public Object queryOneUser(String phone, String password, String enCode, HttpSession session) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        return userService.queryOne(phone,password,enCode, session);
    }
    @RequestMapping("regist")
    public Object regist(String phone,String password){
        return userService.regist(phone,password);
    }
    @RequestMapping("updateUser2")
    public Object updateUser2(User user,Integer uid){
         userService.updateUser2(user,uid);
         User user1=userService.queryOne(uid);
         return user1;


    }

}

