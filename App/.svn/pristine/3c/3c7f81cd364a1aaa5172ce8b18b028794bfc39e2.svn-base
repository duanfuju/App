package com.junl.apps.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junl.apps.common.ApiMessage;
import com.junl.apps.form.ChouJianForm;
import com.junl.apps.model.ChouJianModel;
import com.junl.apps.service.choujian.IChouJian;
import com.junl.frame.core.common.page.PageInfo;

@Controller
@RequestMapping("/choujian")
public class ChouJianAction {
	
	@Autowired
	private IChouJian choujianServices;
	
	
	
	
	
	
	
	/**抽检管理中的完成抽检
	 * 请求地址：http://127.0.0.1:8006/Apps/choujian/updateChouJianState.do
	 *		参数：
	 *			ids			抽检的ids			必填
	 *			acceptTime	通过时间			必填
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="updateChouJianState")
	public @ResponseBody Map<String, Object> updateChouJianState(
			@RequestBody ChouJianModel form) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			int res = choujianServices.updateChouJianState(form);
			map.put("state", res);
			return ApiMessage.builder(true, map);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	/**抽检管理中的退回和通过
	 * 请求地址：http://127.0.0.1:8006/Apps/choujian/updateWithYanShou.do
	 *		参数：
	 *			ids			维修的ids			必填
	 *			state		是否通过			必填（3：验收	4：未通过）
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="updateWithYanShou")
	public @ResponseBody Map<String, Object> updateWithYanShou(
			@RequestBody ChouJianModel form) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			int res = choujianServices.updateWithYanShou(form);
			map.put("state", res);
			return ApiMessage.builder(true, map);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	
	
	
	/**抽检管理中的验收列表
	 * 请求地址：http://127.0.0.1:8006/Apps/choujian/queryForEachChouJianGuanLi.do
	 *		参数：
	 *			byIds		报验表的ids			必填
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryForEachChouJianGuanLi")
	public @ResponseBody Map<String, Object> queryForEachChouJianGuanLi(
			@RequestBody ChouJianForm form) throws Exception {
		
		try {
			List<Map<String, Object>> list = choujianServices.queryForEachChouJianGuanLi(form);
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 请求地址：http://127.0.0.1:8006/Apps/choujian/queryChouJianListPage.do
	 *		参数：
	 *			pageNo			当前页码				必填
	 *			limit			限制查询的记录数			必填
	 *			_state			状态（>）				第一次必填(已设死为0)			
	 *			state			状态(=)
	 *		返回：json
	 *		PS：
	 *			抽检任务不加参数
	 *			抽检管理	_state=0
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryChouJianListPage")
	public @ResponseBody Map<String, Object> queryChouJianListPage(
			@RequestBody ChouJianForm form) throws Exception {
		
		try {
			PageInfo pageInfos = choujianServices.queryChouJianListPage(form);
			return ApiMessage.builder(true, pageInfos);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
}
