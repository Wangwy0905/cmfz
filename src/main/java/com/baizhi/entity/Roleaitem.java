package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roleaitem {
    @Id
    private  Integer id;
    private  Integer aid;
    private  Integer rid;
}
