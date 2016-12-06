package com.junl.apps.service.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junl.apps.mapper.RoleMapper;


/**
 * 
* @ClassName: RoleImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年9月21日 上午9:21:52
*
 */
@Service
public class RoleImpl implements IRole{

	
	
	@Autowired
	private RoleMapper mapper;

	/**
	 * 根据用户ids获取养护路段的ids
	 */
	public Map<String, Object> queryYangHuLuDuanId(Map<String, Object> map) throws Exception {
		return mapper.queryYangHuLuDuanId(map);
	}

	/**
	 * 根据养护路段查询桩号
	 */
	public List<Map<String, Object>> queryStartZHAndEndZH(Map<String, Object> map) throws Exception {
		return mapper.queryStartZHAndEndZH(map);
	}

	/**
	 *  根据用户获取养护路段的sql
	 */
	public String getZHbyUserId(String userId, String startK, String startM) throws Exception {
		//返回的sql语句
		String val="";
		//1.根据用户ids获取养护路段的ids
		Map<String, Object> param1=new HashMap<String,Object>();
		param1.put("ids", userId);
		Map<String, Object> map1=queryYangHuLuDuanId(param1);
		//获取养护路段
		String[] yangHuLuDuanIds= map1.get("yangHuLuDuanId").toString().split(",");
		if (yangHuLuDuanIds.length>0&&!yangHuLuDuanIds[0].equals("")) {
			//根据养护路段查询桩号
			Map<String, Object> param2=new HashMap<String,Object>();
			param2.put("ids", yangHuLuDuanIds);
			List<Map<String, Object>> list=queryStartZHAndEndZH(param2);
			if (list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> r = list.get(i);
					int startZH = Integer.valueOf(r.get("startZH").toString());
					int endZH = Integer.valueOf(r.get("endZH").toString());
					if (list.size()==1) {//当只有一个养护路段的时候
						val=" and ("+startK+"*1000+"+startM+") between "+startZH+" and "+endZH;
						break;
					}else if(i==0){//不止一个养护路段的时候的 开始的
						val=" and ( ("+startK+"*1000+"+startM+") between "+startZH+" and "+endZH;
					}else if(list.size()==i+1){//不止一个养护路段的时候的 最后的收尾的
						val+=" or ("+startK+"*1000+"+startM+") between "+startZH+" and "+endZH+" ) ";
					}else{//不止一个养护路段的时候  中间的
						val+="or ("+startK+"*1000+"+startM+") between "+startZH+" and "+endZH;
					}
				}
				return val;
			}else{
				return val;
			}
		}
		return val;
	}
	
	/**
	 * 根据用户的ids获取自身所在桩号范围
	 * @param userId
	 * @param startK
	 * @param startM
	 * @return
	 */
	public List<Map<String, Integer>> getZHFanWeibyUserId(String userId)throws Exception {
		List<Map<String, Integer>> list1= null;
		//根据用户ids获取养护路段的ids
		Map<String, Object> param1=new HashMap<String,Object>();
		param1.put("ids", userId);
		Map<String, Object> map1=queryYangHuLuDuanId(param1);
		//获取养护路段
		String[] yangHuLuDuanIds= map1.get("yangHuLuDuanId").toString().split(",");
		if (yangHuLuDuanIds.length>0&&!yangHuLuDuanIds[0].equals("")) {
			//根据养护路段查询桩号
			Map<String, Object> param2=new HashMap<String,Object>();
			param2.put("ids", yangHuLuDuanIds);
			List<Map<String, Object>> list=queryStartZHAndEndZH(param2);
			if (list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					list1=new ArrayList<Map<String, Integer>>();
					Map<String, Object> r = list.get(i);
					int startZH = Integer.valueOf(r.get("startZH").toString());
					int endZH = Integer.valueOf(r.get("endZH").toString());
					Map<String, Integer> map=new HashMap<String, Integer>();
					map.put("startZH", startZH);
					map.put("endZH", endZH);
					list1.add(map);
				}
				return list1;
			}else{
				return list1;
			}
		}
		return list1;
	}
	/**
	 * 判断输入的桩号是否符合范围
	 * @param list
	 * @param zhk
	 * @param zhm
	 * @return
	 */
	public boolean judgeZHScope(List<Map<String, Integer>> list,int startZh,int endZh)throws Exception {
		boolean flag=false;
		for (int i = 0; i < list.size(); i++) {
			Map<String, Integer> map=list.get(i);
			int startZHbz = map.get("startZH");
			int endZHbz = map.get("endZH");
			if ((startZHbz<=startZh&&startZh<=endZHbz)&&(startZHbz<=endZh&&endZh<=endZHbz)) {
				return true;
			}
		}
		return flag;
	}

	
	

}
