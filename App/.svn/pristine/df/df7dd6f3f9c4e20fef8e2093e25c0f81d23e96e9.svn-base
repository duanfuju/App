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
import com.junl.apps.form.LuMianForm;
import com.junl.apps.model.WXLuMianModel;
import com.junl.apps.service.lumian.ILuMian;
import com.junl.apps.service.role.IRole;
import com.junl.frame.core.common.page.PageInfo;
import com.junl.frame.tools.string.StringUtils;

@Controller
@RequestMapping("/lumian")
public class LuMianAction {
	
	@Autowired
	private ILuMian luMianServices;
	@Autowired
	private IRole roleServices;
	/** 路面		增加and修改
	 * 请求地址：http://127.0.0.1:8006/Apps/lumian/insertLuMian.do
	 * 参数：
	 * 		 ids					主键				（修改时必填）
	 *       weatherState			天气状况               		 必填
	 *       qiWen	           		 气温                     		 必填
	 *       startZHK	        	开始桩号千米位   		 必填
	 *       startZHM            	开始桩号米位        		必填
	 *       endZHK              	结束桩号千米位    		必填
	 *       endZHM	            	结束桩号米位        		必填
	 *       weiXiuStartTime	            维修开始时间       		必填
	 *       weiXiuEndTime	    	维修结束时间		必填
	 *       shiGongJiXie	   		 施工机械               		必填
	 *       weiXiuRenYuan			维修人员                		必填
	 *       anQuanYuan		    	现场专职安全员    		必填
	 *       fuZeRen		       	现场施工负责人    		必填
	 *       pingJia		       	质量评价                		必填
	 *       remark		        	备注
	 *       imgs		        	图片
	 *       taskInfoRelate			任务和巡查信息关联id  必填
	 *       lumianState		            路面状况           		必填
	 *       bingHaiWeiZhi			病害位置            		必填
	 *       bingHaiType		            病害类型            		必填
	 *       bingHaiName		            病害名称            		必填
	 *       binghaiLevel			病害级别            		必填
	 *       wjsxbCause		    	未及时修补原因      		必填
	 *       wxGongYi		    	维修工艺            		必填
	 *       xiuBuType		   		修补类型            		必填
	 *       xiuBuWeiZhi		            修补位置            		必填
	 *       xiuBuchang		    	表面修补尺寸-长     	必填
	 *       xiuBukuan		    	表面修补尺寸-宽     	必填
	 *       pingZhengDu		   	平整度              		必填
	 *       bhFenXiType		            病害原因分析类型    	必填
	 *       bhFenXi		       	病害原因分析        		必填
	 *       createUserId			创建人id          必填
	 *       luXian		       		 路线                		必填
	 *       wzType	            	位置类型            		必填
	 *       wzName		      		 位置名称            		必填
	 *       wzMiaoShu	        	位置描述            		必填
	 *       luBingType         	 路病类型            		必填
	 *       sunHuaiCauseType    	损坏原因类型        		必填
	 *       list:
	 *			chiCunChang			尺寸-长
	 *			chiCunKuan			尺寸-宽
	 *			shenDu				深度
	 *			xiuBuCaiLiao		修补材料
	 *			caiLiaoWenDu		施工材料温度	
	 *			cengType			层的类型(1为上面层，2为中面层，3为下面层，4为基层)
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="insertLuMian")
	public @ResponseBody Map<String, Object> insertLuMian(
			@RequestBody WXLuMianModel form) throws Exception {
		int res=-1;
		Map<String, Object> map=new HashMap<>();
		try {
			
			int zhs1=form.getStartZHK()*1000+form.getStartZHM();
			int zhe1=form.getEndZHK()*1000+form.getEndZHM();
			//判断桩号是否符合范围
			if (roleServices.judgeZHScope(roleServices.getZHFanWeibyUserId(form.getCreateUserId()),zhs1,zhe1)) {
				if (StringUtils.isEmpty(form.getIds())) {
					res= luMianServices.insertLuMian(form);
				}else{
					res=luMianServices.updateLuMian(form);
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
	 * 请求地址：http://127.0.0.1:8006/Apps/lumian/queryWXLuMianListPage.do
	 *		参数：
	 *			pageNo			当前页码				必填
	 *			limit			限制查询的记录数			必填
	 *			createUserId	当前用户				必填
	 *			weiXiuRenYuan	维修人员
	 *			luXian			路线
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryWXLuMianListPage")
	public @ResponseBody Map<String, Object> queryWXLuMianListPage(
			@RequestBody LuMianForm form) throws Exception {
		
		try {
			PageInfo pageInfos = luMianServices.queryWXLuMianListPage(form);
			return ApiMessage.builder(true, pageInfos);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	/**
	 * 请求地址：http://127.0.0.1:8006/Apps/lumian/queryWayTable.do
	 * 参数：
	 *			ids			路面的维修编号				必填
	 *			
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryWayTable")
	public @ResponseBody Map<String, Object> queryWayTable(
			@RequestBody LuMianForm form) throws Exception {
		
		try {
			List<Map<String, Object>> list = luMianServices.queryWayTable(form);
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
}
