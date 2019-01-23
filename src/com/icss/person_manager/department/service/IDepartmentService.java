package com.icss.person_manager.department.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.person_manager.department.domain.Department;

public interface IDepartmentService {	
	
	List<Department> queryBook(Department dep);
    void AddDepartment(Department dep);
    Department getDepartment(int id);
    void updateDepartment(Department dep, HttpServletRequest req, HttpServletResponse res);
	void deleteDepartment(int id, HttpServletRequest req, HttpServletResponse res);

	

	
}
