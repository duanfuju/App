package com.junl.frame.tools.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @class DateFactory
 * @author LEON
 * @date 2015年7月6日 下午10:31:09
 * @description
 *		日期格式化工具
 *
 */
public class DateFactory {

	
	/**
	 * 
	 * @method getYYYYMMDD
	 * @author LEON
	 * @date 2015年7月6日 下午10:36:41
	 * @description
	 *		获取日期（2015-01-01）
	 *
	 * @return String 
	 */
	public static String getYYYYMMDD() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
	}
	
	/**
	 * 
	 * @method getYYYYMMDDHHMMSS
	 * @author LEON
	 * @date 2015年7月6日 下午10:37:13
	 * @description
	 *		获取化日期（2015-01-01 11:11:11）
	 *
	 * @return String
	 */
	public static String getYYYYMMDDHHMMSS() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}
	
	/**
	 * 
	 * @method getTimeNum
	 * @author LEON
	 * @date 2015年7月6日 下午10:37:46
	 * @description
	 *		获取化日期（20150101111111）
	 *
	 * @return String
	 */
	public static String getTimeNum() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}
	
	/**
	 * 
	 * @method formatYYYYMMDD
	 * @author LEON
	 * @date 2015年7月6日 下午10:40:27
	 * @description
	 *		格式化日期（2015-01-01）
	 *
	 * @param date
	 * @return String
	 */
	public static String formatYYYYMMDD(Date date) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public static final Date parseDateByFormat(String dateStr,String format) {

		SimpleDateFormat df = new SimpleDateFormat(format);

		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @method formatYYYYMMDDHHMMSS
	 * @author LEON
	 * @date 2015年7月6日 下午10:42:01
	 * @description
	 *		格式化日期（2015-01-01 11:11:11）
	 *
	 * @param date
	 * @return String
	 */
	public static String formatYYYYMMDDHHMMSS(Date date) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	/**
	 * 
	 * @method formatTimeNum
	 * @author LEON
	 * @date 2015年7月6日 下午10:42:40
	 * @description
	 *		格式化日期（20150101111111）
	 *
	 * @param date
	 * @return String
	 */
	public static String formatTimeNum(Date date) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(date);
	}
	
	/**
	 * 
	 * @method formatYYYYMMDDHHMMSS
	 * @author LEON
	 * @date 2015年7月6日 下午10:42:01
	 * @description
	 *		格式化日期（2015-01-01 11:11:11）
	 *
	 * @param date
	 * @return String
	 */
	public static Date formatYYYYMMDDHHMMSSbyString(String date) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
