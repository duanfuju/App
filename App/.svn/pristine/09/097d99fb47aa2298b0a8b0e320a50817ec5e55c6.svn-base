package com.junl.apps.service.baoyan;


import java.util.List;
import java.util.Map;

import com.junl.apps.form.BaoYanForm;
import com.junl.apps.model.BaoYanModel;
import com.junl.apps.model.BaoYanRelateModel;
import com.junl.frame.core.common.page.PageInfo;
/**
 * 
 * @author dfj
 * @date 2016年8月19日下午2:04:58 
 * @description
 *
 */
public interface IBaoYan {
	
	
	
	
	/**
	 * 根据报验的主键获取维修记录
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryWeiXiuViewByBaoyanId(String baoyanId) throws Exception;
	
	
	
	
	
	
	/**
	 * 查询需要维修报验的维修记录
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryWeiXiuView() throws Exception;
	/**
	 * 根据报验的ids修改状态
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int updateBaoYanState(Map<String, Object> map) throws Exception;
	/**
	 * 根据报验主键获取任务的数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryTaskBaoYanIds(String byIds) throws Exception;
	/**
	 * 新增关联表
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertBaoYanRelate(BaoYanRelateModel model) throws Exception;
	/**
	 * 删除关联表
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int deleteBaoYanRelate(String byIds) throws Exception;
	/**
	 * 新增
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertBaoYan(BaoYanModel model) throws Exception;
	/**
	 * 修改
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int updateBaoYan(BaoYanModel model) throws Exception;
	/**
	 * 获取当前需要新增的任务单编号
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryTaskNoInThisMonth() throws Exception;
	/**
	 * 获取报验列表
	 * @return
	 * @throws Exception
	 */
	public PageInfo queryBaoYanListPage(BaoYanForm form) throws Exception;
}
