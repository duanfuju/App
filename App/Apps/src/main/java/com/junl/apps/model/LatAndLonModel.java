package com.junl.apps.model;

import java.sql.Timestamp;
/**
 * 
* @ClassName: LatAndLonModel
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年9月1日 下午4:40:27
*
 */
public class LatAndLonModel {
	private String ids;
	private String weizhi;
	private String fangxiang;
	private String luxian;
	private int zhk;
	private int zhm;
	private String lat;
	private String lon;
	private Timestamp createTime;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getWeizhi() {
		return weizhi;
	}
	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	public String getFangxiang() {
		return fangxiang;
	}
	public void setFangxiang(String fangxiang) {
		this.fangxiang = fangxiang;
	}
	public String getLuxian() {
		return luxian;
	}
	public void setLuxian(String luxian) {
		this.luxian = luxian;
	}
	public int getZhk() {
		return zhk;
	}
	public void setZhk(int zhk) {
		this.zhk = zhk;
	}
	public int getZhm() {
		return zhm;
	}
	public void setZhm(int zhm) {
		this.zhm = zhm;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
