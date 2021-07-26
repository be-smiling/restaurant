package com.sise.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sise.entity.Menu;
import com.sise.entity.PageResult;
import com.sise.entity.Result;
import com.sise.entity.StatusCode;
import com.sise.service.MenuService;
import com.sise.utils.RUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    RUtil rUtil;

    //删除菜单项
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public R update(@PathVariable Long id){
        menuService.delete(id);
        return rUtil.getInstance(0, null, "删除成功！");
    }

    //更新菜单项
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public R update(@PathVariable Long id, Menu menu, MultipartFile imgFile){
        menuService.update(id, menu, imgFile);
        return rUtil.getInstance(0, null, "更新成功！");
    }

    //根据id查询
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public R findById(@PathVariable Long id){
        Menu menu = menuService.findById(id);
        return rUtil.getInstance(0, menu, "查询成功！");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public R add(Menu menu, MultipartFile imgFile){
        menuService.add(menu, imgFile);
        return rUtil.getInstance(0, null, "添加成功！");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public R upload(HttpServletRequest request){
        return rUtil.getInstance(0, null, "上传成功！");
    }

    @RequestMapping(value = "/findByPage/{page}/{pageSize}", method = RequestMethod.GET)
    public R findByPage(@PathVariable int page, @PathVariable int pageSize){
        PageResult<Menu> pageResult = menuService.findByPage(page, pageSize);
        return rUtil.getInstance(0, pageResult, "查询成功！");
    }
}
