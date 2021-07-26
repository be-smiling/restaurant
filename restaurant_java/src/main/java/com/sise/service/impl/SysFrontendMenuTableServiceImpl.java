package com.sise.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sise.entity.SysFrontendMenuTable;
import com.sise.mapper.SysFrontendMenuTableMapper;
import com.sise.service.SysFrontendMenuTableService;
import com.sise.vo.SysFrontendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysFrontendMenuTable)表服务实现类
 */
@Service("sysFrontendMenuTableService")
public class SysFrontendMenuTableServiceImpl extends ServiceImpl<SysFrontendMenuTableMapper, SysFrontendMenuTable> implements SysFrontendMenuTableService {


    @Autowired
    SysFrontendMenuTableMapper sysFrontendMenuTableMapper;

    /**
     * 查所有的前端菜单（编辑使用）
     */
    @Override
    public List<SysFrontendVo> getAllMenuList() {
        return this.baseMapper.getAllMenuList();
    }

    /**
     * 根据登录账号，获得前端展现的菜单
     * 控制前端菜单的权限
     * @param username
     * @return
     */
    @Override
    public List<SysFrontendMenuTable> getMenusByUserName(String username) {
        return this.baseMapper.getMenusByUserName(username);
    }

    public boolean removeByIdList(List<String> idList) {
        try {
            for (String s : idList) {
                this.baseMapper.deleteSysFrontendMenuById(s);
                this.baseMapper.deleteSysRoleFrontendMenuByFrontendMenuId(s);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}