/** 
 * DateUtils.java
 * create on 2011-01-01
 * Copyright 2015 NetFin TerryLi All Rights Reserved.
 */
package com.junl.frame.tools.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.Assert;

/**
 * 日期工具类
 * 
 * @since version1.0
 */
public abstract class DateUtils extends org.apache.commons.lang.time.DateUtils {

	/**
	 * 两个日期相减得到天数
	 * 
	 * @param date1
	 *            传入日期
	 * @param date2
	 *            传入日期
	 * @return 天数 long
	 */
	public static long sub(Date date1, Date date2) {
		Date d1 = convertToDate(dateParseShortString(date1));
		Date d2 = convertToDate(dateParseShortString(date2));
		long day = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}
	/**
	 * 返回当前时间
	 * 
	 * @return 返回当前时间
	 */
	public static Date getCurrentDateTime() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		java.util.Date dtNow = calNow.getTime();
		return dtNow;
	}

	/**
	 * 返回当前时间的数字
	 * 
	 * @return 返回当前时间的数字
	 */
	public static String getCurrentTimeNumber() {
		return new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new java.util.Date());
	}
	public static String getCurrentSTimeNumber(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS")
		.format(new java.util.Date());
	}
	public static String getCurrentDTimeNumber(){
		return new SimpleDateFormat("yyyyMMdd")
		.format(new java.util.Date());
	}

	public static int getCurrentUnixTime() throws Exception {
		long epoch = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
				.parse("01/01/1970 00:00:00").getTime() / 1000;
		return Integer.parseInt(Long.toString(System.currentTimeMillis() / 1000
				- epoch));
	}

	/**
	 * @return 返回今天日期，时间部分为0。例如：2006-4-8 00:00:00
	 */
	public static Date getToday() {
		return truncate(new Date(), Calendar.DATE);
	}

	/**
	 * @return 返回今天日期，时间部分为23:59:59.999。例如：2006-4-19 23:59:59.999
	 */
	public static Date getTodayEnd() {
		return getDayEnd(new Date());
	}

	/**
	 * 将字符串转换为日期（不包括时间）
	 * 
	 * @param dateString
	 *            "yyyy-MM-dd"格式的日期字符串
	 * @return 日期
	 */
	public static Date convertToDate(String dateString) {
		try {
			return FormatConstants.DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 检查字符串是否为日期格式yyyy-MM-dd
	 * 
	 * @param dateString
	 * @return true=是；false=否
	 */
	public static boolean checkDateString(String dateString) {
		return (convertToDate(dateString) != null);
	}

	/**
	 * 将字符串转换为日期（包括时间）
	 * 
	 * @param dateString
	 *            "yyyy-MM-dd HH:mm:ss"格式的日期字符串
	 * @return 日期时间
	 */
	public static Date convertToDateTime(String dateTimeString) {
		try {
			return FormatConstants.DATE_TIME_FORMAT.parse(dateTimeString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将字符串转换为日期（包括时间）
	 * 
	 * @param dateString
	 *            "dd/MM/yyyy HH:mm"格式的日期字符串
	 * @return 日期
	 */
	public static Date convertSimpleToDateTime(String dateString) {
		try {
			return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm")
					.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 检查字符串是否为日期时间格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateString
	 * @return true=是；false=否
	 */
	public static boolean checkDateTimeString(String dateTimeString) {
		return (convertToDateTime(dateTimeString) != null);
	}

	/**
	 * 获取月底
	 * 
	 * @param year
	 *            年 4位年度
	 * @param month
	 *            月 1~12
	 * @return 月底的Date对象。例如：2006-3-31 23:59:59.999
	 */
	public static Date getMonthEnd(int year, int month) {
		StringBuffer sb = new StringBuffer(10);
		Date date;
		if (month < 12) {
			sb.append(Integer.toString(year));
			sb.append("-");
			sb.append(month + 1);
			sb.append("-1");
			date = convertToDate(sb.toString());
		} else {
			sb.append(Integer.toString(year + 1));
			sb.append("-1-1");
			date = convertToDate(sb.toString());
		}
		date.setTime(date.getTime() - 1);
		return date;
	}

	/**
	 * 获取月底
	 * 
	 * @param when
	 *            要计算月底的日期
	 * @return 月底的Date对象。例如：2006-3-31 23:59:59.999
	 */
	public static Date getMonthEnd(Date when) {
		Assert.notNull(when, "date must not be null !");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		return getMonthEnd(year, month);
	}

	/**
	 * 日期格式转换为字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateParseString(Date date) {
		java.text.DateFormat df = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

	/**
	 * 日期格式转换为字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateParseShortString(Date date) {
		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	/**
	 * 获取给定日的最后一刻。
	 * 
	 * @param when
	 *            给定日
	 * @return 最后一刻。例如：2006-4-19 23:59:59.999
	 */
	public static Date getDayEnd(Date when) {
		Date date = truncate(when, Calendar.DATE);
		date = addDays(date, 1);
		date.setTime(date.getTime() - 1);
		return date;
	}

	/**
	 * 获取给定日的第一刻。
	 * 
	 * @param when
	 *            给定日
	 * @return 最后一刻。例如：2006-4-19 23:59:59.999
	 */
	public static Date getDay(Date when) {
		Date date = truncate(when, Calendar.DATE);
		date = addDays(date, -1);
		date.setTime(date.getTime() + 1);
		return date;
	}

	/**
	 * 日期加法
	 * 
	 * @param when
	 *            被计算的日期
	 * @param field
	 *            the time field. 在Calendar中定义的常数，例如Calendar.DATE
	 * @param amount
	 *            加数
	 * @return 计算后的日期
	 */
	public static Date add(Date when, int field, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 计算给定的日期加上给定的天数。
	 * 
	 * @param when
	 *            给定的日期
	 * @param amount
	 *            给定的天数
	 * @return 计算后的日期
	 */
	public static Date addDays(Date when, int amount) {
		
		return add(when, Calendar.DAY_OF_YEAR, amount);
	}
	/**
	 * 计算给定的日期加上给定的分钟数。
	 * 
	 * @param when
	 *            给定的日期
	 * @param amount
	 *            给定的分钟数
	 * @return 计算后的日期
	 */
	public static Date addMinutes(Date when, int amount) {
		
		return add(when, Calendar.MINUTE, amount);
	}
	
	/**
	 * 计算给定的日期加上给定的秒数。
	 * 
	 * @param when
	 *            给定的日期
	 * @param amount
	 *            给定的秒数
	 * @return 计算后的日期
	 */
	public static Date addSeconds(Date when, int amount) {
		
		return add(when, Calendar.SECOND, amount);
	}
	
	/**
	 * 计算给定的日期加上给定的月数。
	 * 
	 * @param when 
	 *            给定的日期
	 * @param amount
	 *            给定的月数
	 * @return 计算后的日期
	 */
	public static Date addMonths(Date when, int amount) {
		return add(when, Calendar.MONTH, amount);
	}

	/**
	 * 获取当前时段：早上、上午、下午、晚上、凌晨
	 * 
	 * @return 当前时段
	 */
	@SuppressWarnings("deprecation")
	public static String getTimePeriod() {
		String period = "";
		Date now = getCurrentDateTime();
		int hour = now.getHours();
		if (hour >= 0 && hour < 6) {
			period = "凌晨";
		} else if (hour >= 6 && hour < 8) {
			period = "早上";
		} else if (hour >= 8 && hour < 12) {
			period = "上午";
		} else if (hour >= 12 && hour < 18) {
			period = "下午";
		} else if (hour >= 18) {
			period = "晚上";
		}
		return period;
	}

	/**
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getTimePriTenDay(Date date, int n) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return convertToDateTime(df.format(new Date(date.getTime() + n * 24
				* 60 * 60 * 1000)));
	}

	/**
	 * 将Date对象类型转化为日期(2006-09-17 5:20:5)的字符串
	 * 
	 * @param Date
	 * @return String
	 */
	public static String dateToString(Date date) {

		try {
			if (date != null)
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		} catch (Exception e) {
			e.printStackTrace();
			System.gc();
		}
		return null;
	}

	/**
	 * 将String 类型的转化为日期格式(2006-09-17 5:20:5)
	 * 
	 * @param String
	 * @return Date
	 */
	public static Date stringToDate(String dateStr) {

		try {
			if (dateStr != null)
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			System.gc();
		}
		return null;
	}

	/**
	 * 字符串转为时间类型
	 * 
	 * @param dateStr
	 *            <String>
	 * @return Date
	 */
	public static final Date parseDate(String dateStr) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
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
	 * 得到具体时间如：几天前；几小时前；几分钟前；几秒钟前
	 * 
	 * @param time
	 *            传入一个Date类型的日期
	 * @return 根据当天当时当秒解析出距离当天当时当秒的字符串 String
	 */
	public static String getTimeInterval(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Long dateDiff = sdf.parse(sdf.format(new Date())).getTime()
					- sdf.parse(sdf.format(time)).getTime();

			Long day = dateDiff / (24 * 60 * 60 * 1000);

			if (day > 0) {
				return day + "天前";
			}

			Long hour = dateDiff / (60 * 60 * 1000);

			if (hour > 0) {
				return hour + "小时前";
			}

			Long minute = dateDiff / (60 * 1000);

			if (minute > 0) {
				return minute + "分钟前";
			}

			Long second = dateDiff / 1000;

			return second + "秒前";
		} catch (Exception e) {
			e.printStackTrace();
			return "未知";
		}
	}
	
	/**
	 * 由当前时间返回yyyy-mm-dd格式的日期字符串
	 * 
	 * @return String
	 */
	public static String getStringOfTodayDate() {

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(d);
	}
	/**
	 * DATE1>DATE2 返回1，DATE1=DATE2 返回0，DATE1<DATE2 返回-1
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compareDate(String DATE1, String DATE2) {
        
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
	/**
	 * DATE1>DATE2 返回1，DATE1=DATE2 返回0，DATE1&lt; DATE2 返回 -1
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compareDate(Date DATE1, Date DATE2) {
        
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(df.format(DATE1));
            Date dt2 = df.parse(df.format(DATE2));
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
	/**
	 * 将Date对象类型转化为指定的格式字符串
	 * 
	 * @param date<Date>日期
	 * @param format<String>格式
	 * @return String
	 */
	public static String dateToString(Date date, String format) {

		try {
			if(date!=null)
				return new SimpleDateFormat(format).format(date);
		} catch (Exception e) {
			e.printStackTrace();
			System.gc();
		}
		return null;
	}
	
	/**
	 * 系统日期减去传入日期得到天数
	 * @param date1 传入日期 
	 * @return 天数
	 * long
	 */
	public static long sub(Date date1) {
		Date d2 = convertToDate(dateParseShortString(new Date()));
		Date d1 = convertToDate(dateParseShortString(date1));		
		long day = (d2.getTime() - d1.getTime())/(24*60*60*1000);
		return day;
	}
	
	/**
	 * 日期相减得到年数
	 * @param date1 相减的日期
	 * @return
	 */
	public static long subDateGetYear(Date date1) {
		Date d2 = convertToDate(dateParseShortString(new Date()));
		Date d1 = convertToDate(dateParseShortString(date1));		
		long day = (d2.getYear() - d1.getYear());
		return day+1;
	}
	
	
	/**
	 * 计算下次结算日期
	 * 如果 date为2014-2-28日，addMonth为1，那下次日期为 2014-3-31
	 * 如果 date为2014-1-29日，addMonth为1，那下次日期为 2014-2-28，addMonth为2，那下次日期为 2014-3-29
	 * @param date  
	 * @param addMonth
	 * @return
	 */
	public static Date calculateNextSettleDate(Date date,int addMonth){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
		int maxOfMonth=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(dayOfMonth==maxOfMonth){
			calendar.add(Calendar.MONTH,addMonth);
			maxOfMonth=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			calendar.set(Calendar.DAY_OF_MONTH, maxOfMonth);
		}else{
			calendar.add(Calendar.MONTH, addMonth);
		}
		return calendar.getTime();
	}
	public static boolean containsDate(Date now,Date start,Date end){
		return now.before(end)&&now.after(start);
	}
}
