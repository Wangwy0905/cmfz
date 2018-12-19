package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="menu")
public class Menu  {
    @Id
    private Integer id;
    private  String title;
    private  String iconcls;
    private  String url;
    private String parentId;
    @Transient
    private List<Menu>  menuList;
}
