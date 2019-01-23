package com.icss.person_manager.department.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.icss.person_manager.department.domain.Department;
import com.icss.person_manager.department.service.IDepartmentService;
import com.opensymphony.xwork2.ActionContext;

public class DepartmentAction {
    private String dep;    
    private List<Department> result;
    private Department department;
    private int id;

    private IDepartmentService service;

    public DepartmentAction() {
    }

    public DepartmentAction(IDepartmentService service) {

        this.service = service;
    }

    public String queryBook() {
        List<Department> department = service
                .queryBook(new Department(0,dep,null,null));
        result = department;
        return "success";
    }
    public String doAddDepartment() {
      
    	 service.AddDepartment(department);
    	return queryBook();
    }
   public String doGetDepartment() {
	   System.out.println(id);
	   department = service.getDepartment(id);
        return "success";
    }

 public String doUpdateDepartment() {
	 HttpServletRequest req=ServletActionContext.getRequest();
	 HttpServletResponse res=ServletActionContext.getResponse();
	 
	 
	 	service.updateDepartment(department,req,res);
        return queryBook();
    }

   public String doDeleteDepartment() {
	   HttpServletRequest req=ServletActionContext.getRequest();
		 HttpServletResponse res=ServletActionContext.getResponse();
        service.deleteDepartment(id,req,res);
        return queryBook();
    }
    

  

    public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public List<Department> getResult() {
        return result;
    }

    public void setResult(List<Department> result) {
        this.result = result;
    }

    

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

   

}
