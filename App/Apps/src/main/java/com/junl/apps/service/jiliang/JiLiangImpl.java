package com.junl.apps.service.jiliang;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junl.apps.common.PageInfoSetCondition;
import com.junl.apps.form.JiLiangForm;
import com.junl.apps.mapper.JiLiangMapper;
import com.junl.apps.mapper.WXFzhlMapper;
import com.junl.apps.mapper.WXJiaoTongMapper;
import com.junl.apps.mapper.WXLieFengMapper;
import com.junl.apps.mapper.WXLuMianMapper;
import com.junl.apps.mapper.WXYangHuMapper;
import com.junl.apps.mapper.WXYouWuMapper;
import com.junl.apps.model.ChouJianModel;
import com.junl.apps.model.JiLiangModel;
import com.junl.apps.model.JiLiangTuiHuiModel;
import com.junl.apps.model.JiLiangXiMuModel;
import com.junl.apps.service.baoyan.BaoYanImpl;
import com.junl.apps.service.choujian.ChouJianImpl;
import com.junl.frame.core.common.page.PageInfo;
import com.junl.frame.tools.UUIDGenerator;


/**
 * 
 * @author dfj
 * @date 2016年8月19日下午2:07:57 
 * @description
 *
 */
@Service
public class JiLiangImpl implements IJiLiang{

	
	
