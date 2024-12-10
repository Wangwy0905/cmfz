package com.stu.mapper;

import com.stu.entity.OnAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OnAccountMapper {
    List<OnAccount> queryAll();

    Integer delete();

}
