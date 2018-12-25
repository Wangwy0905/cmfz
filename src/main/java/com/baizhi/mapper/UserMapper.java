package com.baizhi.mapper;


import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public Integer totalNum();
    public Integer totalNum2();
    public Integer totalNum3();
    public List<UserDto> query ();
    public List<User> queryAllUser();
}
