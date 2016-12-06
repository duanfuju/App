package com.junl.apps.model;

/**
 * 位置表
 * @author LEON
 * @date 2016年8月17日 下午8:07:01
 * @description 
 *		TODO
 */
public class WeizhiPZModel {

	/**
	 * 
	 */
	private String ids;
	
	/**
	 * 路线id
	 */
	private String luXianId;
	
	/**
	 * 位置类型
	 */
	private String wzType;
	
	/**
	 * 位置名称：方向、互通枢纽、收费站、服务区、辅道
	 */
	private String wzName;
	
	/**
	 * 位置描述：车道、匝道、内外广场
	 */
	private String wzMiaoShu;
	
	/**
	 * 桩号K
	 */
	private String ZHK;
	
	/**
	 * 桩号M
	 */
	private String ZHM;
	
	/**
	 * 排序
	 */
	private String sort;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getLuXianId() {
		return luXianId;
	}

	public void setLuXianId(String luXianId) {
		this.luXianId = luXianId;
	}

	public String getWzType() {
		return wzType;
	}

	public void setWzType(String wzType) {
		this.wzType = wzType;
	}

	public String getWzName() {
		return wzName;
	}

	public void setWzName(String wzName) {
		this.wzName = wzName;
	}

	public String getWzMiaoShu() {
		return wzMiaoShu;
	}

	public void setWzMiaoShu(String wzMiaoShu) {
		this.wzMiaoShu = wzMiaoShu;
	}

	public String getZHK() {
		return ZHK;
	}

	public void setZHK(String zHK) {
		ZHK = zHK;
	}

	public String getZHM() {
		return ZHM;
	}

	public void setZHM(String zHM) {
		ZHM = zHM;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
