package com.junl.apps.service.choujian;


import java.util.List;
import java.util.Map;

import com.junl.apps.form.ChouJianForm;
import com.junl.apps.model.ChouJianModel;
import com.junl.frame.core.common.page.PageInfo;
/**
 * 
 * @author dfj
 * @date 2016年8月19日下午2:54:30 
 * @description
 *
 */
public interface IChouJian {
	
	/**
	 * 新增抽检关系
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int insertChouJianRelate(Map<String , Object> map) throws Exception;
	/**
	 * 修改抽检的状态
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int updateChouJianState(ChouJianModel model) throws Exception;
	/**
	 *  抽检管理中的验收是否完成 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int updateWithYanShou(ChouJianModel model) throws Exception;
	/**
	 * 新增
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertChouJian(ChouJianModel model) throws Exception;
	/**
	 * 获取抽检列表
	 * @return
	 * @throws Exception
	 */
	public PageInfo queryChouJianListPage(ChouJianForm form) throws Exception;
	/**
	 * 抽检管理
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryForEachChouJianGuanLi(ChouJianForm form) throws Exception;
	/**
	 * 抽检管理
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryForEachChouJianGuanLi(Map<String, Object> map) throws Exception;
	
}
