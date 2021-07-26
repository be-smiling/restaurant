package com.sise.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sise.entity.SysRoleTable;
import com.sise.vo.SysRoleAndPermissionVo;

import java.util.List;

/**
 * (SysRoleTable)表服务接口
 */
public interface SysRoleTableService extends IService<SysRoleTable> {

    /**
     * 根据用户名称查询角色
     * @param userName
     * @return
     */
    List<String> getRolesByUserName(String userName);

    /**
     * 根据roleId找用户以及用户是否被设置在某个角色上，用在显示在用于角色设置处
     * @param roleId
     * @return
     */
    List<SysRoleAndPermissionVo> getRoleAndUserList(String roleId);

    /**
     * 根据roleId找菜单
     */
    List<SysRoleAndPermissionVo> getRoleAndMenuList(String roleId) ;

    /**
     * 根据roleId找API
     */
    List<SysRoleAndPermissionVo> getRoleAndApiList(String roleId);
}