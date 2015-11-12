package com.sty.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	/**
	 * 验证传入的时间字符串是否匹配传入的时间格式
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValidDate(String s, String format) {
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(format);
		try {
			//指定日期/时间分析是否不严格。进行不严格分析时
			//分析程序可能使用启发式的方法来解释与此对象的格式不精确匹配的输入
			//进行严格分析时，输入必须匹配此对象的格式
			//为 true 时，分析过程是不严格的
			df.setLenient(false);
			df.parse(s);
			return true;
		} catch (ParseException e) {
			return false;

		}
	}

//	/**
//	 * 是否为月初 从配置文件中获得规定的月初限制
//	 * 
//	 * @return true：是 false：否
//	 */
//	public static boolean getBeginningOfMonth() {
//		Date d = new Date();
//		int dd = d.getDate();
//		if (dd < ModePropertiesUtil.beginningOfMonth) {
//			return true;
//		}
//		return false;
//	}

	/**
	 * 
	 * @param longTime
	 * @return
	 */
	public static String getDateByLongTime(long longTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(longTime);
		return sdf.format(date);
	}

	/**
	 * 根据字符串转换成Date类型
	 * 
	 * @param strDate
	 *            yyyyMMddHHmmss
	 * @return
	 */
	public static Date getDateFromStringYY(String strDate) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = null;
		try {
			date = sim.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获得只有年月格式的日期
	 * 
	 * @return
	 */
	public static String getDateYYYYMM() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return sdf.format(new Date());
	}

	/**
	 * 获取unix时间，从1970-01-01 00:00:00开始的秒数
	 * 
	 * @param date
	 * @return long
	 */
	public static long getUnixTime(Date date) {
		if (null == date) {
			return 0;
		}
		return date.getTime() / 1000;
	}

	/**
	 * 获取当前时间 格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getCurrentDataTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static String getCurrentData() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

	/**
	 * 根据字符串转换成Date类型
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date getDateFromString(String strDate) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sim.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当前时间 格式：yyyymmddhh24miss
	 * 
	 * @return
	 */
	public static String getCurrentDataTime2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}

	/**
	 * 获取当前时间 格式：yyyy-MM-dd HH:mm:ss.SSSZ
	 * 
	 * @return
	 */
	public static String formatDate(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(data);
	}

	/**
	 * 将字符型转换为指定格式日期型
	 * 
	 * @param _date
	 *            需要转换成日期的字符串
	 * @param format
	 *            与需要转换成日期的字符串相匹配的格式
	 * @return
	 */
	public static Date stringToDate(String _date, String format) {
		if (null == format || "".equals(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将日期型转换为指定格式的字符串
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		if (null == format || "".equals(format)) {
			format = "yyyy年MM月dd日 hh点:mm分:ss秒";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 获取时间戳 10位
	 * 
	 * @return
	 */
	public static String getCreateTime() {
		Date date = new Date();
		long time = date.getTime();

		String dateline = time + "";
		dateline = dateline.substring(0, 10);
		return dateline;
	}

	/**
	 * 判断是否为今天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		if (date == null) {
			return false;
		} else {
			Calendar appoint = Calendar.getInstance();
			appoint.setTime(date);
			Calendar toDay = Calendar.getInstance();
			if (toDay.get(Calendar.YEAR) == appoint.get(Calendar.YEAR)
					&& toDay.get(Calendar.MONTH) == appoint.get(Calendar.MONTH)
					&& toDay.get(Calendar.DAY_OF_MONTH) == appoint
							.get(Calendar.DAY_OF_MONTH)) {
				return true;
			} else {
				return false;
			}
		}
	}

	// 获取日期yyyy-MM-dd
	public static Date getDateFromStringNoMHS(String strDate) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sim.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 格式化日期yyyy-MM-dd
	public static String formatDateNoHMS(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(data);
	}

	// 比较两个日期大小
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

	public static String generateYesday(String format) {
		Date d = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
		SimpleDateFormat sp = new SimpleDateFormat(format);
		return sp.format(d);// 获取昨天日期
	}

	public static String lastDayTimeOfMonth() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		return new SimpleDateFormat("yyyyMMdd").format(cal.getTime())
				+ "235959";
	}
	public static int compare_date(String DATE1, String DATE2) {
	        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
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

	public static String firstDayTimeOfMonth() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return new SimpleDateFormat("yyyyMMdd").format(cal.getTime())
				+ "000000";
	}
	
	/**
	 * Convert Unix timestamp to normal date style
	 * 
	 * @param timestampString
	 * @param format
	 * @return
	 */
	public static String UnixTimeStamp2DateStr(String timestampString,String format){  
	  Long timestamp = Long.parseLong(timestampString)*1000;  
	  String date = new SimpleDateFormat(format).format(new Date(timestamp));  
	  return date;
	} 

	public static void main(String[] args) {
		
//		System.out.println(UnixTimeStamp2DateStr("1411747471","yyyy-MM-dd HH:mm:ss"));
		
		System.out.println(getDateFromStringYY("20150412182146"));
		
//		System.out.println(getDateFromStringYY(getCurrentDataTime()).getTime());

//		System.out.println(isValidDate("20140227106059", "yyyyMMddHHmmss"));
//		System.out.println(firstDayTimeOfMonth());
		// System.out.println(firstDayTimeOfMonth());
		// System.out.println(lastDayTimeOfMonth());

		// System.out.println(DateTimeUtil.getCurrentDataTime());
		// System.out.println(DateTimeUtil.getCurrentDataTime2());
		// System.out.println(stringToDate(getCurrentDataTime(), ""));

		// System.out.println(getDateByLongTime(1400501878l));
	}
}
