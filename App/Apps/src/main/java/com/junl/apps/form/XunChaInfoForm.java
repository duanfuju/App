package com.junl.apps.form;

import java.util.Date;

import com.junl.apps.common.BaseForm;

/**
 * 
 * @author dfj
 * @date 2016年8月18日下午5:44:39 
 * @description
 *
 */
public class XunChaInfoForm extends BaseForm {
	/**
	 * 巡查类型
	 */
	private String xunChaType;
	/**
	 * 巡查开始时间
	 */
	private Date sdate;
	/**
	 * 巡查结束时间
	 */
	private Date edate;
	/**
	 * 巡查人
	 */
	private String xunChaUserId;
	/**
	 * 不包含的巡查细信息的ids
	 */
	private String notInTaskIds;
	/**
	 * 维修模块id
	 */
	private String wxmkId;
	/**
	 * 巡查头关联ids
	 */
	private String xunChaTouId;
	/**
	 * 主键
	 */
	private String ids;
	
	
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getXunChaTouId() {
		return xunChaTouId;
	}
	public void setXunChaTouId(String xunChaTouId) {
		this.xunChaTouId = xunChaTouId;
	}
	public String getWxmkId() {
		return wxmkId;
	}
	public void setWxmkId(String wxmkId) {
		this.wxmkId = wxmkId;
	}
	public String getXunChaType() {
		return xunChaType;
	}
	public void setXunChaType(String xunChaType) {
		this.xunChaType = xunChaType;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public String getXunChaUserId() {
		return xunChaUserId;
	}
	public void setXunChaUserId(String xunChaUserId) {
		this.xunChaUserId = xunChaUserId;
	}
	
	public String getNotInTaskIds() {
		return notInTaskIds;
	}
	public void setNotInTaskIds(String notInTaskIds) {
		this.notInTaskIds = notInTaskIds;
	}
	
	
}
