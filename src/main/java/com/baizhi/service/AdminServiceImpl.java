package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService {
    @Autowired
    AdminMapper adminMapper;
    public Admin queryOne(Admin admin){
        Admin admin1 =adminMapper.selectOne(admin);
        if(admin1==null) throw new RuntimeException("账户不存在，请重新输入");
        System.out.println(admin.getPassword());
        System.out.println(admin1.getPassword());
        if (!admin.getPassword().equals(admin1.getPassword())) throw new RuntimeException("密码错误，请重新输入");
        return admin1;
    }
}
