package com.icss.person_manager.department.service;

import java.util.List;

import com.icss.person_manager.department.domain.Department;

public interface IPagingService {	
	
	List<Department> getSomePage(int currentPage, int getPagesCount);

	int firstPage();

	int previousPage(int currentPage);

	int nextPage(int currentPage);

	int lastPage();

	

	
}
