package com.junl.apps.common;

import com.junl.frame.core.common.page.PageInfo;

public  class PageInfoSetCondition {
	/**
	 * 设置分页的条件
	 * @param pageInfo
	 * @param column
	 * @param type
	 */
	public static void SetCondition (PageInfo pageInfo, String column, String type) {
		pageInfo.setSort(true);
		pageInfo.setSortName(column);
		pageInfo.setSortType(type);
	}
}
