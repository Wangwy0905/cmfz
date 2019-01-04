package com.baizhi.controller;

import com.baizhi.service.CheckMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check")
public class CheckMessageController {
    @Autowired
    CheckMessageService checkMessageService;
    @RequestMapping("checkMessage")
    public Object checkMessage(String phone,String code){
        return checkMessageService.checkMessage(phone, code);
    }
}
