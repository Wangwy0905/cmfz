package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Album")
public class Album implements Serializable {
    @Id
    private Integer id;
    private String title;
    private Integer count;
    private String coverImg;
    private Integer score;
    private String author;
    private String broadcast;
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date pubDate;
    private List<Chapter> children;
}
