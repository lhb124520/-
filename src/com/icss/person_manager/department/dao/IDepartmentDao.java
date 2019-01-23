package com.icss.person_manager.department.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icss.person_manager.department.domain.Department;

public interface IDepartmentDao {
    List<Department> query(Department department);
    void insert(Department department);
    Department getOne(int id);
    void update(Department department);
    void delete(int id);
    List<Department> SomePage(@Param("currentPage")int currentPage,@Param("getPagesCount") int getPagesCount);
	
    
   
}
