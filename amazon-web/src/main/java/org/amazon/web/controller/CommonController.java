package org.amazon.web.controller;

import javax.annotation.Resource;

import org.gatlin.soa.user.api.UserService;
import org.gatlin.soa.user.bean.param.LoginParam;
import org.gatlin.soa.user.bean.param.RegisterParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("common")
public class CommonController {
	
	@Resource
	private UserService userService;

	@ResponseBody
	@RequestMapping("login")
	public Object login(LoginParam param) {
		return userService.login(param);
	}
	
	@ResponseBody
	@RequestMapping("register")
	public Object login(RegisterParam param) {
		return userService.register(param);
	}
}
