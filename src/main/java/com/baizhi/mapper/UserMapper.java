package com.baizhi.mapper;


import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    Integer totalNum();
    Integer totalNum2();
    Integer totalNum3();
    List<UserDto> query();
    List<User> queryAllUser();



}
