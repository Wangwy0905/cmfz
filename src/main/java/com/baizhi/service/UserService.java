package com.baizhi.service;


import com.baizhi.entity.User;
import com.baizhi.entity.UserDtoPage;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, List> query();
    UserDtoPage queryAll(Integer rows, Integer page);
    //public void updateUser(Integer id);
    void updateUser(Integer id, Integer status);
    Object  queryOne(String phone, String password, String enCode, HttpSession session);
    Object regist(String phone, String password);
    Object  updateUser2(User user, Integer uid);
    User queryOne(Integer id);

}
