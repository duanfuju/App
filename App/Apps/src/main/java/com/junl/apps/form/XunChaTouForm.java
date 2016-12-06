package com.junl.apps.form;

import java.util.Date;

import com.junl.apps.common.BaseForm;

/**
 * 
 * @author dfj
 * @date 2016年8月18日下午1:57:20
 * @description
 *
 */
public class XunChaTouForm extends BaseForm {
	
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
	private String createUserId;

	/**
	 * 排序列
	 */
	private String sortName;

	/**
	 * 排序类型 desc / asc
	 */
	private String sortType = "desc";
	/**
	 * 主键
	 */
	private String ids;
	/**
	 * 巡查信息所关联的巡查头ids
	 */
	private String xunChaTouId;
	
	
	
	
	public String getXunChaTouId() {
		return xunChaTouId;
	}

	public void setXunChaTouId(String xunChaTouId) {
		this.xunChaTouId = xunChaTouId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
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

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public XunChaTouForm() {
		super();
	}
}
