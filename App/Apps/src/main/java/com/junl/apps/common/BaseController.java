package com.junl.apps.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

	public static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	private String id;
	
	public Map<String, Object> resultMap = new HashMap<String, Object>();
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
