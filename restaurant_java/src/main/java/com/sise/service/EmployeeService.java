package com.sise.service;

import com.sise.entity.Employee;
import com.sise.entity.PageResult;

import java.util.List;
import java.util.Map;

public interface EmployeeService  {

    //根据分页带条件查
    PageResult<Employee> findByPage(int currentPage, int pageSize, Map searchMap);

    void save(Employee employee);

    Employee findById(Long id);

    void update(Long id, Employee employee);

    void delete(Long id);

    List<Employee> getAllEmployeeList();
}
