package com.junl.apps.model;
/**
 * 
 * @author dfj
 * @date 2016年8月18日上午9:22:16 
 * @description
 *
 */
public class CompanyPZModel {
	private String ids;
	private String name;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CompanyPZModel(String ids, String name) {
		super();
		this.ids = ids;
		this.name = name;
	}
	public CompanyPZModel() {
		super();
	}
	
}
