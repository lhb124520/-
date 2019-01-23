package com.icss.person_manager.login.action;

import com.icss.person_manager.login.domain.User;
import com.icss.person_manager.login.service.ILoginService;

public class LoginAction {
	private String username;
    private String password;
    private String tip; 
    
    private ILoginService service;
    
 public String login() {
        
        /*service = (ILoginService) WebApplicationContextUtils
                .getWebApplicationContext(
                        ServletActionContext.getServletContext())
                .getBean("lservice");*/
        String result = service.login(new User(username, password));
        if ("login success".equals(result)) {
        	
            return "success";
        }
        tip = result;
        return "failure";
    }
    
	public void setService(ILoginService service) {
		this.service = service;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
    
}
