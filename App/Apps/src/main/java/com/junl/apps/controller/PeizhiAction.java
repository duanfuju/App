package com.junl.apps.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junl.apps.common.ApiMessage;
import com.junl.apps.common.BaseController;
import com.junl.apps.form.PeizhiForm;
import com.junl.apps.model.LuxianPZModel;
import com.junl.apps.service.peizhi.IPeizhi;


@Controller
@RequestMapping("/pz")
public class PeizhiAction extends BaseController {

	@Autowired
	private IPeizhi peizhiService;
	
	
	
	/**
	 * app首页的存储过程获取说有的记录数
	 * 请求地址：http://127.0.0.1:8006/Apps/pz/queryProcGetAllCount.do
	 *		参数：
	 *			createUserId		创建人		必填
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryProcGetAllCount")
	public @ResponseBody Map<String, Object> queryProcGetAllCount(
			@RequestBody  PeizhiForm params) throws Exception {
	
		try {
			List<Map<String, Object>> list = peizhiService.queryProcGetAllCount(params.getCreateUserId());
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	/**
	 * 获取所有方向 
	 * 请求地址：http://127.0.0.1:8006/Apps/pz/queryAllFangXiang.do
	 *		参数：
	 *			无
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryAllFangXiang")
	public @ResponseBody Map<String, Object> queryAllFangXiang() throws Exception {
	
		try {
			List<Map<String, Object>> list = peizhiService.queryAllFangXiang();
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**根据类型查询选择信息表
	 * 请求地址：http://127.0.0.1:8006/Apps/pz/queryBingHaiIndexByWxmkId.do
	 *		参数：
	 *			ids  选择信息表的主键ids		必填
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryBingHaiIndexByWxmkId")
	public @ResponseBody Map<String, Object> queryBingHaiIndexByWxmkId(
				 @RequestBody PeizhiForm form) throws Exception {
		
		try {
			List<Map<String, Object>> list = peizhiService.queryBingHaiIndexByWxmkId(form.getIds());
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	/**根据类型查询选择信息表
	 * 请求地址：http://127.0.0.1:8006/Apps/pz/queryChooseInfoByType.do
	 *		参数：无
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryChooseInfoByType")
	public @ResponseBody Map<String, Object> queryChooseInfoByType() throws Exception {
		
		try {
			List<Map<String, Object>> list =  peizhiService.queryChooseInfoByType(2);
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	/**
	 * 获取所有病害类型
	 * 请求地址：http://127.0.0.1:8006/Apps/pz/queryAllBingHaiIndex.do
	 * 		参数：无
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryAllBingHaiIndex")
	public @ResponseBody Map<String, Object> queryAllBingHaiIndex() throws Exception {
		
		try {
			List<Map<String, Object>> list =  peizhiService.queryAllBingHaiIndex();
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	
	
	
	
	/**查询所有的防撞护栏部件
	 * 请求地址：http://127.0.0.1:8006/Apps/pz/queryFzhlBuJian.do
	 *		参数：无
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryFzhlBuJian")
	public @ResponseBody Map<String, Object> queryFzhlBuJian() throws Exception {
		
		try {
			List<Map<String, Object>> list =  peizhiService.queryFzhlBuJian();
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	/**根据用户获取路段
	 * 请求地址：http://127.0.0.1:8006/Apps/pz/findLuXianByUserId.do
	 *		参数：userIds	用户编号 	必填
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findLuXianByUserId")
	public @ResponseBody Map<String, Object> queryYangHuLuDuanIdByUserId(
			@RequestBody PeizhiForm form) throws Exception {
		
		try {
			List<Map<String, Object>> list =  peizhiService.queryYangHuLuDuanIdByUserId(form.getUserIds());
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年8月17日 下午7:43:15
	 * @description 
	 *		查询所有路线配置列表
	 *		请求地址：http://127.0.0.1:8080/Apps/pz/findAllLuxianPeizhi.do
	 *		参数：无
	 *		返回：json
	 * @return
	 * @throws Exception
	 * 		
	 *
	 */
	@RequestMapping("/findAllLuxianPeizhi")
	public @ResponseBody Map<String, Object> findAllLuxianPeizhi() throws Exception {
		
		try {
			List<LuxianPZModel> list = peizhiService.findAllLuxianPz();
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	/**根据类型查询选择信息表
	 * 请求地址：http://127.0.0.1:8006/Apps/pz/queryChooseInfoByType1.do
	 *		参数：无
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryChooseInfoByType1")
	public @ResponseBody Map<String, Object> queryChooseInfoByType1() throws Exception {
		
		try {
			List<Map<String, Object>> list =  peizhiService.queryChooseInfoByType(1);
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年8月17日 下午7:43:15
	 * @description 
	 *		查询所有路线配置列表
	 *		请求地址：http://127.0.0.1:8006/Apps/pz/queryAllWeiZhi.do
	 *		参数：无
	 *		返回：json
	 * @return
	 * @throws Exception
	 * 		
	 *
	 */
	@RequestMapping("/queryAllWeiZhi")
	public @ResponseBody Map<String, Object> queryAllWeiZhi() throws Exception {
		
		try {
			List<Map<String, Object>> list = peizhiService.queryAllWeiZhi();
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年8月17日 下午8:36:37
	 * @description 
	 *		根据路线id获取位置类型
	 *		请求地址：http://127.0.0.1:8080/Apps/pz/findWZType.do
	 *		参数：
	 *			luxianId: 路线id  必填
	 *		返回：json
	 * @param id
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/findWZType")
	public @ResponseBody Map<String, Object> findWZType(
				 @RequestBody PeizhiForm form) throws Exception {
		
		try {
			List<Map<String, Object>> list = peizhiService.findWZType(form.getLuxianId());
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	/**
	 * 
	 * @author LEON
	 * @date 2016年8月17日 下午8:47:25
	 * @description 
	 *		根据位置类型id和路线id获取方向、互通、收费站、服务区
	 *		请求地址：http://127.0.0.1:8080/Apps/pz/findPoint.do
	 *		参数：
	 *			luxianId 路线id  必填
	 *			weizhiId 位置id  必填
	 *		返回：json
	 * @param weizhiId
	 * @param luxianId
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("findPoint")
	public @ResponseBody Map<String, Object> findPoint(
			@RequestBody PeizhiForm form) throws Exception {
		
		try {
			List<Map<String, Object>> list = peizhiService.findPoint(form.getWeizhiId(), form.getLuxianId());
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	/**
	 * 根据位置类型id和路线id和方向、互通、收费站、服务区获取位置描述
	 *		请求地址：http://127.0.0.1:8080/Apps/pz/findWzMiaoShu.do
	 *		参数：
	 *			luxianId 路线id  					必填
	 *			weizhiId 位置id  					必填
	 *			wzName 方向、互通、收费站、服务区  	必填
	 *		返回：json
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findWzMiaoShu")
	public @ResponseBody Map<String, Object> findWzMiaoShu(
			@RequestBody PeizhiForm form) throws Exception {
		
		try {
			List<Map<String, Object>> list = peizhiService.findWzMiaoShu(form.getWeizhiId(), form.getLuxianId(),form.getWzName());
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	

	/**
	 * 查询维修单位
	 * 	请求地址：http://127.0.0.1:8006/Apps/pz/findAllByCenter.do
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAllByCenter")
	public @ResponseBody Map<String, Object> findAllByCenter() throws Exception {
		try {
			List<Map<String, Object>> list = peizhiService.findAllByCenter();
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	/**
	 * 查询管理单位
	 * 	请求地址：http://127.0.0.1:8006/Apps/pz/findAllCompany.do
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAllCompany")
	public @ResponseBody Map<String, Object> findAllCompany() throws Exception {
		try {
			List<Map<String, Object>> list = peizhiService.findAllCompany();
			return ApiMessage.builder(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
}
