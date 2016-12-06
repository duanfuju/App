package com.junl.apps.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junl.apps.common.ApiMessage;
import com.junl.apps.service.yanshouximu.IYanShouXinXi;

@Controller
@RequestMapping("/yssm")
public class YanShouXinXiAction {
	@Autowired
	private IYanShouXinXi yssmServices;
	
	/**
	 * 请求地址：http://127.0.0.1:8006/Apps/yssm/queryAll.do
	 *		参数：
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryAll")
	public @ResponseBody Map<String, Object> queryAll() throws Exception {
		try {
			List<Map<String, Object>> list = yssmServices.queryAll();
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
}
