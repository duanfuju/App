package com.junl.apps.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author LEON
 * @date 2016年8月17日 下午7:24:56
 * @description 
 *		手机端调用接口json封装输出
 */
public class ApiMessage {

	/**
	 * 
	 * @author LEON
	 * @date 2016年8月17日 下午7:36:55
	 * @description 
	 *		封装输出参数
	 *		json格式：
	 *			{
	 *				status: 0或者1,
	 *				result: object / list,
	 *				message: ""
	 *			}
	 * @param success 必填
	 * @param result 结果  可有可无
	 * @param mssage 信息  可有可无
	 * @return
	 *
	 */
	public static Map<String, Object> builder(boolean success, Object result, String mssage) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", success ? Consts.API_SUCCESS : Consts.API_ERROR);
		resultMap.put("result", result);
		resultMap.put("message", mssage);
		
		return resultMap;
	}
	
	
	public static Map<String, Object> builder(boolean success, Object result) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", success ? Consts.API_SUCCESS : Consts.API_ERROR);
		resultMap.put("result", result);
		
		return resultMap;
	}
	
	public static Map<String, Object> builder(boolean success) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", success ? Consts.API_SUCCESS : Consts.API_ERROR);
		
		return resultMap;
	}

	
}
