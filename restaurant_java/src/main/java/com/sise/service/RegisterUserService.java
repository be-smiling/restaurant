package com.sise.service;

import com.sise.entity.PageResult;
import com.sise.entity.RegisterUser;

import java.util.Map;

public interface RegisterUserService {
    PageResult<RegisterUser> findByPage(int currentPage, int pageSize, Map searchMap);

    RegisterUser findById(Long id);

    void updateStatus(Long id);

    void unBlock(Long id);
}
