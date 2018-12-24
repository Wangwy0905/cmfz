package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
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
@Table(name="chapter")
public class Chapter implements Serializable {
    @Id
    @ExcelIgnore
    private String  id;
    @Excel(name="章节名")
    private String title;
    @Excel(name="章节大小")
    private String size;
    @Excel(name="章节时长")
    private String duration;
    @Excel(name="下载路径")
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name="上传时间",format = "yyyy年MM月dd日",width = 20)
    private Date uploadDate;
    @ExcelIgnore
    private Integer albumId;
}
