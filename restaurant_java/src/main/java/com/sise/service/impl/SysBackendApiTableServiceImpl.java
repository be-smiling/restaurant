package com.sise.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sise.entity.SysBackendApiTable;
import com.sise.mapper.SysBackendApiTableMapper;
import com.sise.service.SysBackendApiTableService;
import com.sise.vo.SysBackendApiVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysBackendApiTable)表服务实现类
 */
@Service("sysBackendApiTableService")
public class SysBackendApiTableServiceImpl extends ServiceImpl<SysBackendApiTableMapper, SysBackendApiTable> implements SysBackendApiTableService {

    /**
     * 根据角色查询API接口URL
     * @param roles
     * @return
     */
    @Override
    public List<SysBackendApiTable> getApiUrlByRoles(String... roles) {
        return this.baseMapper.getApiUrlByRoles(roles);
    }

    /**
     * 根据用户名称查询API接口URL
     * @param username
     * @return
     */
    @Override
    public List<SysBackendApiTable> getApiUrlByUserName(String username) {
        return this.baseMapper.getApiUrlByUserName(username);
    }

    /**
     * 查所有（编辑使用）
     */
    @Override
    public List<SysBackendApiVo> getAllApiList() {
        return this.baseMapper.getAllApiList();
    }
}