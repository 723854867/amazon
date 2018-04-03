package org.amazon.service;

import javax.annotation.Resource;

import org.gatlin.soa.entity.UserDevice;
import org.gatlin.soa.user.api.UserService;
import org.gatlin.soa.user.bean.entity.UserInvitation;
import org.gatlin.soa.user.bean.info.LoginInfo;
import org.gatlin.soa.user.bean.model.LoginModel;
import org.gatlin.soa.user.bean.model.RegisterModel;
import org.gatlin.soa.user.bean.param.LoginParam;
import org.gatlin.soa.user.bean.param.RegisterParam;
import org.springframework.stereotype.Service;

@Service
public class BizService {

	@Resource
	private UserService userService;
	
	public LoginInfo login(LoginParam param) {
		LoginModel model = userService.login(param);
		UserDevice ndevice = model.getNdevice();
		UserDevice odevice = model.getOdevice();
		if (null != odevice && !odevice.getId().equals(ndevice.getId())) {
			// TODO: 换设备登录推送
		}
		return model.getInfo();
	}
	
	public long register(RegisterParam param) { 
		RegisterModel model = userService.register(param);
		UserInvitation invitation = model.getInvitation();
		if (null != invitation) {
			// TODO:处理邀请
		}
		return model.getUid();
	}
}
