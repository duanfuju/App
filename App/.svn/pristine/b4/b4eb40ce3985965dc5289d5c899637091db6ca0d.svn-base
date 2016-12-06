package com.junl.apps.service.xunchatou;


import java.util.Map;

import com.junl.apps.form.XunChaTouForm;
import com.junl.apps.model.XunChaTouXCModel;
import com.junl.frame.core.common.page.PageInfo;

public interface IXunChaTou {
	/**
	 * 修改巡查登记的状态
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int updateXunChaTouState(Map<String, Object> map) throws Exception;
	/**
	 * 获取巡查头列表
	 * @return
	 * @throws Exception
	 */
	public PageInfo queryXunChaTouListPage(XunChaTouForm form) throws Exception;
	/**
	 * 根据ids获取巡查头信息
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryByIds(String ids) throws Exception;
	
	
	/**
	 * 新增
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertXunChaTou(XunChaTouXCModel model) throws Exception;
	
	/**
	 * 修改
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int updateXunChaTou(XunChaTouXCModel model) throws Exception;
	
}
