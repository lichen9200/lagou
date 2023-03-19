package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllUserByPage(@RequestBody Role role) {
        List<Role> allRole = roleService.findAllRole(role);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成 功", allRole);
        return responseResult;
    }

    /*
查询所有菜单信息
*/
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu() {
//-1 表示查询所有菜单数据
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList", menuList);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
        return result;
    }

    /**
     * 查询角色关联菜单列表ID
     * */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<String> menuList = roleService.findMenuByRoleId(roleId);
        ResponseResult result = new ResponseResult(true,200,"响应成功",menuList);
        return result;
    }
}