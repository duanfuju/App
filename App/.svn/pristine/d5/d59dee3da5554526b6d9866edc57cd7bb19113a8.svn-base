package com.junl.frame.tools.string;

import java.util.Arrays;

import com.junl.frame.tools.ObjectUtils;

/**
 * 
 * @author chenmaolong
 * @date 2015年9月2日 下午5:44:49
 * @description 常用工具类
 */
public class StringUtils {
	
	public static String changNull(Object obj) {
		String s = "";
		if (obj != null) {
			s = String.valueOf(obj) ;
		}
		return s;
	}
	/**
	 * 
	 * @param num
	 * @return
	 */
	public static String intToStrong(int num){
		String str="";
		int length=String.valueOf(num).length();
		if (length==1) {
			str="00"+num;
		}else if (length==2) {
			str="0"+num;
		}else if (length==3) {
			str=""+num;
		}
		return str;
	}
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:46:56
	 * @description 
	 *     判断是否为空
	 * @param str
	 * @return
	 *
	 */
	public static boolean isEmpty(Object str) {
		return (str == null || "".equals(str));
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:47:45
	 * @description 
	 *     判断是否有长度
	 * @param str
	 * @return
	 *
	 */
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:48:12
	 * @description 
	 *     判断是否有长度
	 * @param str
	 * @return
	 *
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:50:01
	 * @description 
	 *     判断是否有内容
	 * StringUtils.hasText(null) = false
	 * StringUtils.hasText("") = false
	 * StringUtils.hasText(" ") = false
	 * StringUtils.hasText("12345") = true
	 * StringUtils.hasText(" 12345 ") = true
	 * @param str
	 * @return
	 *
	 */
	public static boolean hasText(CharSequence str) {
		if (!hasLength(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:50:47
	 * @description 
	 *     判断是否有内容
	 * @param str
	 * @return
	 *
	 */
	public static boolean hasText(String str) {
		return hasText((CharSequence) str);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:56:56
	 * @description 
	 *     是否包含任意空格
	 * @param str
	 * @return
	 *
	 */
	public static boolean containsWhitespace(CharSequence str) {
		if (!hasLength(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:56:56
	 * @description 
	 *     是否包含任意空格
	 * @param str
	 * @return
	 *
	 */
	public static boolean containsWhitespace(String str) {
		return containsWhitespace((CharSequence) str);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:57:47
	 * @description 
	 *     去除空格
	 * @param str
	 * @return
	 *
	 */
	public static String trimWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午11:58:09
	 * @description 
	 *     去除空格
	 * @param str
	 * @return
	 *
	 */
	public static String trimAllWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}
		int len = str.length();
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (!Character.isWhitespace(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 下午12:00:56
	 * @description 
	 *     字符串是否以某个开头
	 * @param str
	 * @param prefix
	 * @return
	 *
	 */
	public static boolean startsWithIgnoreCase(String str, String prefix) {
		if (str == null || prefix == null) {
			return false;
		}
		if (str.startsWith(prefix)) {
			return true;
		}
		if (str.length() < prefix.length()) {
			return false;
		}
		String lcStr = str.substring(0, prefix.length()).toLowerCase();
		String lcPrefix = prefix.toLowerCase();
		return lcStr.equals(lcPrefix);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 下午12:01:37
	 * @description 
	 *     字符串后是否以某个结尾
	 * @param str
	 * @param suffix
	 * @return
	 *
	 */
	public static boolean endsWithIgnoreCase(String str, String suffix) {
		if (str == null || suffix == null) {
			return false;
		}
		if (str.endsWith(suffix)) {
			return true;
		}
		if (str.length() < suffix.length()) {
			return false;
		}

		String lcStr = str.substring(str.length() - suffix.length()).toLowerCase();
		String lcSuffix = suffix.toLowerCase();
		return lcStr.equals(lcSuffix);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 下午12:52:02
	 * @description 
	 *     对string数组进行排序
	 * @param array
	 * @return
	 *
	 */
	public static String[] sortStringArray(String[] array) {
		if (ObjectUtils.isEmpty(array)) {
			return new String[0];
		}
		Arrays.sort(array);
		return array;
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 下午12:57:43
	 * @description 
	 *     获取后缀
	 * @param str
	 * @return
	 *
	 */
	public static String getSuffix(String str) {
		if(isEmpty(str)) {
			return "";
		}
		return str.substring(str.lastIndexOf(".") + 1);
	}
}
