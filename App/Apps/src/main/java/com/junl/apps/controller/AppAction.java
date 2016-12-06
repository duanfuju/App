package com.junl.apps.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.junl.apps.common.ApiMessage;
import com.junl.apps.form.LatAndLonForm;
import com.junl.apps.service.app.IApp;
import com.junl.apps.service.latandlon.ILatAndLon;

@Controller
@RequestMapping("/app")
public class AppAction {
	@Autowired
	private IApp appServices;
	
	@Autowired
	private ILatAndLon llServices;
	
	
	
	
	
	
	
	/**新增经纬度
	 * 请求地址：http://127.0.0.1:8006/Apps/app/insertLatAndLonCollect.do
	 *		参数：
	 *			baseZHK			桩号K				必填
	 *			baseZHM			桩号M				必填
	 *			baseJD			基础经度			必填
	 *			baseWD			基础纬度			必填
	 *			preJD			前一米经度			必填
	 *			preWD			前一米纬度			必填
	 *			sufJD			后一米			必填
	 *			sufWD			后一米			必填
	 *			lx				路线				必填
	 *			fx				方向				必填
	 *			weizhi			位置				必填
	 *			createUserId	创建人			必填
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="insertLatAndLonCollect")
	public @ResponseBody Map<String, Object> insertLatAndLonCollect(
			@RequestBody List<LatAndLonForm> form) throws Exception {
		try {
			Map<String, Object>  map=new HashMap<String, Object>();
			int res= llServices.insertLatAndLonCollect(form);
			map.put("state", res);
			return ApiMessage.builder(true, map);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	
	/**查询经纬度信息
	 * 请求地址：http://127.0.0.1:8006/Apps/app/queryPointInfo.do
	 *		参数：
	 *				无
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryPointInfo")
	public @ResponseBody Map<String, Object> queryPointInfo() throws Exception {
		try {
			List<Map<String, Object>>  map= llServices.queryPointInfo();
			return ApiMessage.builder(true, map);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	/**获取最新的文件
	 * 请求地址：http://127.0.0.1:8006/Apps/app/queryNewestFile.do
	 *		参数：
	 *				无
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryNewestFile")
	public @ResponseBody Map<String, Object> queryNewestFile() throws Exception {
		try {
			Map<String, Object>  map= appServices.queryNewestFile();
			return ApiMessage.builder(true, map);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiMessage.builder(false);
		}
	}
	
	
	
	/**
	 * 请求地址：http://127.0.0.1:8006/Apps/app/insertApp.do
	 *		参数：
	 *		返回：json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="insertApp")
	public String insertApp(
			@RequestParam("version") String version, 
			@RequestParam("file_upload") MultipartFile file,
			ModelMap model) throws Exception {
		try {
			 int res=appServices.insertApp(version,file);
			 if (res==1) {
				 model.put("msg", "上传文件成功");
			}
		} catch (Exception e) {
			model.put("msg", "上传文件失败");
		}
		return "uploadFile";
	}
}
