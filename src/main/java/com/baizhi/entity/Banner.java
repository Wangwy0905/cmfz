package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="banner")
public class Banner implements Serializable {
    @Id
    private  Integer id;
    private  String title;
    private  String imgPath;
    private  Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date pubDate;
    private  String descption;
}
