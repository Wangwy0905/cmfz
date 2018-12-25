package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
@ExcelTarget(value="user")
public class User  implements Serializable {
    @ExcelIgnore
    private  Integer id;
    @Excel(name="账号",width = 20)
    private  String phone;
    @ExcelIgnore
    private  String password;
    @ExcelIgnore
    private  String salt;
    @Excel(name="详细描述",width=20)
    private  String sign;
    @Excel(name="头像",width=20,type=2)
    private  String headPic;
    @Excel(name="真实姓名",width=20)
    private  String name;
    @Excel(name="法号",width=20)
    private  String dharma;
    @Excel(name="性别",width=20)
    private  Integer sex;
    @Excel(name="省",width=20)
    private  String province;
    @Excel(name="城市",width=20)
    private  String  city;
    @ExcelIgnore
    private  Integer status;

    @Excel(name="注册日期",width=20,format = "yyyy年MM月dd日")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date regDate;
}
