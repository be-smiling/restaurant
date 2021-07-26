package com.sise.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sise.entity.SysRoleUserTable;
import com.sise.vo.SysRoleAndPermissionVo;

/**
 * (SysRoleUserTable)表服务接口
 */
public interface SysRoleUserTableService extends IService<SysRoleUserTable> {

    /**
     * 批量保存角色-用户表
     * 该方法内有两个操作，先删除、后批量新增，因此存在事务控制
     * @param roleId
     * @param sysRoleAndPermissionVos
     * @return
     */
    boolean saveRoleUser(String roleId, SysRoleAndPermissionVo... sysRoleAndPermissionVos);

}