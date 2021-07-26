package com.sise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.mapper.EmployeeMapper;
import com.sise.entity.Employee;
import com.sise.entity.PageResult;
import com.sise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 员工业务类
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 分页查
     * @param currentPage 当前页
     * @param pageSize 每页显示多少条
     * @param searchMap 条件查询对象
     * @return
     */
    @Override
    public PageResult<Employee> findByPage(int currentPage, int pageSize, Map searchMap) {
        String name = (String)searchMap.get("name");
        if (!ObjectUtils.isEmpty(name)){
            PageHelper.startPage(currentPage, pageSize);
            // 模糊查询员工名称为name的数据列表
            List<Employee> employeeList = employeeMapper.findNameLike("%"+name+"%");
            PageInfo<Employee> employeePageInfo = new PageInfo<>(employeeList);
            return new PageResult<>(employeePageInfo.getTotal(), employeePageInfo.getList());
        }else {
            PageHelper.startPage(currentPage, pageSize);
            // 查询全部员工
            List<Employee> employeeList = employeeMapper.findAll();
            PageInfo<Employee> employeePageInfo = new PageInfo<>(employeeList);
            return new PageResult<>(employeePageInfo.getTotal(), employeePageInfo.getList());
        }
    }

    @Override
    public void save(Employee employee) {
        if (StringUtils.isEmpty(employee.getNumber())){
            // 设置员工编号
            Employee lastEmployee = employeeMapper.findLastEmpNum();
            int empNum = Integer.valueOf(lastEmployee.getNumber().substring(3)) + 1;
            employee.setNumber("emp" + empNum);
        }
        employeeMapper.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeMapper.findById(id);
    }

    @Override
    public void update(Long id, Employee employee) {
        employee.setId(id);
        employeeMapper.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeMapper.delete(id);
    }

    @Override
    public List<Employee> getAllEmployeeList() {
        return employeeMapper.getAllEmployeeList();
    }
}
