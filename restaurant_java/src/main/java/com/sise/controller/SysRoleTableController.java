package com.sise.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.entity.SysRoleTable;
import com.sise.service.SysRoleBackendApiTableService;
import com.sise.service.SysRoleFrontendMenuTableService;
import com.sise.service.SysRoleTableService;
import com.sise.service.SysRoleUserTableService;
import com.sise.vo.SysRoleAndPermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (SysRoleTable)表控制层
 */
@RestController
@RequestMapping("sysRoleTable")
public class SysRoleTableController extends ApiController {
    /**
     * 角色
     */
    @Resource
    private SysRoleTableService sysRoleTableService;

    /**
     * 角色-用户
     */
    @Autowired
    SysRoleUserTableService sysRoleUserTableService;

    /**
     * 角色-前端菜单
     */
    @Autowired
    SysRoleFrontendMenuTableService sysRoleFrontendMenuTableService;

    /**
     * 角色-API
     */
    @Autowired
    SysRoleBackendApiTableService sysRoleBackendApiTableService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysRoleTable 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysRoleTable> page, SysRoleTable sysRoleTable) {
        return success(this.sysRoleTableService.page(page, new QueryWrapper<>(sysRoleTable)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysRoleTableService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRoleTable 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysRoleTable sysRoleTable) {
        return success(this.sysRoleTableService.save(sysRoleTable));
    }

    /**
     * 修改数据
     *
     * @param sysRoleTable 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysRoleTable sysRoleTable) {
        return success(this.sysRoleTableService.updateById(sysRoleTable));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.sysRoleTableService.removeByIds(idList));
    }

    //-----------------------------------------------------------------------
    /**
     * 对应前端：系统管理->用户角色设置->右边用户查询
     * @param roleId
     * @return
     */
    @GetMapping("/roleUser/{roleId}")
    public R getRoleAndUserList(@PathVariable("roleId") String roleId) {
        return success(sysRoleTableService.getRoleAndUserList(roleId));
    }

    @PostMapping("/roleUser/set")
    public R saveRoleUser(@RequestParam("roleId") String roleId,
                          @RequestBody SysRoleAndPermissionVo[] sysRoleAndPermissionVos){

        return success(sysRoleUserTableService.saveRoleUser(roleId, sysRoleAndPermissionVos));
    }

    //-----------------------------------------------------------------------
    /**
     * 对应前端：系统管理->菜单角色设置->右边菜单查询
     * @param roleId
     * @return
     */
    @GetMapping("/roleMenu/{roleId}")
    public R getRoleAndMenuList(@PathVariable("roleId") String roleId) {
        return success(sysRoleTableService.getRoleAndMenuList(roleId));
    }


    @PostMapping("/roleMenu/set")
    public R saveRoleMenu(@RequestParam("roleId") String roleId,
                                @RequestBody SysRoleAndPermissionVo[] sysRoleAndPermissionVos){

        return success(sysRoleFrontendMenuTableService.saveRoleMenu(roleId,sysRoleAndPermissionVos));
    }

    //-----------------------------------------------------------------------
    /**
     * 对应前端：系统管理->菜单角色设置->右边api查询
     * @param roleId
     * @return
     */
    @GetMapping("/roleApi/{roleId}")
    public R getRoleAndApiList(@PathVariable("roleId") String roleId) {
        return success(sysRoleTableService.getRoleAndApiList(roleId));
    }


    @PostMapping("/roleApi/set")
    public R saveRoleApi(@RequestParam("roleId") String roleId,
                          @RequestBody SysRoleAndPermissionVo[] sysRoleAndPermissionVos){

        return success(sysRoleBackendApiTableService.saveRoleAip(roleId,sysRoleAndPermissionVos));
    }



}