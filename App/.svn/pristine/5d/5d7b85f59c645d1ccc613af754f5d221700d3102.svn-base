package com.junl.apps.mapper;
import java.util.List;
import java.util.Map;

import com.junl.apps.model.WXYouWuModel;
import com.junl.frame.core.BaseMapper;
/**
 * 
* @ClassName: WXYouWuMapper
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年8月25日 下午1:52:52
*
 */
public interface WXYouWuMapper extends BaseMapper<Object>{
	
	
	
	
	
	
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
	 * 更新维修记录的状态（计量）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int updateStateAndCalcForEach(Map<String, Object> map) throws Exception;
	/**
	 * 获取油污列表
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryWXYouWuListPage(Map<String, Object> map) throws Exception;
	
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
	
	
	
	/**
	 * 新增
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertYouWu(WXYouWuModel model) throws Exception;
	/**
	 * 修改
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int updateYouWu(WXYouWuModel model) throws Exception;
}
