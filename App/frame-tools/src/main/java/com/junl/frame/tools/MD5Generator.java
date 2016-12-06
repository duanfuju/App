package com.junl.frame.tools;

import java.security.MessageDigest;

/**
 * 
 * @Class MD5Generator
 * @author LEON
 * @Date 2014-3-21 下午4:42:03
 * @Description
 * 		生成32位长度的MD5密码
 *
 */
public class MD5Generator {
	
	private final static char[] HEXDIGITS = {'0', '1', '2', '3', '4', '5',
				'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	/**
	 * 
	 * @Method bytesToHex
	 * @author LEON
	 * @Date 2014-3-21 下午4:42:00
	 * @Description
	 * 		TODO
	 *
	 * @param bytes
	 * @return
	 */
	private static String bytesToHex(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		int t;
		for(int i = 0; i < 16; i++) {
			t = bytes[i];
			if(t < 0) {
				t += 256;
			}
			sb.append(HEXDIGITS[(t >>> 4)]);
			sb.append(HEXDIGITS[(t % 16)]);
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @Method md5
	 * @author LEON
	 * @Date 2014-3-21 下午4:44:58
	 * @Description
	 * 		进行加密
	 *
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static String md5(String input) throws Exception {
		MessageDigest md = MessageDigest.getInstance(
				System.getProperty("MD5.algorithm", "MD5"));
		
		return bytesToHex(md.digest(input.getBytes("utf-8"))).substring(8, 24);
	}
	
	/**
	 * 
	 * @Method checkMD5
	 * @author LEON
	 * @Date 2014-3-21 下午4:47:29
	 * @Description
	 * 		MD5验证
	 *
	 * @param input 输入值
	 * @param param 验证值
	 * @return
	 * @throws Exception
	 */
	public static boolean checkMD5(String input, String param) throws Exception {
		String afterMD5 = md5(input);
		return afterMD5.equals(param) ? true : false;
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(md5("123456"));
//		System.out.println(checkMD5("admin", "7A57A5A743894A0E"));
//	}
}
