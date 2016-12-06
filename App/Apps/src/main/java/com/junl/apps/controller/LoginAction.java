package com.junl.apps.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junl.apps.common.ApiMessage;
import com.junl.apps.service.users.IUsers;

@Controller
@RequestMapping("/login")
public class LoginAction {
	
	@Autowired
	private IUsers userServices;
	
	
	
	/** 登陆
	 * 请求地址：http://127.0.0.1:8006/Apps/login/login.do
	 * 参数：
	 * 		 username			用户名			必填
	 * 		 password			密码				必填
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="login")
	public @ResponseBody Map<String, Object> login(
			@RequestBody Map<String, Object> model) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			map=userServices.queryUserByUserName(model);
			return ApiMessage.builder(true, map);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
