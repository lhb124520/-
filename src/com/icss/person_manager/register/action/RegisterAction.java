package com.icss.person_manager.register.action;

import java.util.List;

import com.icss.person_manager.register.domain.User;
import com.icss.person_manager.register.service.IRegisterService;

public class RegisterAction {
	private String account;
	private String password;
	private IRegisterService service;
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




	public RegisterAction(String account, String password) {
	super();
	this.account = account;
	this.password = password;
}

	public RegisterAction(IRegisterService service) {
		super();
		this.service = service;
	}

	public String register(){
		
		
	    service.insert(new User(account,password));
		
		return "success";
	}

}
