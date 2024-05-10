package com.stu.controller;

import com.stu.entity.OnAccount;
import com.stu.service.OnAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户相关信息
 */
@RestController
@RequestMapping("/on_account/")
@Slf4j
public class OnAccountConroller {

    @Resource
    private OnAccountService onAccountService;

    @GetMapping("queryAll")
    public List<OnAccount> queryAll() {
        log.info("方法进来了.........");
        return onAccountService.queryAll();
    }
}
