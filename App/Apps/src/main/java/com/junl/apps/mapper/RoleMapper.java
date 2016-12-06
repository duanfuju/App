package com.junl.apps.mapper;
import java.util.List;
import java.util.Map;

import com.junl.frame.core.BaseMapper;
/**
 * 
* @ClassName: RoleMapper
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年9月20日 下午6:17:19
*
 */
public interface RoleMapper extends BaseMapper<Object>{
	/**
	 * 根据用户ids获取养护路段的ids
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object>  queryYangHuLuDuanId(Map<String, Object> map) throws Exception;
	/**
	 * 根据养护路段查询桩号
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>>  queryStartZHAndEndZH(Map<String, Object> map) throws Exception;
	
}
