package com.baizhi.controller;

import com.baizhi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    MessageService messageService;
    @RequestMapping("message")
    public void MessageTest(String phone){
        messageService.Message(phone);
    }
}
