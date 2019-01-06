package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rolepitem {
    @Id
    private Integer id;
    private  Integer rid;
    private  Integer pid;

}
