package com.baizhi.mapper;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;

import java.util.List;

public interface ShiroMapper {
    List<Role> queryRole(String primaryPrincipal);
    List<Permission> queryPermission(String primaryPrincipal);
}
