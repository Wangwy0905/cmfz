package com.baizhi.service;


import com.baizhi.entity.User;
import com.baizhi.entity.UserDtoPage;

import java.util.List;
import java.util.Map;

public interface UserService {
    public Map<String, List> query();
    public UserDtoPage queryAll(Integer rows, Integer page);
}
