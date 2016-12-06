package com.junl.apps.mapper;
import java.util.List;
import java.util.Map;

import com.junl.apps.form.FzhlForm;
import com.junl.frame.core.BaseMapper;
/**
 * 
* @ClassName: WXFzhlMapper
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年8月29日 下午5:38:07
*
 */
public interface WXFzhlMapper extends BaseMapper<Object>{
	
	
	
	/**
	 * 解除维修记录和报验的联系
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int updateWithBaoYanReleaseContact(Map<String, Object> params)throws Exception;
	/**
	 * 建立维修记录和报验的联系
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int updateWithBaoYanEstablishContact(Map<String, Object> params)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 抽检管理中的验收是否完成 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int updateWithYanShou(Map<String, Object> map) throws Exception;
	/**
	 * 抽检管理
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryForEachChouJianGuanLi(Map<String, Object> map) throws Exception;
	/**
	 * 获取防撞护栏列表
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryWXFzhlListPage(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 更新维修记录的状态（计量）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int updateStateAndCalcForEach(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据防撞护栏的ids获取防撞护栏维修部件的数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryFzhlTable(Map<String, Object> map) throws Exception;

	
	/**
	 * 修改
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public int updateFzhl(FzhlForm form) throws Exception;
	/**
	 * 部件的删除
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int deleteFzhlBuJian(Map<String, Object> params) throws Exception;
	/**
	 * 新增
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int insertFzhl(Map<String, Object> params) throws Exception;
	
	/**
	 * 新增部件
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int insertFzhlBuJian(Map<String, Object> params) throws Exception;
	/**
	 * 循环查询各个维修记录表
	 * 首先根据报验的主键ids到报验外键表获取任务（任务表的外键表）的ids
	 * 根据获取到的任务（任务表的外键表）的ids获取维修表的记录数 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryForEach(Map<String, Object> map) throws Exception;
	/**通过（抽检）
	 * 循环查询各个维修记录表
	 * 首先根据报验的主键ids到报验外键表获取任务（任务表的外键表）的ids
	 * 根据获取到的任务（任务表的外键表）的ids获取维修表的记录数 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryForEachAccept(Map<String, Object> map) throws Exception;
	/**未通过（抽检）
	 * 循环查询各个维修记录表
	 * 首先根据报验的主键ids到报验外键表获取任务（任务表的外键表）的ids
	 * 根据获取到的任务（任务表的外键表）的ids获取维修表的记录数 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryForEachNoAccept(Map<String, Object> map) throws Exception;
}
