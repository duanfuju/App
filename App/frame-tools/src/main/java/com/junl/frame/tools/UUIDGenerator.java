package com.junl.frame.tools;

import java.util.UUID;

/**
 * 
 * @author LEON
 * @date 2015年12月23日 上午10:02:04
 * @description 
 *     uuid
 */
public class UUIDGenerator {

	/**
	 * 
	 * @Method generate
	 * @author LEON
	 * @Date 2014-3-21 下午4:33:58
	 * @Description
	 * 		uuid 生成器
	 *
	 * @return
	 */
	public static String generate() {
		
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id.replace("-", "");
	}
}
