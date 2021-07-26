package com.sise.mapper;

import com.sise.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    @Select("select * from employee ORDER BY id desc")
    public List<Employee> findAll();

    @Insert("insert into employee values(#{id}, #{name}, #{number}, #{sex}, #{age}, #{role}, #{phone}, #{salary}, #{stay})")
    void save(Employee employee);

    @Select("SELECT * from employee ORDER BY id desc LIMIT 1")
    Employee findLastEmpNum();

    @Select("select * from employee where id = #{id}")
    Employee findById(Long id);

    @Update("update employee set name = #{name}, sex = #{sex}, age = #{age}, role = #{role}, phone = #{phone}, salary = #{salary}, stay = #{stay} where id = #{id}")
    void update(Employee employee);

    @Update("update employee set status_ = 1 where id = #{id}")
    void delete(Long id);

    @Select("select * from employee where name like #{name}")
    List<Employee> findNameLike(String name);

    @Select("select * from employee ORDER BY id desc")
    List<Employee> getAllEmployeeList();
}