	@Autowired
	private JiLiangMapper mapper;
	@Autowired
	private BaoYanImpl baoyanImpl;
	@Autowired
	private ChouJianImpl choujianImpl;
	
	
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
	 * 默认分页列表
	 */
	public PageInfo queryJiLiangListPage(JiLiangForm form) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", form.getState());
		params.put("byNo", form.getByNo());
		//设置分页参数
		PageInfoSetCondition.SetCondition(form.getPageInfo(), "confirmTime", "desc");
		params.put("page", form.getPageInfo());
		List<Map<String, Object>> list = mapper.queryJiLiangListPage(params);
		form.getPageInfo().setResults(list);
		return form.getPageInfo();
	}

	/**
	 * 根据报验的ids获取维修的数量（中间计量中的计量页面上的维修数量）
	 */
	@Override
	public List<Map<String, Object>> queryWeiXiuNumByBaoYanIds(JiLiangForm form) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("byIds", form.getByIds());
		return mapper.queryWeiXiuNumByBaoYanIds(params);
	}

	/**
	 * 新增
	 */
	public int insertJiLiang(JiLiangModel model) throws Exception {
		//设置主键
		model.setIds(UUIDGenerator.generate());
		return mapper.insertJiLiang(model);
	}

	/**
	 * 确认已计量
	 */
	public int updateJiLiang(Map<String, Object> params) throws Exception {
		int res=-1;
		//生成抽检
		ChouJianModel choujian=new ChouJianModel();
		choujian.setIds(UUIDGenerator.generate());
		choujian.setByIds(params.get("byIds").toString());
		choujian.setJiLingIds(params.get("ids").toString());
		choujianImpl.insertChouJian(choujian);
		//报验的状态需要设置为1
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", params.get("byIds").toString());
		map.put("state", 1);
		baoyanImpl.updateBaoYanState(map);
		//改变计量的状态
		params.put("state", 1);
		res=mapper.updateJiLiang(params);
		
		
		//自动完成抽检
		
		
		//根据报验的ids获取所有的维修记录，将维修记录列表
		List<Map<String, Object>> baoList=baoyanImpl.queryWeiXiuViewByBaoyanId(params.get("byIds").toString());
		//价格被退回
		for (int i = 0; i < baoList.size(); i++) {
			Map<String, Object> mapRemove=baoList.get(i);
			//4=未通过的维修记录
			if (mapRemove.get("state").toString().equals("2")) {
				baoList.remove(i);
			}
		}
		//1.完成抽检的操作
		for (int i = 0; i < baoList.size(); i++) {
			Map<String, Object> wx=baoList.get(i);
			Map<String, Object> param=new HashMap<String,Object>();
			param.put("ids",UUIDGenerator.generate());
			param.put("chouJianIds", choujian.getIds());
			param.put("weiXiuIds", wx.get("ids"));
			param.put("taskId", wx.get("taskInfoRelate"));
			choujianImpl.insertChouJianRelate(param);
		}
		ChouJianModel model=new ChouJianModel();
		model.setIds(choujian.getIds());
		model.setAcceptTime(new Timestamp(System.currentTimeMillis()));
		//2.修改所有维修记录==>验收通过
		for (int i = 0; i < baoList.size(); i++) {
			Map<String, Object> wx=baoList.get(i);
			ChouJianModel m=new ChouJianModel();
			m.setIds(wx.get("ids").toString());
			m.setState(3);
			choujianImpl.updateWithYanShou(m);
		}
		//3.完成抽检
		choujianImpl.updateChouJianState(model);
		
		
		
		
		return res;
	}

	/**
	 * 计量细目的新增
	 */
	public int insertJiLiangXiMu(JiLiangXiMuModel model) throws Exception {
		int res=-1;
		//设置主键
		model.setIds(UUIDGenerator.generate());
		res=mapper.insertJiLiangXiMu(model);
		if (res>0) {
			//根据细目传过来的计量的ids获取计量
			Map<String, Object> jiling=querySimpleByIds(model.getJlIds());
			//根据查询计量的数据，获取报验表的ids和需要改变的状态的值
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("ids", jiling.get("byIds"));
			map.put("state", 1);
			baoyanImpl.updateBaoYanState(map);
			//设置需要改变的额维修记录的条件和值
			double price=model.getPrice();
			double yanShouGongChengLiang=model.getYanShouGongChengLiang();
			double meteringMoney=price*yanShouGongChengLiang;
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("ids", model.getWeiXiuIds());
			params.put("meteringMoney", meteringMoney);
			params.put("state", "1");
			fzhlMapper.updateStateAndCalcForEach(params);
			jiaotongMapper.updateStateAndCalcForEach(params);
			liefengMapper.updateStateAndCalcForEach(params);
			lumianMapper.updateStateAndCalcForEach(params);
			yanghuMapper.updateStateAndCalcForEach(params);
			youwuMapper.updateStateAndCalcForEach(params);
			//修改计量的状态
			Map<String, Object> param=new HashMap<String, Object>();
			param.put("ids",jiling.get("ids"));
			param.put("meteringMoney", meteringMoney);
			updateJiLiangStateWithIds_xiMu(param);
		}
		return res;
	}

	/**
	 * 计量退回的新增
	 */
	public int insertJiLiangTuiHui(JiLiangTuiHuiModel model) throws Exception {
		int res=-1;
		//设置主键
		model.setIds(UUIDGenerator.generate());
		res=mapper.insertJiLiangTuiHui(model);
		if (res>0) {
			//根据细目传过来的计量的ids获取计量
			Map<String, Object> jiling=querySimpleByIds(model.getJlIds());
			//根据查询计量的数据，获取报验表的ids和需要改变的状态的值
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("ids", jiling.get("byIds"));
			map.put("state", 1);
			baoyanImpl.updateBaoYanState(map);
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("ids", model.getWeiXiuIds());
			params.put("state", 2);
			fzhlMapper.updateStateAndCalcForEach(params);
			jiaotongMapper.updateStateAndCalcForEach(params);
			liefengMapper.updateStateAndCalcForEach(params);
			lumianMapper.updateStateAndCalcForEach(params);
			yanghuMapper.updateStateAndCalcForEach(params);
			youwuMapper.updateStateAndCalcForEach(params);
			//修改计量的状态	退回数+1
			Map<String, Object> param=new HashMap<String, Object>();
			param.put("ids",jiling.get("ids"));
			updateJiLiangStateWithIds_tuiHui(param);
		}
		return res;
	}

	/**
	 *  根据ids获取计量的数据
	 */
	public Map<String, Object> querySimpleByIds(String ids) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		return mapper.querySimpleByIds(params);
	}

	
	/**
	 *  修改计量的状态(细目)
	 */
	public int updateJiLiangStateWithIds_xiMu(Map<String, Object> params) throws Exception {
		return mapper.updateJiLiangStateWithIds_xiMu(params);
	}

	/**
	 * 修改计量的状态（退回）
	 */
	public int updateJiLiangStateWithIds_tuiHui(Map<String, Object> params) throws Exception {
		return mapper.updateJiLiangStateWithIds_tuiHui(params);
	}

	
	/**
	 * 根据报验单编号查询计量的数据 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryJiLiangByBaoYanIds(Map<String, Object> map) throws Exception {
		return mapper.queryJiLiangByBaoYanIds(map);
	}


}
