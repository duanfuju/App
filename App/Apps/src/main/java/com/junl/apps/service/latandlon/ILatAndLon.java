package com.junl.apps.service.latandlon;




import java.util.List;
import java.util.Map;

import com.junl.apps.form.LatAndLonForm;


/**
 * 
* @ClassName: ILatAndLon
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年9月1日 下午4:46:26
*
 */
public interface ILatAndLon {
	/**
	 * 新增
	 * @return
	 * @throws Exception
	 */
	public int insertLatAndLonCollect(List<LatAndLonForm> form) throws Exception;
	
	/**
	 * 查询经纬度
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryPointInfo() throws Exception;
}
