package com.icss.person_manager.department.service.impl;


import java.util.List;

import com.icss.person_manager.department.dao.IDepartmentDao;

import com.icss.person_manager.department.domain.Department;
import com.icss.person_manager.department.service.IDepartmentService;
import com.icss.person_manager.department.service.IPagingService;



public class PagingUtil implements IPagingService{
  private int pageCount = 5;// ÿҳ��¼��
  private IDepartmentDao dao;
 
 


  public PagingUtil() {
	super();
}



public PagingUtil(int pageCount) {
    this.pageCount = pageCount;
  }



public IDepartmentDao getDao() {
	return dao;
}

public void setDao(IDepartmentDao dao) {
	this.dao = dao;
}

// ��ѯ�ܼ�¼��
  public int getMaxRecoder() {
	Department de = null;
    return dao.query(de).size();
  }

  // ��ҳ
  public int firstPage() {
    return 1;
  }

  // ��һҳ
  public int previousPage(int currentPage) {
    if (currentPage <= this.firstPage()) {
      return this.firstPage();
    } else if (currentPage > this.lastPage()) {
      return this.lastPage();
    } else {
      return currentPage - 1;
    }
  }

  // ��һҳ
  public int nextPage(int currentPage) {
    if (currentPage >= this.lastPage()) {
      return this.lastPage();
    } else if (currentPage < this.firstPage()) {
      return this.firstPage();
    } else {
      return currentPage + 1;
    }
  }

  // ĩҳ
  public int lastPage() {
    return (this.getMaxRecoder() - 1) / this.pageCount + 1;//
  }

  public void setPageCount(int pageCount) {
   this.pageCount = pageCount;
  }

@Override
public List<Department> getSomePage(int currentPage, int getPagesCount) {
	  		
		    int start = 1;
		    if (currentPage - getPagesCount >= 1 && currentPage + getPagesCount <= this.lastPage()) {
		      start = currentPage - getPagesCount;
		    } else if (currentPage - getPagesCount < 1) {
		      start = 1;
		    } else {
		      start = this.lastPage() - getPagesCount * 2;//
		    }
		   /* String sql = "select userId,userName,userPass,realName";
		    sql += " from UserInfo";
		    sql += " limit ?,?";*/
		    List<Department> list = dao.SomePage((start - 1) * this.pageCount, this.pageCount * (getPagesCount * 2 + 1));
		    /*this.dao.showList(list);
		    System.out.println("һ��������" + list.size() + "����¼��");*/
		    return list;
		  
}

  /**
   * ���ݿ��ҳ����
   * 
   * @param currentPage
   *          ��ǰҳ��
   * @param getPagesCount
   *          ��ȡǰ��nҳ���ݣ�������Ϊn*2+1*ÿҳ��¼��
   * @return
   */

}
