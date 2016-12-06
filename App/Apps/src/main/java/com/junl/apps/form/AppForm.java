package com.junl.apps.form;

import java.sql.Timestamp;

import com.junl.apps.common.BaseForm;


public class AppForm extends BaseForm {
	
	private String ids;
	private String version;
	private String realName;
	private String fileName;
	private String showPath;
	private String realPath;
	private Timestamp createTime;
	private String createPeople;
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getShowPath() {
		return showPath;
	}
	public void setShowPath(String showPath) {
		this.showPath = showPath;
	}
	public String getRealPath() {
		return realPath;
	}
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getCreatePeople() {
		return createPeople;
	}
	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}
	
	
	
}
