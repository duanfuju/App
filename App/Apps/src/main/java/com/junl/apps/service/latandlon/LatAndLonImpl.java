package com.junl.apps.service.latandlon;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.junl.apps.common.FileUtils;
import com.junl.apps.form.AppForm;
import com.junl.apps.form.LatAndLonForm;
import com.junl.apps.mapper.AppMapper;
import com.junl.apps.mapper.LatAndLonMapper;
import com.junl.apps.model.LatAndLonModel;
import com.junl.frame.tools.ConfigUtil;
import com.junl.frame.tools.PropertiesUtil;
import com.junl.frame.tools.UUIDGenerator;


/**
 * 
 * @author dfj
 * @date 2016年8月19日下午2:07:57 
 * @description
 *
 */
@Service
public class LatAndLonImpl implements ILatAndLon{

	
	
	@Autowired
	private LatAndLonMapper mapper;


	@Override
	public int insertLatAndLonCollect(List<LatAndLonForm> forms) throws Exception {
		int res=0;
		for (int i = 0; i < forms.size(); i++) {
			LatAndLonForm form=forms.get(i);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("ids", UUIDGenerator.generate());
			params.put("weizhi", 1);
			params.put("fangxiang", form.getFx());
			params.put("createUserId", form.getCreateUserId());
			params.put("luxian", form.getLx());
			params.put("zhk", form.getBaseZHK());
			params.put("zhm", form.getBaseZHM());
			params.put("lon", form.getBaseJD());
			params.put("lat", form.getBaseWD());
			res+=mapper.insertLatAndLonCollect(params);
			params.put("ids", UUIDGenerator.generate());
			params.put("weizhi", 2);
			params.put("lon", form.getPreJD());
			params.put("lat", form.getPreWD());
			res+=mapper.insertLatAndLonCollect(params);
			params.put("ids", UUIDGenerator.generate());
			params.put("weizhi", 3);
			params.put("lon", form.getSufJD());
			params.put("lat", form.getSufWD());
			res+=mapper.insertLatAndLonCollect(params);
		}
		return res;
	}


	@Override
	public List<Map<String, Object>> queryPointInfo() throws Exception {
		return mapper.queryPointInfo();
	}


	
	

	
	

}
