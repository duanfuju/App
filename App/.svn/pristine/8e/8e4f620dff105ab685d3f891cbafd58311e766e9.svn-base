package com.junl.frame.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author LEON
 * @date 2015年12月23日 上午11:06:41
 * @description 
 *     TODO
 */
public class PropertiesUtil {

	public static final Log logger = LogFactory.getLog(PropertiesUtil.class);
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:07:48
	 * @description 
	 *     TODO
	 * @param inputstream
	 * @return
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, String> getProperties(InputStream inputstream) {
		
		Map<String, String> propertyMap = null;
		try {
			Properties properties = new Properties();
			properties.load(inputstream);
			propertyMap = (Map) properties;
			inputstream.close();
			return propertyMap;
		} catch (Exception e) {
			logger.error("加载配置文件出错");
			e.printStackTrace();
			try {
				inputstream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				inputstream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return propertyMap;
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月4日 下午2:25:08
	 * @description 
	 *     TODO
	 * @param inputstream
	 * @param key
	 * @return
	 *
	 */
	public static String getValue(InputStream inputstream, String key) {
		
		String value = "";
		try {
			Properties properties = new Properties();
			properties.load(inputstream);
			value = properties.getProperty(key);
			inputstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputstream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return value;
	}
}
