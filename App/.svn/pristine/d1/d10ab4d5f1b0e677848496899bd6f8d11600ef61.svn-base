package com.junl.frame.core.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author chenmaolong
 * @date 2016年3月23日 下午4:13:32
 * @description 
 *		分页组件
 */

public class PageInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9068510960970118590L;
	/**
	 * 当前页码
	 */
	private int pageNo=1;
	
	/**
	 * 每页记录数
	 */
	private int pageCount=10;
	
	/**
	 * 总页数
	 */
	private int totalPage;
	
	/**
	 * 总记录数
	 */
	private int totalCount;
	
	/**
	 * 限制查询的记录数
	 */	
	private int limit;
	
	/**
	 * 每页开始rownum
	 */
	private int start;
	
	/**
	 * 总记录数
	 */
	private int totalResult;
	
	/**
	 * 排序 默认false
	 */
	private boolean sort = false;
	
	/**
	 * 排序列
	 */
	private String sortName;
	
	/**
	 * 排序类型   desc / asc
	 */
	private String sortType = "desc";
	
	
	/**
	 * 查询结果
	 */
	@SuppressWarnings("rawtypes")
	private List results = new ArrayList<Object>();

	public PageInfo(){
		
	}
	public PageInfo(int pageNo,int pageCount){
		//前台是否传每页显示的数量
		if(pageNo != 0){
			this.pageNo = pageNo;
		}
		if(pageCount != 0){
			this.pageCount = pageCount;
		}
		this.start = this.pageCount * (this.pageNo - 1);
		this.limit = this.pageCount;
	}
	
	public void initParam(){
		this.totalCount = this.totalResult;
		if(this.totalResult % this.pageCount > 0 ){
			this.totalPage = this.totalResult / this.pageCount +1 ;
		}else{
			this.totalPage = this.totalResult / this.pageCount;
		}
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	@SuppressWarnings("rawtypes")
	public List getResults() {
		return results;
	}
	@SuppressWarnings("rawtypes")
	public void setResults(List results) {
		this.results = results;
	}
	public boolean isSort() {
		return sort;
	}
	public void setSort(boolean sort) {
		this.sort = sort;
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
}
