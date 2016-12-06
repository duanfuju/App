package com.junl.frame.core;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @class BaseMapper
 * @author LEON
 * @date 2015年7月13日 下午9:40:35
 * @description
 *		基本数据库的增删改查
 *
 * @param <T>
 */
public interface BaseMapper<T> {
	/**
	 * 
	 * @method queryObject
	 * @author LEON
	 * @date 2015年7月13日 下午9:34:10
	 * @description
	 *		分页查询数据
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<T> queryListPage(Map<String, Object> params)
			throws SQLException;
	/**
	 * 
	 * @method queryObject
	 * @author LEON
	 * @date 2015年7月13日 下午9:34:10
	 * @description
	 *		根据单个参数查询对象
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public T queryObject(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * 
	 * @method queryListPage
	 * @author LEON
	 * @date 2015年7月13日 下午9:36:45
	 * @description
	 *		根据参数查询多条记录(不带分页)
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<T> query(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * 
	 * @method insert
	 * @author LEON
	 * @date 2015年7月13日 下午9:34:57
	 * @description
	 *		插入对象
	 *
	 * @param params 对象实体
	 * @throws SQLException
	 */
	public void insert(T params) throws SQLException;
	
	/**
	 * 
	 * @method delete
	 * @author LEON
	 * @date 2015年7月13日 下午9:35:22
	 * @description
	 *		根据参数删除对象
	 *
	 * @param params
	 * @throws SQLException
	 */
	public void delete(Map<String, Object> params) throws SQLException;
	
	/**
	 * 
	 * @method update
	 * @author LEON
	 * @date 2015年7月13日 下午9:35:46
	 * @description
	 *		修改对象
	 *
	 * @param params 对象实体
	 * @throws SQLException
	 */
	public void update(T params) throws SQLException;
	
}
