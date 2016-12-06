package com.junl.apps.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junl.apps.common.ApiMessage;
import com.junl.apps.form.XunChaTouForm;
import com.junl.apps.model.XunChaTouXCModel;
import com.junl.apps.service.role.IRole;
import com.junl.apps.service.xunchatou.IXunChaTou;
import com.junl.frame.core.common.page.PageInfo;
import com.junl.frame.tools.string.StringUtils;

@Controller
@RequestMapping("/xunchatou")
public class XunChaTouAction {
	
	@Autowired
	private IXunChaTou xunChaTouServices;
	
	@Autowired
	private IRole roleServices;
	
	
	/** 巡查登记		增加and修改
	 * 请求地址：http://127.0.0.1:8006/Apps/xunchatou/insertXunCha.do
	 * 参数：
	 * 		ids					主键				（修改时必填）
	 * 		guanLiDanWei		管理单位			必填
	 * 		xunChaStartTime		巡查开始时间		必填
	 * 		xunChaEndTime		巡查结束时间		必填
	 * 		weatherState		天气状况			必填
	 * 		xunChaType			巡查类型			必填
	 * 		xunChaFangXiang1	巡查方向1			必填
	 * 		xunChaStartZHK1		巡查开始桩号千米位1	必填
	 * 		xunChaStartZHM1		巡查开始桩号米位1		必填
	 * 		xunChaEndZHK1		巡查结束桩号千米位1	必填
	 * 		xunChaEndZHM1		巡查结束桩号米位1		必填
	 * 		xunChaFangXiang2	巡查方向2			必填
	 * 		xunChaStartZHK2		巡查开始桩号千米位2	必填
	 * 		xunChaStartZHM2		巡查开始桩号米位2		必填
	 * 		xunChaEndZHK2		巡查结束桩号千米位2	必填
	 * 		xunChaEndZHM2		巡查结束桩号米位2		必填
	 * 		luXianId			路线id			必填
	 * 		xunChaLiCheng		巡查里程			必填
	 * 		remark				备注信息	
	 * 		createUserId		创建人id			必填
	 * 		luXianId			路线编号			必填
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="insertXunCha")
	public @ResponseBody Map<String, Object> insertXunCha(
			@RequestBody XunChaTouXCModel model) throws Exception {
		Map<String, Object> map=new HashMap<>();
		int res=-1;
		try {
			int zhs1=model.getXunChaStartZHK1()*1000+model.getXunChaStartZHM1();
			int zhe1=model.getXunChaEndZHK1()*1000+model.getXunChaEndZHM1();
			int zhs2=model.getXunChaStartZHK2()*1000+model.getXunChaStartZHM2();
			int zhe2=model.getXunChaEndZHK2()*1000+model.getXunChaEndZHM2();
			//判断桩号是否符合范围
			if (roleServices.judgeZHScope(roleServices.getZHFanWeibyUserId(model.getCreateUserId()),zhs1,zhe1)
					&&roleServices.judgeZHScope(roleServices.getZHFanWeibyUserId(model.getCreateUserId()),zhs2,zhe2)) {
				if (StringUtils.isEmpty(model.getIds())) {
					res= xunChaTouServices.insertXunChaTou(model);
				}else{
					res= xunChaTouServices.updateXunChaTou(model);
				}
				map.put("state", res);
			}else{
				map.put("state", -1);
				map.put("msg", "输入的桩号不在负责范围内");
			}
			return ApiMessage.builder(true, map);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**默认列表
	 * 请求地址：http://127.0.0.1:8006/Apps/xunchatou/queryXunChaTouListPage.do
	 *		参数：
	 *			pageNo			当前页码				必填
	 *			limit			限制查询的记录数		必填
	 *			xunChaType		巡查类型
	 *			sdate			巡查开始时间
	 *			edate			巡查结束时间
	 *			createUserId	巡查人				必填
	 *			sort			是否排序
	 *			sortName		排序列
	 *			sortType 		排序类型   desc / asc
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryXunChaTouListPage")
	public @ResponseBody Map<String, Object> queryXunChaTouListPage(
			@RequestBody XunChaTouForm form) throws Exception {
		
		try {
			PageInfo pageInfos = xunChaTouServices.queryXunChaTouListPage(form);
			return ApiMessage.builder(true, pageInfos);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	/**根据主键获取巡查登记
	 * 请求地址：http://127.0.0.1:8006/Apps/xunchatou/queryByIds.do
	 *		参数：
	 *			ids			主键				必填
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryByIds")
	public @ResponseBody Map<String, Object> queryByIds(
			@RequestBody XunChaTouForm form) throws Exception {
		
		try {
			Map<String, Object> map = xunChaTouServices.queryByIds(form.getIds());
			return ApiMessage.builder(true, map);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
}
