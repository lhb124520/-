package com.icss.person_manager.login.dao;

import com.icss.person_manager.login.domain.User;

public interface ILoginDao {
	User getUserByName(String username);
}
