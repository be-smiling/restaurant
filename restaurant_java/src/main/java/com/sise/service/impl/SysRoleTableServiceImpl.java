package com.sise.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sise.entity.SysRoleTable;
import com.sise.mapper.SysRoleTableMapper;
import com.sise.service.SysRoleTableService;
import com.sise.vo.SysRoleAndPermissionVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysRoleTable)表服务实现类
 */
@Service("sysRoleTableService")
public class SysRoleTableServiceImpl extends ServiceImpl<SysRoleTableMapper, SysRoleTable> implements SysRoleTableService {

    /**
     * 根据用户名称查询角色
     * @param userName
     * @return
     */
    @Override
    public List<String> getRolesByUserName(String userName){
       return this.baseMapper.getRolesByUserName(userName);
    }

    /**
     * 根据roleId找用户以及用户是否被设置在某个角色上，用在显示在用于角色设置处
     * @param roleId
     * @return
     */
    @Override
    public List<SysRoleAndPermissionVo> getRoleAndUserList(String roleId){
      return this.baseMapper.getRoleAndUserList(roleId);
    }

    /**
     * 根据roleId找菜单
     */
    @Override
    public List<SysRoleAndPermissionVo> getRoleAndMenuList(String roleId)
             {
            return this.baseMapper.getRoleAndMenuList(roleId);
    }

    /**
     * 根据roleId找API
     */
    @Override
    public List<SysRoleAndPermissionVo> getRoleAndApiList(String roleId){
        return this.baseMapper.getRoleAndApiList(roleId);
    }


}