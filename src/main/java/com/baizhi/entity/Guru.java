package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="guru")
public class Guru {
    @Id
    private  Integer id;
    private  String dharma;
    private  String headPic;
    private  Integer status;
}