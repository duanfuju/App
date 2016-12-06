package com.junl.apps.service.role;



import java.util.List;
import java.util.Map;


/**
 * 
* @ClassName: IApp
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年8月23日 下午2:25:27
*
 */
public interface IRole {
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
	public List<Map<String, Object>> queryStartZHAndEndZH(Map<String, Object> map) throws Exception;
	/**
	 *  根据用户获取养护路段的sql
	 * @param userId
	 * @param startK
	 * @param startM
	 * @return
	 * @throws Exception
	 */
	public String getZHbyUserId(String userId, String startK, String startM)throws Exception;
	
	/**
	 * 判断输入的桩号是否符合范围
	 * @param list
	 * @param startZh
	 * @param endZh
	 * @return
	 * @throws Exception
	 */
	public boolean judgeZHScope(List<Map<String, Integer>> list,int startZh,int endZh)throws Exception;
	
	/**
	 * 根据用户的ids获取自身所在桩号范围
	 * @param userId
	 * @param startK
	 * @param startM
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Integer>> getZHFanWeibyUserId(String userId)throws Exception;
}
