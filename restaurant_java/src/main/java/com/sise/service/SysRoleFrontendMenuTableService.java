package com.sise.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sise.entity.SysRoleFrontendMenuTable;
import com.sise.vo.SysRoleAndPermissionVo;

/**
 * (SysRoleFrontendMenuTable)表服务接口
 */
public interface SysRoleFrontendMenuTableService extends IService<SysRoleFrontendMenuTable> {

    /**
     * 批量保存角色-菜单表
     * 该方法内有两个操作，先删除、后批量新增，因此存在事务控制
     * @param roleId
     * @param sysRoleAndPermissionVos
     * @return
     */
    boolean saveRoleMenu(String roleId, SysRoleAndPermissionVo... sysRoleAndPermissionVos);
}