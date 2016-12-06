package com.junl.apps.service.choujian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junl.apps.common.PageInfoSetCondition;
import com.junl.apps.form.ChouJianForm;
import com.junl.apps.mapper.ChouJianMapper;
import com.junl.apps.mapper.WXFzhlMapper;
import com.junl.apps.mapper.WXJiaoTongMapper;
import com.junl.apps.mapper.WXLieFengMapper;
import com.junl.apps.mapper.WXLuMianMapper;
import com.junl.apps.mapper.WXYangHuMapper;
import com.junl.apps.mapper.WXYouWuMapper;
import com.junl.apps.model.ChouJianModel;
import com.junl.frame.core.common.page.PageInfo;


/**
 * 
 * @author dfj
 * @date 2016年8月19日下午2:07:57 
 * @description
 *
 */
@Service
public class ChouJianImpl implements IChouJian{

	
	
	@Autowired
	private ChouJianMapper mapper;
	
	@Autowired
	private WXFzhlMapper fzhlMapper;
	@Autowired
	private WXJiaoTongMapper jiaotongMapper;
	@Autowired
	private WXLieFengMapper liefengMapper;
	@Autowired
	private WXLuMianMapper lumianMapper;
	@Autowired
	private WXYangHuMapper yanghuMapper;
	@Autowired
	private WXYouWuMapper youwuMapper;
	
	
	/**
	 * 抽检管理
	 */
	public List<Map<String, Object>> queryForEachChouJianGuanLi(ChouJianForm form) throws Exception {
		Map<String, Object> params= new HashMap<String, Object>();
		params.put("byIds", form.getByIds());
		//cjstate任意值，只是为了将已抽检的任务区分出来
		params.put("cjstate", form.getByIds());
		List<Map<String, Object>> list = mapper.queryForEachChouJianGuanLi(params);
		
		
	/*	list.addAll(fzhlMapper.queryForEachChouJianGuanLi(params));
		list.addAll(jiaotongMapper.queryForEachChouJianGuanLi(params));
		list.addAll(liefengMapper.queryForEachChouJianGuanLi(params));
		list.addAll(lumianMapper.queryForEachChouJianGuanLi(params));
		list.addAll(yanghuMapper.queryForEachChouJianGuanLi(params));
		list.addAll(youwuMapper.queryForEachChouJianGuanLi(params));*/
		return list;
	}
	
	public PageInfo queryChouJianListPage(ChouJianForm form) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("_state", 0);
		if (form.getState()!=-1) {
			params.put("state", form.get_state());
		}
		//设置分页参数
		PageInfoSetCondition.SetCondition(form.getPageInfo(), "confirmTime", "desc");
		params.put("page", form.getPageInfo());
		//初始的数据
		List<Map<String, Object>> list = mapper.queryChouJianListPage(params);
		//返回的数据
		List<Map<String, Object>> _list=new ArrayList<Map<String, Object>>(); 
		for (int i = 0; i < list.size(); i++) {
			int accptNum=0;
			int noAccptNum=0;
			//单条数据
			Map<String, Object> map=list.get(i);
			//条件
			Map<String, Object> param=new HashMap<String, Object>();
			param.put("byIds", map.get("byIds"));
			//通过的个数
			param.put("state",3);
			accptNum=mapper.queryForEachChouJianGuanLi(param).size();
	/*		accptNum+=fzhlMapper.queryForEachAccept(param).size();
			accptNum+=jiaotongMapper.queryForEachAccept(param).size();
			accptNum+=liefengMapper.queryForEachAccept(param).size();
			accptNum+=lumianMapper.queryForEachAccept(param).size();
			accptNum+=yanghuMapper.queryForEachAccept(param).size();
			accptNum+=youwuMapper.queryForEachAccept(param).size();*/
			//未通过的个数
			param.put("state",2);
			noAccptNum=mapper.queryForEachChouJianGuanLi(param).size();
		/*	noAccptNum+=fzhlMapper.queryForEachNoAccept(param).size();
			noAccptNum+=jiaotongMapper.queryForEachNoAccept(param).size();
			noAccptNum+=liefengMapper.queryForEachNoAccept(param).size();
			noAccptNum+=lumianMapper.queryForEachNoAccept(param).size();
			noAccptNum+=yanghuMapper.queryForEachNoAccept(param).size();
			noAccptNum+=youwuMapper.queryForEachNoAccept(param).size();*/
			
			map.put("accptNum", accptNum);
			map.put("noAccptNum", noAccptNum);
			_list.add(map);
		}
		
		
		form.getPageInfo().setResults(_list);
		return form.getPageInfo();
	}



	/**
	 * 新增
	 */
	public int insertChouJian(ChouJianModel model) throws Exception {
		return mapper.insertChouJian(model);
	}

	/**
	 * 抽检管理中的验收是否完成 
	 */
	public int updateWithYanShou(ChouJianModel model) throws Exception {
		int res=-1;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", model.getState());
		params.put("ids", model.getIds());
		if (fzhlMapper.updateWithYanShou(params)>0) {
			res=1;
		}else if(jiaotongMapper.updateWithYanShou(params)>0){
			res=1;
		}else if(liefengMapper.updateWithYanShou(params)>0){
			res=1;
		}else if(lumianMapper.updateWithYanShou(params)>0){
			res=1;
		}else if(yanghuMapper.updateWithYanShou(params)>0){
			res=1;
		}else if(youwuMapper.updateWithYanShou(params)>0){
			res=1;
		}
		return res;
	}

	/**
	 * 完成抽检
	 */
	public int updateChouJianState(ChouJianModel model) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", 2);
		params.put("acceptTime", model.getAcceptTime());
		params.put("ids", model.getIds());
		return mapper.updateChouJianState(params);
	}

	@Override
	public List<Map<String, Object>> queryForEachChouJianGuanLi(Map<String, Object> map) throws Exception {
		return mapper.queryForEachChouJianGuanLi(map);
	}

	/**
	 * 新增抽检关系
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int insertChouJianRelate(Map<String, Object> map) throws Exception {
		return mapper.insertChouJianRelate(map);
	}






	
	

}
