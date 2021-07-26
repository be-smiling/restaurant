package com.sise.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sise.entity.SysBackendApiTable;
import com.sise.vo.SysBackendApiVo;

import java.util.List;

/**
 * (SysBackendApiTable)表服务接口
 */
public interface SysBackendApiTableService extends IService<SysBackendApiTable> {

    /**
     * 根据角色查询API接口URL
     * @param roles
     * @return
     */
    List<SysBackendApiTable> getApiUrlByRoles(String... roles);

    /**
     * 根据用户名称查询API接口URL
     * @param username
     * @return
     */
    List<SysBackendApiTable> getApiUrlByUserName(String username);

    /**
     * 查所有（编辑使用）
     */
    List<SysBackendApiVo> getAllApiList();
}