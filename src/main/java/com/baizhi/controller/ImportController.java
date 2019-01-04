package com.baizhi.controller;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("import")
public class ImportController {
    @RequestMapping("ImportUser")
       public void importUser(){
           ImportParams params=new ImportParams();
           params.setTitleRows(1);
           params.setHeadRows(1);

           List<User> users = ExcelImportUtil.importExcel(new File("E:/用户表.xls"), User.class, params);
           System.out.println(users);

       }
}
