package com.stu.service.impl;

import com.stu.entity.OnAccount;
import com.stu.mapper.OnAccountMapper;
import com.stu.service.OnAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class OnAccountServiceImpl implements OnAccountService {
    @Resource
    private OnAccountMapper onAccountMapper;

    public List<OnAccount> queryAll() {
        List<OnAccount> onAccounts = onAccountMapper.queryAll();
        return onAccounts;
    }

    @Override
    public Integer delete() {
        return onAccountMapper.delete();
    }


}
