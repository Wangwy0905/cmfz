package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService {
    @Autowired
    AdminMapper adminMapper;
    public void queryOne(String name,String password, HttpSession session,String enCode){
        Subject subject= SecurityUtils.getSubject();
        AuthenticationToken authenticationToken=new UsernamePasswordToken(name,password);
        String  code = (String)session.getAttribute("code");
        if(!code.toUpperCase().equals(enCode.toUpperCase()))throw new RuntimeException("验证码输入错误，请重新输入验证");
        subject.login(authenticationToken);


    }
}
