package com.icss.person_manager.register.service.impl;

import java.util.List;

import com.icss.person_manager.register.dao.IRegisterDao;
import com.icss.person_manager.register.domain.User;
import com.icss.person_manager.register.service.IRegisterService;

public class RegisterService implements IRegisterService {
  private  IRegisterDao dao ;
	@Override
	public void insert(User user) {
		dao.insert(user);
		
	}
	public IRegisterDao getDao() {
		return dao;
	}
	public void setDao(IRegisterDao dao) {
		this.dao = dao;
	}

}
