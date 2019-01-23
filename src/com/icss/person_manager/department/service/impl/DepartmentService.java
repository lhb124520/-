package com.icss.person_manager.department.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.person_manager.department.dao.IDepartmentDao;
import com.icss.person_manager.department.domain.Department;
import com.icss.person_manager.department.service.IDepartmentService;


public class DepartmentService implements IDepartmentService{
    
    private IDepartmentDao dao;
    
    
    @Override
    public List<Department> queryBook(Department dep) {
        
        
        return dao.query(dep);
    }
    
    
    
    public void setDao(IDepartmentDao dao) {
        this.dao = dao;
    }



	@Override
	public void AddDepartment(Department dep) {
		dao.insert(dep);
		
	}



	@Override
	public Department getDepartment(int id) {
		 return dao.getOne(id);
	}



	



	



	@Override
	public void updateDepartment(Department dep, HttpServletRequest req, HttpServletResponse res) {
		dao.update(dep);
		
	}



	@Override
	public void deleteDepartment(int id, HttpServletRequest req, HttpServletResponse res) {
		dao.delete(id);
		
	}


   
    
    
}
