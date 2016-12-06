package com.junl.apps.form;


import com.junl.apps.common.BaseForm;

/**
 * 
 * @author dfj
 * @date 2016年8月18日下午7:48:33 
 * @description
 *
 */
public class YouWuForm extends BaseForm {
	/**
	 * 天气状态
	 */
	private String weatherState;
	/**
	 * 路线
	 */
	private String luXian;
	/**
	 * 当前用户
	 */
	private String createUserId;
	
	
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getWeatherState() {
		return weatherState;
	}
	public void setWeatherState(String weatherState) {
		this.weatherState = weatherState;
	}
	public String getLuXian() {
		return luXian;
	}
	public void setLuXian(String luXian) {
		this.luXian = luXian;
	}
	
	
	
}
