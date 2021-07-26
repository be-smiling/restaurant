package com.sise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sise.entity.SysRoleUserTable;
import com.sise.mapper.SysRoleUserTableMapper;
import com.sise.service.SysRoleUserTableService;
import com.sise.vo.SysRoleAndPermissionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * (SysRoleUserTable)表服务实现类
 */
@Service("sysRoleUserTableService")
public class SysRoleUserTableServiceImpl extends ServiceImpl<SysRoleUserTableMapper, SysRoleUserTable> implements SysRoleUserTableService {

    /**
     * 批量保存角色-用户表
     * 该方法内有两个操作，先删除、后批量新增，因此存在事务控制
     * @param roleId
     * @param sysRoleAndPermissionVos
     * @return
     */
    @Override
    @Transactional
    public   boolean saveRoleUser(String roleId, SysRoleAndPermissionVo... sysRoleAndPermissionVos){

        //先删除数据
        this.delRoleId(roleId);
        //
        if(sysRoleAndPermissionVos !=null) {
            Set<SysRoleUserTable> set = new HashSet<>();
            SysRoleUserTable roleUser = null;
            for (SysRoleAndPermissionVo roleVo : sysRoleAndPermissionVos) {
                roleUser = new SysRoleUserTable();
                //存储roleID和userID到多对对的中间表
                roleUser.setRoleId(roleVo.getRoleId());
                roleUser.setUserId(roleVo.getId());
                set.add(roleUser);
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
        LambdaQueryWrapper<SysRoleUserTable> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRoleUserTable::getRoleId,roleId);
        return this.remove(lambdaQueryWrapper);
    }
}