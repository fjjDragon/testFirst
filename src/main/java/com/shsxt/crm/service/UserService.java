package com.shsxt.crm.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.exception.ParamException;
import com.shsxt.crm.model.User;
import com.shsxt.crm.util.MD5Util;
import com.shsxt.crm.util.UserIDBase64;
import com.shsxt.crm.vo.UserLoginIdentity;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public UserLoginIdentity findByUserName(String userName, String password){
		
		if(StringUtils.isBlank(userName)){
			throw new ParamException("请输入用户名");
			
		}
		if(StringUtils.isBlank(password)){
			throw new ParamException("请输入密码");
		
		}
		
		//根据userName查询
		User user = userDao.findByUserName(userName);
		
		// 根据userName查询数据
		if(user==null){
			throw new ParamException("用户名或密码错误");
		}
		// 密码验证 MD5加密
		String MD5pwd = MD5Util.md5Method(password);
		if(!MD5pwd.equals(user.getPassword())){
			throw new ParamException("用户名或密码错误");
		}
		
		// 构建登录实体
		UserLoginIdentity userLoginIdentity = new UserLoginIdentity();
		userLoginIdentity.setRealName(user.getTrueName());
		userLoginIdentity.setUserIdString(UserIDBase64.encoderUserID(user.getId()));
		userLoginIdentity.setUserName(userName);
		
	
		return userLoginIdentity; 
	}
	
}
