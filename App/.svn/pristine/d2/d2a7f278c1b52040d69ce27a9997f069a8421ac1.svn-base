/**
 * 
 */
package com.junl.frame.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 
/**
 * 
* @ClassName: ConfigUtil
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年8月23日 下午3:55:56
*
 */
public class ConfigUtil {
	
		public ConfigUtil(){}
		private static Properties props = new Properties(); 
		static{
			try {
				props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("upload.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static String getValue(String key){
			return props.getProperty(key);
		}

	    public static void updateProperties(String key,String value) {    
	            props.setProperty(key, value); 
	    } 
	
}
