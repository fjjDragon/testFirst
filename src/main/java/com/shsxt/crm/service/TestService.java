package com.shsxt.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.model.User;

@Service
public class TestService {
	
	@Autowired
	private UserDao userDao;
	
	public User selectUserById(Integer id){
		User user = userDao.selectUserById(id);
		return user	;
	}
	
}
