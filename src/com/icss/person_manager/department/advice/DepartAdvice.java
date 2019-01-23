package com.icss.person_manager.department.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.person_manager.department.dao.IDepartmentDao;
import com.icss.person_manager.department.domain.Department;

public class DepartAdvice {
	@Autowired
	private IDepartmentDao idd;
	
	public Object update(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args=pjp.getArgs();
		HttpServletRequest req=null;
		HttpServletResponse res=null;
		Department de =null;
		int i=0;
		for(Object arg:args){
			if(arg instanceof HttpServletRequest){
				req=(HttpServletRequest) arg;
			}
			if(arg instanceof HttpServletResponse){
				res=(HttpServletResponse)arg;
			}
			if(arg instanceof Department){
				de=(Department) arg;
			}
			if(arg instanceof Integer){
				i=(Integer) arg;
			}
		}
		
		Object ob=null;
		if(req!=null&&res!=null){
			HttpSession session= req.getSession();
//			String username=(String) session.getAttribute("username");			
				if(de!=null){
					Department de1=idd.getOne(de.getId());
					System.out.println("修改之前");
					System.out.println(de1);
					System.out.println("修改之后");
					System.out.println(de);
					
				}
				if(i!=0){
					Department de1=idd.getOne(i);
					System.out.println("删除");
					System.out.println(de1);
					
					
				}
				 ob=pjp.proceed();
				
			
		}
		
		
		
		return ob;
	}
}
