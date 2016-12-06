package com.junl.apps.service.peizhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junl.apps.mapper.PeizhiMapper;
import com.junl.apps.model.LuxianPZModel;

@Service
public class PeizhiImpl implements IPeizhi {
	
	@Autowired
	private PeizhiMapper mapper;

	
	
	
	
	@Override
	public List<Map<String, Object>> queryUserRole(String[] ids) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> params =new HashMap<>();
		params.put("ids", ids);
		list=mapper.queryUserRole(params);
		return list;
	}   
	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryYangHuLuDuanIdByUserId(java.lang.String)
	 */
	public List<Map<String, Object>> queryYangHuLuDuanIdByUserId(String userId) throws Exception {
		
		List<Map<String, Object>> result= new ArrayList<Map<String,Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userIds", userId);
		//根据用户的ids获取所需的养护路段的ids集合
		Map<String, Object> mapYangHuLuDuanId=mapper.queryYangHuLuDuanIdByUserId(params);
		String YangHuLuDuanId=mapYangHuLuDuanId.get("yangHuLuDuanId").toString();
		//切割用户信息表中养护路段的ids集合
		String[] yhld_s=YangHuLuDuanId.split(",");
		//根据用户信息表中的养护路段的ids获取养护路段信息
		for (int i = 0; i < yhld_s.length; i++) {
			String yhld_str=yhld_s[i];
			Map<String, Object> mapLuXianId = queryLuXianIdByYangHuLuDuanId(yhld_str);
			//根据养护路段信息中的路线ids获取路线的信息
			Map<String, Object> map=queryLuXianByluXianIds(mapLuXianId.get("luXianId").toString());
			result.add(map);
		}
		return result;
	}
	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryLuXianIdByYangHuLuDuanId(java.lang.String)
	 */
	public Map<String, Object> queryLuXianIdByYangHuLuDuanId(String yangHuLuDuanId) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("yangHuLuDuanIds", yangHuLuDuanId);
		return mapper.queryLuXianIdByYangHuLuDuanId(params);
	}
	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryLuXianByluXianIds(java.lang.String)
	 */
	public Map<String, Object> queryLuXianByluXianIds(String luXianId) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("luXianIds", luXianId);
		return mapper.queryLuXianByluXianIds(params);
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.ILuxianPZ#findAllLuxianPz()
	 */
	public List<LuxianPZModel> findAllLuxianPz() throws Exception {
		
		return mapper.query(null);
	}

	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#findWeizhi(java.lang.String)
	 */
	public List<Map<String, Object>> findWZType(String id) throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("luxianId", id);
		return mapper.queryWeizhi(params);
	}


	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#findAllByCenter()
	 */
	public List<Map<String, Object>> findAllByCenter() throws Exception {
		return mapper.queryByCenter();
	}


	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#findPoint(java.lang.String, java.lang.String)
	 */
	public List<Map<String, Object>> findPoint(String weizhiId, String luxianId) throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("weizhiId", weizhiId);
		params.put("luxianId", luxianId);
		
		return mapper.queryPoint(params);
	}
	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#findAllCompany()
	 */
	public List<Map<String, Object>> findAllCompany() throws Exception {
		return mapper.queryCompany();
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#findWzMiaoShu(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<Map<String, Object>> findWzMiaoShu(String weizhiId, String luxianId, String wzName) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("weizhiId", weizhiId);
		params.put("luxianId", luxianId);
		params.put("wzName", wzName);
		return mapper.queryWzMiaoShu(params);
	}
	/*
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryFzhlBuJian()
	 */
	public List<Map<String, Object>> queryFzhlBuJian() throws Exception {
		return mapper.queryFzhlBuJian();
	}
	/* 根据类型查询选择信息表
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryChooseInfoByType(java.util.Map)
	 */
	public List<Map<String, Object>> queryChooseInfoByType(int type) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", type);
		return mapper.queryChooseInfoByType(params);
	}
	/*根据选择信息表中的ids(DMS_PZ_bingHaiIndex:wxmkId)获取病害类型 
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryBingHaiIndexByWxmkId(java.lang.String)
	 */
	public List<Map<String, Object>> queryBingHaiIndexByWxmkId(String ids) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		return mapper.queryBingHaiIndexByWxmkId(params);
	}
	/*获取所有病害类型
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryAllBingHaiIndex()
	 */
	public List<Map<String, Object>> queryAllBingHaiIndex() throws Exception {
		return mapper.queryAllBingHaiIndex();
	}
	/*查询所有位置信息
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryAllWeiZhi()
	 */
	public List<Map<String, Object>> queryAllWeiZhi() throws Exception {
		return mapper.queryAllWeiZhi();
	}
	/*获取所有方向 
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryAllFangXiang()
	 */
	public List<Map<String, Object>> queryAllFangXiang() throws Exception {
		return mapper.queryAllFangXiang();
	}
	/*app首页的存储过程获取说有的记录数
	 * (non-Javadoc)
	 * @see com.junl.apps.service.peizhi.IPeizhi#queryProcGetAllCount(java.util.Map)
	 */
	public List<Map<String, Object>> queryProcGetAllCount(String createUserId) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("createUserId", createUserId);
		
		return mapper.queryProcGetAllCount(params);
	}

	
	
	
	
	
	
	
	
}
