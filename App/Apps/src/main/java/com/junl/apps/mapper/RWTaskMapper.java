package com.junl.apps.mapper;
import java.util.List;
import java.util.Map;

import com.junl.frame.core.BaseMapper;

public interface RWTaskMapper extends BaseMapper<Object>{
	
	/**
	 * 根据子任务的ids获取任务的信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryRWByTaskInfoRelate(Map<String, Object> map) throws Exception;
	/**
	 * 更新任务的状态
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int updateTask(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 * 获取任务列表
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryRWTaskListPage(Map<String, Object> map) throws Exception;
}
