package com.sise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.entity.Employee;
import com.sise.entity.PageResult;
import com.sise.entity.RegisterUser;
import com.sise.mapper.RegisterUserMapper;
import com.sise.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    RegisterUserMapper registerUserMapper;

    @Override
    public PageResult<RegisterUser> findByPage(int currentPage, int pageSize, Map searchMap) {
        String username = (String)searchMap.get("username");
        if (!ObjectUtils.isEmpty(username)){
            PageHelper.startPage(currentPage, pageSize);
            List<RegisterUser> registerUserList = registerUserMapper.findUserNameLike("%"+username+"%");
            PageInfo<RegisterUser> registerUserInfo = new PageInfo<>(registerUserList);
            return new PageResult<>(registerUserInfo.getTotal(), registerUserInfo.getList());
        }else {
            PageHelper.startPage(currentPage, pageSize);
            List<RegisterUser> registerUserList = registerUserMapper.findAll();
            PageInfo<RegisterUser> registerUserInfo = new PageInfo<>(registerUserList);
            return new PageResult<>(registerUserInfo.getTotal(), registerUserInfo.getList());
        }

    }

    @Override
    public RegisterUser findById(Long id) {
        return registerUserMapper.findById(id);
    }

    @Override
    public void updateStatus(Long id) {
        registerUserMapper.updateStatus(id);
    }

    @Override
    public void unBlock(Long id) {
        registerUserMapper.unBlock(id);
    }
}
