package com.sise.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sise.entity.Employee;
import com.sise.entity.PageResult;
import com.sise.entity.RegisterUser;
import com.sise.service.EmployeeService;
import com.sise.service.RegisterUserService;
import com.sise.utils.RUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RegisterUserService registerUserService;

    @Autowired
    RUtil rUtil;

    //根据id查询员工
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public R findById(@PathVariable(value = "id") Long id){
        RegisterUser registerUser = registerUserService.findById(id);
        return rUtil.getInstance(0, registerUser, "查询成功");
    }

    //更新用户状态
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.PUT)
    public R updateStatus(@PathVariable(value = "id") Long id){
        registerUserService.updateStatus(id);
        return rUtil.getInstance(0, null, "用户已封号");
    }

    //解封
    @RequestMapping(value = "/unBlock/{id}", method = RequestMethod.PUT)
    public R unBlock(@PathVariable(value = "id") Long id){
        registerUserService.unBlock(id);
        return rUtil.getInstance(0, null, "用户已解封");
    }

    //获取所有员工列表
//    @RequestMapping(value = "/getAllEmployeeList", method = RequestMethod.GET)
//    public R getAllEmployeeList(){
//        List<Employee> allEmployeeList = employeeService.getAllEmployeeList();
//        return rUtil.getInstance(0, allEmployeeList, "查询成功");
//    }
//
//    //删除员工
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public R delete(@PathVariable(value = "id") Long id){
//        employeeService.delete(id);
//        return rUtil.getInstance(0, null, "删除成功");
//    }
//
//    //更新员工
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
//    public R update(@PathVariable(value = "id") Long id, @RequestBody Employee employee){
//        employeeService.update(id, employee);
//        return rUtil.getInstance(0, null, "更新成功");
//    }
//

//
//    //保存员工
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public R save(@RequestBody Employee employee){
//        employeeService.save(employee);
//        return rUtil.getInstance(0, null, "保存成功");
//    }

    //查询用户带分页
    @RequestMapping(value = "/findByPage/{page}/{perPage}", method = RequestMethod.POST)
    public R findByPage(@PathVariable(value = "page") int currentPage, @PathVariable(value = "perPage") int pageSize, @RequestBody Map searchMap){
        PageResult<RegisterUser> pageResult = registerUserService.findByPage(currentPage, pageSize, searchMap);
        return rUtil.getInstance(0, pageResult, "查询成功");
    }

}
