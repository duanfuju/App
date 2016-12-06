package com.junl.frame.tools.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.junl.frame.tools.PropertiesUtil;
import com.junl.frame.tools.string.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author LEON
 * @date 2016年1月4日 下午3:19:30
 * @description 
 *     redis工具类 目前不支持集群
 */
public class RedisUtils {
	
	private static final Log logger = LogFactory.getLog(RedisUtils.class);
	
	private static RedisUtils redisUtils = null;
	
	private static Map<String, String> redisConf = null;
	
	private static JedisPool jedisPool;
	
	public static RedisUtils getInstance() {
		if(redisUtils == null) {
			redisUtils = new RedisUtils();
		}
		return redisUtils;
	}
	
	private RedisUtils() {
		
		// 加载redis配置
		redisConf = PropertiesUtil.getProperties(
					this.getClass().getResourceAsStream("/redis.properties"));
		
		initialPool();
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月4日 下午2:48:08
	 * @description 
	 *     初始化redis连接池
	 *
	 */
	private static void initialPool() {
		
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(Integer.parseInt(redisConf.get("redis.pool.maxActive")));
			config.setMaxIdle(Integer.parseInt(redisConf.get("redis.pool.maxIdle")));
			config.setMaxWaitMillis(Integer.parseInt(redisConf.get("redis.pool.maxWait")));
			config.setTestOnBorrow(Boolean.getBoolean(redisConf.get("redis.pool.testOnBorrow")));
			
			jedisPool = new JedisPool(config, redisConf.get("redis.url")
					, Integer.parseInt(redisConf.get("redis.post"))
					, Integer.parseInt(redisConf.get("redis.pool.timeout")));
		} catch (Exception e) {
			logger.error("初始化redis连接池失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月4日 下午2:49:32
	 * @description 
	 *     在多线程环境同步初始化
	 *
	 */
	private static synchronized void poolInit() {
        if (jedisPool == null) {  
            initialPool();
        }
    }
	
	
	public synchronized static Jedis getJedis() {  
		
		// 连接池空的情况下实例话连接池
		if (jedisPool == null) {  
			poolInit();
		}
		Jedis jedis = null;
		try {  
			if (jedisPool != null) {  
				jedis = jedisPool.getResource();
				jedis.auth(redisConf.get("reids.password"));
			}
		} catch (Exception e) {
        	logger.error("redis获取连接失败");
        	e.printStackTrace();
        }finally{
        	returnResource(jedis);
        }
        return jedis;
    }
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月4日 下午2:52:44
	 * @description 
	 *     连接使用完毕或者异常的情况下释放连接资源
	 * @param jedis
	 *
	 */
    @SuppressWarnings("deprecation")
	public static void returnResource(final Jedis jedis) {
        if (jedis != null && jedisPool !=null) {
            jedisPool.returnResource(jedis);
        }
    }
	
    /**
     * 
     * @author LEON
     * @date 2016年1月4日 下午2:55:39
     * @description 
     *     存入值
     * @param key
     * @param value
     *
     */
    public static void setString(String key, String value) {
    	
    	try {
    		value = StringUtils.isEmpty(value) ? "" : value;
    		getJedis().set(key, value);
		} catch (Exception e) {
			logger.error("redis: 存入String类型值的时候失败");
		}
    }
    
    /**
     * 
     * @author LEON
     * @date 2016年1月4日 下午3:02:01
     * @description 
     *     存入值，在内存中存活一定时间(单位：秒)
     * @param key 键
     * @param value 值
     * @param seconds 过期时间(单位：秒)
     *
     */
    public static void setStringOfSeconds(String key, String value, int seconds) {
    	
    	try {
    		value = StringUtils.isEmpty(value) ? "" : value;
    		getJedis().setex(key, seconds, value);
		} catch (Exception e) {
			logger.error("redis: 存入String类型值的时候失败");
		}
    }
    
    /**
     * 
     * @author LEON
     * @date 2016年1月4日 下午3:10:49
     * @description 
     *     获取redis值
     * @param key
     * @return
     *
     */
    public static String getString(String key) {
    	
    	String value = "";
    	try {
    		value = getJedis().get(key);
		} catch (Exception e) {
			logger.error("redis: 根据key值获取value失败");
		}
    	return value;
    }
    
    /**
     * 
     * @author LEON
     * @date 2016年1月4日 下午3:19:02
     * @description 
     *     获取redis中所有的key
     * @return
     *
     */
    public static Set<String> getAllKeys() {
    	
    	return getJedis().keys("*");
    }
    
    /**
     * 
     * @author LEON
     * @date 2016年1月4日 下午3:20:46
     * @description 
     *     查询符合条件的keys集合
     * @param pattern 正则
     * @return
     *
     */
    public static Set<String> getKeysLike(String pattern) {
    	
    	return getJedis().keys(pattern);
    }
    
    /**
     * 
     * @author LEON
     * @date 2016年1月4日 下午3:22:57
     * @description 
     *     redis存储map
     * @param key
     * @param map
     *
     */
    public static void setMap(String key, Map<String, String> map) {
    	
    	if(map == null) {
    		return;
    	}
    	try {
    		getJedis().hmset(key, map);
		} catch (Exception e) {
			logger.error("redis: 存入Map类型值的时候失败");
		}
    }
    
    /**
     * 
     * @author LEON
     * @date 2016年1月4日 下午3:40:38
     * @description 
     *     获取map
     * @param key
     * @param fields
     *
     */
    public static List<String> getMap(String key, String fields) {
    	
    	return getJedis().hmget(key, fields);
    }
    
    /**
     * 
     * @author LEON
     * @date 2016年1月4日 下午3:45:56
     * @description 
     *     根据key删除
     * @param key
     *
     */
    public static void deleteByKey(String key) {
    	
    	getJedis().del(key);
    }
}
