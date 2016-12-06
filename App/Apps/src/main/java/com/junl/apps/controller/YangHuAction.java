package com.junl.apps.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junl.apps.common.ApiMessage;
import com.junl.apps.form.YangHuForm;
import com.junl.apps.model.WXYangHuModel;
import com.junl.apps.service.role.IRole;
import com.junl.apps.service.yanghu.IYangHu;
import com.junl.frame.core.common.page.PageInfo;
import com.junl.frame.tools.string.StringUtils;

@Controller
@RequestMapping("/yanghu")
public class YangHuAction {
	
	
	
	
	@Autowired
	private IYangHu yangHuServices;
	
	@Autowired
	private IRole roleServices;
	/** 养护		增加and修改
	 * 请求地址：http://127.0.0.1:8006/Apps/yanghu/insertYangHu.do
	 * 参数：
	 * 		 ids					主键				（修改时必填）
	 *       weatherState			天气状况			必填
	 *       qiWen					气温				必填
	 *       startZHK				开始桩号千米位		必填
	 *       startZHM				开始桩号米位		必填
	 *       endZHK					结束桩号千米位		必填
	 *       endZHM					结束桩号米位		必填
	 *       weiXiuTime				维修时间			必填
	 *       yangHuProject			养护项目			必填
	 *       sunHuaiMiaoShu			损坏现状描述及原因分析    必填
	 *       shiGongJiXie			施工机械			必填
	 *       weiXiuRenYuan			维修人员			必填
	 *       anQuanYuan				现场专职安全员		必填
	 *       fuZeRen				现场施工负责人		必填
	 *       pingJia				维修质量评价		必填
	 *       remark					备注
	 *       imgs					图片
	 *       taskInfoRelate			任务和巡查信息关联id	必填
	 *       createUserId			创建人id			必填
	 *       luXian					路线				必填
	 *       wzType					位置类型			必填
	 *       wzName					位置名称			必填
	 *       wzMiaoShu				位置描述			必填
	 *       danWei					单位				必填
	 *       num					数量				必填
	 *       diseaseType			路病类型			必填
	 *       foundTime				发现时间			必填
	 *       sunHuaiCauseType		损坏原因类型		必填
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="insertYangHu")
	public @ResponseBody Map<String, Object> insertYangHu(
			@RequestBody WXYangHuModel model) throws Exception {
		Map<String, Object> map=new HashMap<>();
		int res=-1;
		try {
			int zhs1=model.getStartZHK()*1000+model.getStartZHM();
			int zhe1=model.getEndZHK()*1000+model.getEndZHM();
			//判断桩号是否符合范围
			if (roleServices.judgeZHScope(roleServices.getZHFanWeibyUserId(model.getCreateUserId()),zhs1,zhe1)) {
				if (StringUtils.isEmpty(model.getIds())) {
					res= yangHuServices.insertYangHu(model);
				}else{
					res= yangHuServices.updateYangHu(model);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 请求地址：http://127.0.0.1:8006/Apps/yanghu/queryWXYangHuListPage.do
	 *		参数：
	 *			pageNo			当前页码				必填
	 *			limit			限制查询的记录数			必填
	 *			createUserId	当前用户				必填
	 *			wzName			方向		
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryWXYangHuListPage")
	public @ResponseBody Map<String, Object> queryWXYangHuListPage(
			@RequestBody YangHuForm form) throws Exception {
		
		try {
			PageInfo pageInfos = yangHuServices.queryWXYangHuListPage(form);
			return ApiMessage.builder(true, pageInfos);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
}
