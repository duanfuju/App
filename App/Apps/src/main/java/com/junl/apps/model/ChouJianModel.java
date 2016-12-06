package com.junl.apps.model;

import java.sql.Timestamp;
/**
 * 
* @ClassName: ChouJianModel
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年8月26日 下午6:18:22
*
 */
public class ChouJianModel {
	private String ids;
	private String jiLingIds;
	private String byIds;
	private int state;
	private Timestamp samplingTime;
	private Timestamp createTime;
	private Timestamp acceptTime;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getJiLingIds() {
		return jiLingIds;
	}
	public void setJiLingIds(String jiLingIds) {
		this.jiLingIds = jiLingIds;
	}
	public String getByIds() {
		return byIds;
	}
	public void setByIds(String byIds) {
		this.byIds = byIds;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Timestamp getSamplingTime() {
		return samplingTime;
	}
	public void setSamplingTime(Timestamp samplingTime) {
		this.samplingTime = samplingTime;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Timestamp acceptTime) {
		this.acceptTime = acceptTime;
	}
	
	
}
