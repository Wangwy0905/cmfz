package com.baizhi.controller;

import com.baizhi.conf.ValidateImageCodeUtils;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired

    AdminService adminService;
    @ResponseBody
    @RequestMapping("queryOne")
    public String  queryOne(String name,String password,String enCode,HttpSession session){

          try{
              adminService.queryOne(name,password,session,enCode);
              return "ok";

          }catch(UnknownAccountException e){
              return "账号错误,请重新输入";
          }catch(IncorrectCredentialsException e){
              return "密码错误，请重新输入";
          }catch(Exception e){
              return "验证码输入错误，请重新输入";
          }
    }

    @RequestMapping("getCode")
    public  String  getCode(HttpSession session, HttpServletResponse response){
        //生成验证码
        String code= ValidateImageCodeUtils.getSecurityCode();
        //把验证码放入图片
        session.setAttribute("code",code);
        BufferedImage image=ValidateImageCodeUtils.createImage(code);

        OutputStream outputStream=null;
        try{
            outputStream =response.getOutputStream();
            ImageIO.write(image,"png",outputStream);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return null;
    }

    //退出系统

    @RequestMapping("logoutAdmin")
    public String logoutUser() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
