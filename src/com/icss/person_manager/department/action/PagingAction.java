package com.icss.person_manager.department.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.person_manager.department.domain.Department;

import com.icss.person_manager.department.service.IPagingService;
import com.icss.person_manager.department.service.impl.PagingUtil;


public class PagingAction extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cp;	
	private IPagingService pu;
	private Map<String, Integer> data;
	private List<Department> result;	
	private IPagingService service;

	    

//	public PagingAction(IPagingService service) {
//			super();
//			this.service = service;
//		}
	public PagingAction(IPagingService pu) {
	super();
	this.pu = pu;
}
//	@Override
//	  public void init(ServletConfig config) throws ServletException {
//	    super.init(config);
//	    String pageCount = config.getInitParameter("pageCount");
//	    int pc = 10;
//	    try {
//	      pc = Integer.parseInt(pageCount);
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	    }
//	    this.pu = new PagingUtil(pc);
//	  }

	
	public String paging(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		int currentPage = 1;
	    try {//request.getParameter("cp")
	    	
	      currentPage = Integer.parseInt(cp);
	    } catch (Exception e) {
	     
	    }
	    
	    
	    List<Department> list = this.pu.getSomePage(currentPage, 0);
	    result = list;
	    

	    Map<String, Integer> data = new HashMap<String, Integer>();
	    data.put("first", this.pu.firstPage());
	    data.put("previous", this.pu.previousPage(currentPage));
	    data.put("next", this.pu.nextPage(currentPage));
	    data.put("last", this.pu.lastPage());
	    request.setAttribute("data", data);
	    
        return "success";
	    
	}
	

	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}



	public void setPu(PagingUtil pu) {
		this.pu = pu;
	}

	public Map<String, Integer> getData() {
		return data;
	}

	public void setData(Map<String, Integer> data) {
		this.data = data;
	}

	public List<Department> getResult() {
		return result;
	}

	public void setResult(List<Department> result) {
		this.result = result;
	}
	
}
