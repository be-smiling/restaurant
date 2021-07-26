package com.sise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.mapper.MenuMapper;
import com.sise.entity.Menu;
import com.sise.entity.PageResult;
import com.sise.service.MenuService;
import com.sise.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    FileUploadUtil fileUploadUtil;

    NumberFormat nf = NumberFormat.getInstance();

    @Override
    public PageResult<Menu> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Menu> menuList = menuMapper.findAll();
        for (Menu menu : menuList) {
            menu.setPrice(new BigDecimal(nf.format(menu.getPrice().multiply(new BigDecimal(0.01)))));
        }
        PageInfo<Menu> menuPageInfo = new PageInfo<>(menuList);
        return new PageResult<>(menuPageInfo.getTotal(), menuPageInfo.getList());
    }

    @Override
    public void add(Menu menu, MultipartFile imgFile) {
        String url = fileUploadUtil.uploadImg(imgFile);
        menu.setPrice(menu.getPrice().multiply(new BigDecimal(100)));
        menu.setUrl(url);
        menuMapper.add(menu);
    }

    @Override
    public Menu findById(Long id) {
        Menu menu = menuMapper.findById(id);
        menu.setPrice(new BigDecimal(nf.format(menu.getPrice().multiply(new BigDecimal(0.01)))));
        return menu;
    }

    @Override
    public void update(Long id, Menu menu, MultipartFile imgFile) {
        menu.setId(id);
        menu.setPrice(menu.getPrice().multiply(new BigDecimal(100)));
        if (!ObjectUtils.isEmpty(imgFile)){
          String url = fileUploadUtil.uploadImg(imgFile);
          menu.setUrl(url);
        }
        menuMapper.update(menu);
    }

    @Override
    public void delete(Long id) {
        menuMapper.delete(id);
    }
}
