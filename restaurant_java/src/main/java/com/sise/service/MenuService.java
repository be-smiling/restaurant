package com.sise.service;

import com.sise.entity.Menu;
import com.sise.entity.PageResult;
import org.springframework.web.multipart.MultipartFile;

public interface MenuService      {
    PageResult<Menu> findByPage(int currentPage, int pageSize);

    void add(Menu menu, MultipartFile imgFile);

    Menu findById(Long id);

    void update(Long id, Menu menu, MultipartFile imgFile);

    void delete(Long id);
}
