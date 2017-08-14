package com.shsxt.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.vo.UserLoginIdentity;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping("login")
	@ResponseBody
	public ResultInfo login(String userName, String password) {
		ResultInfo result = new ResultInfo();
		UserLoginIdentity userLoginIdentity = userService.findByUserName(userName, password);
		result	= success(userLoginIdentity);
		return result;
	}
}
