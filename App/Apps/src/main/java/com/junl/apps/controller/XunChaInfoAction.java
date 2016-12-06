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
import com.junl.apps.form.XunChaInfoForm;
import com.junl.apps.model.XunChaInfoXCModel;
import com.junl.apps.service.role.IRole;
import com.junl.apps.service.xunchainfo.IXunChaInfo;
import com.junl.frame.core.common.page.PageInfo;
import com.junl.frame.tools.string.StringUtils;

@Controller
@RequestMapping("/xunchainfo")
public class XunChaInfoAction {
	
	@Autowired
	private IXunChaInfo xunChaInfoServices;
	
	
	@Autowired
	private IRole roleServices;
	
	
	
	
	
	/**
	 * 巡查信息  	新增
	 * 请求地址：http://127.0.0.1:8006/Apps/xunchainfo/insertXunInfo.do
	 *  参数：
	 *  	ids						主键				（修改时必填）
     *		xunChaStartZHK			巡查开始桩号千米位	必填
     *		xunChaStartZHM			巡查开始桩号米位		必填
     *		xunChaEndZHK			巡查结束桩号千米位	必填
     *		xunChaEndZHM			巡查结束桩号米位		必填
     *		xiuBuBiaoZhi			修补损坏标识		必填
     *		wxmkId					维修模块id			必填
     *		binghaiOrQueXianType	病害或缺陷类型		必填
     *		binghaiOrQueXianMiaoShu	病害或缺陷描述		必填
     *		level					紧急程度			必填
     *		yuGuGongChengLiang		预估工程量			必填
     *		yuGuGongChengLiangDw	预估工程量单位		必填
     *		xunChaTime				巡查时间			必填
     *		remark					备注
     *		imgs					图片				
     *		xunChaUserId			巡查人id			必填
     *		xunChaTouId				巡查头部信息id		必填
     *		luXian					路线				必填
     *		zType					位置类型			必填
     *		wzName					位置名称			必填
     *		wzMiaoShu				位置描述			必填
     *		list:
     *				buJian			部件				必填
     *				num				数量				必填
     *				buJianId		部件ids			必填
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="insertXunInfo")
	public @ResponseBody Map<String, Object> insertXunInfo(
			@RequestBody XunChaInfoXCModel model) throws Exception {
		int res=-1;
		Map<String, Object> map=new HashMap<>();
		try {
			int zhs1=model.getXunChaStartZHK()*1000+model.getXunChaStartZHM();
			int zhe1=model.getXunChaEndZHK()*1000+model.getXunChaEndZHM();
			//判断桩号是否符合范围
			if (roleServices.judgeZHScope(roleServices.getZHFanWeibyUserId(model.getXunChaUserId()),zhs1,zhe1)) {
				if (StringUtils.isEmpty(model.getIds())) {
					res= xunChaInfoServices.insertXunInfo(model);
				}else{
					res= xunChaInfoServices.updateXunChaInfo(model);
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
	 * 请求地址：http://127.0.0.1:8006/Apps/xunchainfo/queryXunChaInfoListPage.do
	 *		参数：
	 *			pageNo			当前页码				必填
	 *			limit			限制查询的记录数			必填
	 *			sdate			巡查时间 （开始）
	 *			edate			巡查时间（结束）
	 *			xunChaInfoType	巡查类型
	 *			xunChaUserId	创建人				必填
	 *			notInTaskIds	不包括巡查信息ids（弹出框）
	 *			wxmkId			维修模块id
	 *			xunChaTouId		巡查信息所关联的巡查头ids	必填
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryXunChaInfoListPage")
	public @ResponseBody Map<String, Object> queryXunChaInfoListPage(
			@RequestBody XunChaInfoForm form) throws Exception {
		
		try {
			PageInfo pageInfos = xunChaInfoServices.queryXunChaInfoListPage(form);
			return ApiMessage.builder(true, pageInfos);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	/**根据巡查信息的ids获取维修项信息
	 * 请求地址：http://127.0.0.1:8006/Apps/xunchainfo/queryFzhlTable.do
	 * 参数：
	 *			ids			巡查信息的主键ids				必填
	 *			
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryFzhlTable")
	public @ResponseBody Map<String, Object> queryFzhlTable(
			@RequestBody XunChaInfoForm form) throws Exception {
		
		try {
			List<Map<String, Object>> list = xunChaInfoServices.queryFzhlTable(form.getIds());
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
}
