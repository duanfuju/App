package com.junl.apps.mapper;
import java.util.Map;

import com.junl.frame.core.BaseMapper;
/**
 * 
* @ClassName: AppMapper
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年8月23日 下午2:21:35
*
 */
public interface AppMapper extends BaseMapper<Object>{
	/**
	 * 新增
	 * @return
	 * @throws Exception
	 */
	public int insertApp(Map<String, Object> map) throws Exception;
	/**
	 * 下载最新的文件
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryNewestFile()throws Exception;
}
