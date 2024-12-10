package com.stu.service;

import com.stu.entity.OnAccount;

import java.util.List;

public interface OnAccountService  {
    List<OnAccount> queryAll();

    Integer delete();
}
