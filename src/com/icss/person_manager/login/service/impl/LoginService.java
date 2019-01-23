package com.icss.person_manager.login.service.impl;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.icss.person_manager.login.dao.ILoginDao;
import com.icss.person_manager.login.domain.User;
import com.icss.person_manager.login.service.ILoginService;

public class LoginService implements ILoginService{
    
    private ILoginDao dao;
    
    /*public LoginService(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("/dbConf.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(is).openSession();
        dao = session.getMapper(ILoginDao.class);
    }*/
    
    @Override
    public String login(User user) {
       HttpServletRequest req=ServletActionContext.getRequest();
        User _user = dao.getUserByName(user.getUsername());
        
        // logic
        if (_user == null)
            return "has no user " +user.getUsername();
        if (!_user.getPassword().equals(user.getPassword()))
            return "invalida password";
        req.getSession().setAttribute("username", user.getUsername());
        return "login success";
    }

    public void setDao(ILoginDao dao) {
        this.dao = dao;
    }
}
        