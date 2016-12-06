package com.junl.apps.service.rwtask;


import java.util.Map;

import com.junl.apps.form.RWTaskForm;
import com.junl.frame.core.common.page.PageInfo;

public interface IRwTask {
	/**
	 * 根据子任务的ids获取任务的信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryRWByTaskInfoRelate(String taskInfoRelate) throws Exception;
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
	public PageInfo queryRWTaskListPage(RWTaskForm form) throws Exception;
}
