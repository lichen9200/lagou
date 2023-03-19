package com.lagou.service;

import com.lagou.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAllRole(Role role);

    /**
     * 根据ID查询角色关联菜单
     * */
    List<String> findMenuByRoleId(Integer roleId);
}
