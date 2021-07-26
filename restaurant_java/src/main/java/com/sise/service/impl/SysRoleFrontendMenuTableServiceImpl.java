package com.sise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sise.entity.SysRoleFrontendMenuTable;
import com.sise.mapper.SysRoleFrontendMenuTableMapper;
import com.sise.service.SysRoleFrontendMenuTableService;
import com.sise.vo.SysRoleAndPermissionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * (SysRoleFrontendMenuTable)表服务实现类
 */
@Service("sysRoleFrontendMenuTableService")
public class SysRoleFrontendMenuTableServiceImpl extends ServiceImpl<SysRoleFrontendMenuTableMapper, SysRoleFrontendMenuTable> implements SysRoleFrontendMenuTableService {

    /**
     * 批量保存角色-菜单表
     * 该方法内有两个操作，先删除、后批量新增，因此存在事务控制
     * @param roleId
     * @param sysRoleAndPermissionVos
     * @return
     */
    @Override
    @Transactional
    public   boolean saveRoleMenu(String roleId, SysRoleAndPermissionVo... sysRoleAndPermissionVos) {

        //先删除数据
        this.delRoleId(roleId);
        //
        if(sysRoleAndPermissionVos !=null) {
            Set<SysRoleFrontendMenuTable> set = new HashSet<>();
            SysRoleFrontendMenuTable roleFrontendMenu = null;
            for (SysRoleAndPermissionVo roleVo : sysRoleAndPermissionVos) {
                roleFrontendMenu = new SysRoleFrontendMenuTable();
                //存储roleID和FrontendMenuId到多对对的中间表
                roleFrontendMenu.setRoleId(roleVo.getRoleId());
                roleFrontendMenu.setFrontendMenuId(roleVo.getId());
                set.add(roleFrontendMenu);
            }
            //再批量保存
            return this.saveBatch(set);
        }
        return  false;
    }

    /**
     * 根据RoleId删除
     * @param roleId
     * @return
     */
    private boolean delRoleId(String roleId) {
        LambdaQueryWrapper<SysRoleFrontendMenuTable> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRoleFrontendMenuTable::getRoleId,roleId);
        return this.remove(lambdaQueryWrapper);
    }
}