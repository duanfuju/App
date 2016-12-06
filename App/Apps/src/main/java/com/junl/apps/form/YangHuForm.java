package com.junl.apps.form;


import com.junl.apps.common.BaseForm;

/**
 * 
 * @author dfj
 * @date 2016年8月18日下午7:48:33 
 * @description
 *
 */
public class YangHuForm extends BaseForm {
	/**
	 * 方向
	 */
	private String wzName;
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

	public String getWzName() {
		return wzName;
	}

	public void setWzName(String wzName) {
		this.wzName = wzName;
	}

	public YangHuForm(String wzName) {
		super();
		this.wzName = wzName;
	}

	public YangHuForm() {
		super();
	}
	
	
}
