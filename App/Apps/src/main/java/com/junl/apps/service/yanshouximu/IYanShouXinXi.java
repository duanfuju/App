package com.junl.apps.service.yanshouximu;



import java.util.List;
import java.util.Map;



public interface IYanShouXinXi {
	
	/**
	 * 查询所有
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryAll() throws Exception;
}
