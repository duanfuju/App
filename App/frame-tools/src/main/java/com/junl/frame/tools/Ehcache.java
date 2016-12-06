package com.junl.frame.tools;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author xus
 * @date 2016年6月22日 上午10:53:23
 * @description 
 *		ehcache工具类
 */
@Component
public class Ehcache {
	
	@Autowired
	private CacheManager cacheManager;
	
	/**
	 * 
	 * @author xus
	 * @date 2016年6月22日 上午10:53:39
	 * @description 
	 *		存
	 * @param key
	 * @param value
	 * @param typeCache
	 * @throws Exception
	 *
	 */
	public void putCache(String key,String value,String typeCache) throws Exception {
		cacheManager = CacheManager.create();
		Cache cache = cacheManager.getCache(typeCache);
		Element element = new Element(key, value);
		cache.put(element);
		
	}
	
	/**
	 * 
	 * @author xus
	 * @date 2016年6月22日 上午10:53:46
	 * @description 
	 *		取
	 * @param key
	 * @param typeCache
	 * @return
	 * @throws Exception
	 *
	 */
	public String getCache(String key,String typeCache) throws Exception {
		cacheManager = CacheManager.create();
		Cache cache = cacheManager.getCache(typeCache);
		Element element = cache.get(key);
		cache.get(element);
		return element.getValue().toString();
	}
}	