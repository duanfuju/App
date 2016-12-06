package com.junl.apps.mapper;
import java.util.List;
import java.util.Map;

import com.junl.apps.model.XunChaInfoRelateModel;
import com.junl.apps.model.XunChaInfoXCModel;
import com.junl.frame.core.BaseMapper;

public interface XunChaInfoMapper extends BaseMapper<XunChaInfoXCModel>{
	
	
	
	
	
	
	/**
	 * 部件新增
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertXunInfoFzhlRelate(XunChaInfoRelateModel model) throws Exception;
	
	
	/**
	 * 根据巡查信息的ids删除部件
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int deleteXunInfoFzhlRelateByXunChaInfoId(Map<String, Object> map) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 获取巡查信息列表
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryXunChaInfoListPage(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 * 根据巡查信息的ids获取维修项信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryFzhlTable(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 新增
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertXunInfo(XunChaInfoXCModel model) throws Exception;
	/**
	 * 修改
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int updateXunChaInfo(XunChaInfoXCModel model) throws Exception;
}