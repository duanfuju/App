package com.junl.frame.tools.number;

import java.util.Random;

/**
 * 
 * @author xus
 * @date 2016年6月22日 上午10:56:23
 * @description 随机数生成器
 */
public class RandomString {

	/**
	 * 
	 * @author xus
	 * @date 2016年6月22日 上午10:57:42
	 * @description 生成指定个数的随机数
	 * @param length
	 * @return
	 *
	 */
	public static String getRandomString(int length) { // length表示生成字符串的长度
		StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyz");
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(random.nextInt(range)));
		}
		return sb.toString().toUpperCase();
	}

	// public static void main(String[] args) {
	// System.out.println(getRandomString(6));
	// }
}
