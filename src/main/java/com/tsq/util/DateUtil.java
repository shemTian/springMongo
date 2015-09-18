package com.tsq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static final String YEAR_MONTH_DAY_PATTERN = "yyyy-MM-dd";
	public static final String HOUR_MINUTE_SECOND_PATTERN = "HH:mm:ss";
	public static final String YMDHMS_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String YMDHMS_LIST_PATTERN = "yyyyMMddHHmmss";
	public static final String DEFAULT_PATTERN = "yyyy-MM-dd";
	public static final String DEFAULT_PATTERN_YMD = "yyyyMMdd";
	
	
	/**
	 * 得到当前时间long类型，适用于insert into [DB]
	 */
	public static long getLongTime() {
		return System.currentTimeMillis();
	}
	/**
	 * 返回当前时间
	 */
	public static Date currentDate() {
		return new Date();
	}
	/**
     * 根据传入的日期格式化patter将传入的字符串转换成日期对象
     * 
     * @param dateStr 要转换的字符串
     * @param pattern 日期格式化pattern
     * @return 转换后的日期对象
     * @throws ParseException 如果传入的字符串格式不合法
     */
    public static Date parse(final String dateStr, final String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException("Dateutil.parse ,param:"+dateStr+","+pattern,e);
		}
    }
	
	/**
	 * 格式化日期,格式化后可直接insert into [DB],格式化后的日期为：2006-10-12 14:42:47
	 * <P>
	 * 把日期转换成字符串
	 */
	public static String dateToStr(Date date) {

		if (date == null)
			return "";
		else {
			SimpleDateFormat sdFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
			String str_Date = sdFormat.format(date);
			
			if (str_Date.substring(11).equals("00:00:00")){
			    str_Date = dateToStrEn(date);
			}
			return str_Date;
		}
	}

	/**
	 * 格式化后的日期为：2006年10月12
	 * <P>
	 * 把日期转换成字符串
	 */
	public static String dateToStrCN(Date date) {

		if (date == null)
			return "";
		else {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd",
					Locale.getDefault());
			String str_Date = sdFormat.format(date);
			return str_Date;
		}
	}

	/**
	 * 格式化后的日期为：2006-10-12
	 * <P>
	 * 把日期转换成字符串
	 */
	public static String dateToStrEn(Date date) {

		if (date == null)
			return "";
		else {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd",
					Locale.getDefault());
			String str_Date = sdFormat.format(date);
			return str_Date;
		}
	}
	
	public static String dateToStrEn(Date date,String format) {

		if (date == null)
			return "";
		else {
			SimpleDateFormat sdFormat = new SimpleDateFormat(format,
					Locale.getDefault());
			String str_Date = sdFormat.format(date);
			return str_Date;
		}
	}

	/**
	 * 把字符串转换成日期类型yyyy-MM-dd HH:mm:ss
	 */
	public static Date strToDate(String str) {
//		try{
//			return DateUtils.parseDate(str, new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"});
//		}catch(Throwable t){
//			t.printStackTrace();
//			return null;
//		}
		Date date = null;
		try{
			if (!StringUtil.isEmpty(str)){
				if (str.length() == 19) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					date = formatter.parse(str.substring(0, 19));
				}else if(str.length() == 10){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					date = formatter.parse(str);
				}else{
					//date = DateFormat.getDateInstance().parse(str);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 日期计算
	 * 
	 * @param date
	 *            起始日期
	 * @param yearNum
	 *            年增减数
	 * @param monthNum
	 *            月增减数
	 * @param dateNum
	 *            日增减数
	 */
	public static String calDate(String date, int yearNum, int monthNum,
			int dateNum) {
		String result = "";
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sd.parse(date));
			cal.add(Calendar.MONTH, monthNum);
			cal.add(Calendar.YEAR, yearNum);
			cal.add(Calendar.DATE, dateNum);
			result = sd.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String calDate(Date date, int yearNum, int monthNum,
			int dateNum) {
		String result = "";
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, monthNum);
			cal.add(Calendar.YEAR, yearNum);
			cal.add(Calendar.DATE, dateNum);
			result = sd.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String calDate(Date date, int yearNum, int monthNum,
			int dateNum,String returnFormat) {
		String result = "";
		try {
			SimpleDateFormat sd = new SimpleDateFormat(returnFormat);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, monthNum);
			cal.add(Calendar.YEAR, yearNum);
			cal.add(Calendar.DATE, dateNum);
			result = sd.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private static String delFrontZero(String mord) {
		int im = -1;
		try {
			im = Integer.parseInt(mord);
			return String.valueOf(im);
		} catch (Exception e) {
			return mord;
		}
	}

	/**
	 * DateUtil.parseDate("20070423123754") 转换为：Mon Apr 23 12:37:54 CST 2007
	 * 
	 * @param orlTime
	 * @return
	 */
	public static Date parseDate(String orlTime) {
		Date date = null;
		if (orlTime == null || orlTime.length() <= 0) {
			return null;
		}

		if (!(orlTime.length() == 14)) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			date = (Date) formatter.parse(orlTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
	public static Date parseDate(String orlTime,String formatString) {
		Date date = null;
		if (orlTime == null || orlTime.length() <= 0) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatString);
		try {
			date = (Date) formatter.parse(orlTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * DateUtil.parseDate("20070423") 转换为：Mon Apr 23 00:00:00 CST 2007
	 * 
	 * @param orlTime
	 * @return
	 */
	public static Date parseDateDB(String orlTime) {
		Date date = null;
		if (orlTime == null || orlTime.length() <= 0) {
			return null;
		}

		if (!(orlTime.length() == 8)) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			date = (Date) formatter.parse(orlTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * DateUtil.parseCnDate("2006-10-12") 转换为：2006年10月12日
	 * 
	 * @param orlTime
	 * @return
	 */
	public static String parseCnDate(String orlTime) {
		if (orlTime == null || orlTime.length() <= 0) {
			return "";
		}

		if (orlTime.length() < 10) {
			return "";
		}
		String sYear = orlTime.substring(0, 4);
		String sMonth = delFrontZero(orlTime.substring(5, 7));
		String sDay = delFrontZero(orlTime.substring(8, 10));
		return sYear + "年" + sMonth + "月" + sDay + "日";
	}
	
	/**
	 * DateUtil.parsePointDate("2006-10-12") 转换为：10.12
	 * 
	 * @param orlTime
	 * @return
	 */
	public static String parsePointDate(String orlTime) {
		if (orlTime == null || orlTime.length() <= 0) {
			return "";
		}
		String sMonth = delFrontZero(orlTime.substring(5, 7));
		String sDay = delFrontZero(orlTime.substring(8, 10));
		return sMonth + "." + sDay;
	}


	public static long calendarDayPlus(Date d1, Date d2) {
		long milis = calendarMilisPlus(d1, d2);
		milis = milis / 1000 / 60 / 60 / 24;
		return milis;
	}

	public static long calendarMilisPlus(Date d1, Date d2) {
		return d2.getTime() - d1.getTime();
	}

	public static String compareDate(String date1, String date2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(date1);
			Date dt2 = df.parse(date2);
			if (dt1.getTime() > dt2.getTime()) {
				//System.out.println("dt1 在dt2前");
				return "1";
			} else if (dt1.getTime() < dt2.getTime()) {
				//System.out.println("dt1在dt2后");
				return "-1";
			} else {
				return "0";
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return "0";
	}
	
    public final static String getBetweenStr(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null){
            return null;
        }
        long time = endDate.getTime() - beginDate.getTime();
        long hour = (time / (60 * 60 * 1000));
        long minute =((time / (60 * 1000)) - hour * 60);
        long second = (time / 1000  - hour * 60*  60 - minute * 60);
        return hour + "\u5c0f\u65f6" + minute + "\u5206" + second + "\u79d2";
    }
	
    public final static Date addDay(Date date,int addDays){
    	return strToYMDDate(calDate(date, 0, 0, addDays));
    }
    
    public final static Date addMonth(Date date,int addMonths){
    	return strToYMDDate(calDate(date, 0, addMonths, 0));
    }
    
    /**
	 * 把字符串转换成日期类型yyyy-MM-dd
	 */
	public static Date strToYMDDate(String str) {
		Date date = null;		
		try{
			if (!StringUtil.isEmpty(str)){
				if (str.length() >= 10) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					date = formatter.parse(str.substring(0, 10));
				}else{
					date = DateFormat.getDateInstance().parse(str);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return date;
	} 
	
	/**
	 * 获取当前日期字符串  指定日期格式
	 * 
	 * 格式为null  
	 * @param pattern
	 * 		默认：yyyyMMdd
	 * @return
	 */
    public static String dateFormat(final Date date, final String pattern) {
    	try {
    		DateFormat df = new SimpleDateFormat(pattern);
    		return df.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null ;
    }
    
	/**
	 * 获取当前日期字符串  指定日期格式
	 * 
	 * 格式为null  
	 * @param pattern
	 * 		默认：yyyyMMdd
	 * @return
	 */
    public static String currentDateString(final String pattern) {
    	if(pattern != null){
    		DateFormat df = new SimpleDateFormat(pattern);
    		return df.format(new Date());
    	}
    	DateFormat df = new SimpleDateFormat(DEFAULT_PATTERN_YMD);
        return df.format(new Date());
    }

    /**
     * 获得一天的最后时刻
     * @param date
     * @return
     */
    public static Date getLastMonmentOfDay(Date date) {
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.set(Calendar.HOUR_OF_DAY, 23);
    	calendar.set(Calendar.MINUTE, 59);
    	calendar.set(Calendar.SECOND, 59);
    	return calendar.getTime();
    }


    /**
     * 获得一天的初始时刻
     * @param date
     * @return
     */
    public static Date getFirstMomentOfDay(Date date) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    /**
     * 获取时间差 （天）
     * @param startDate
     * @param endDate
     * @return 相差天数 example 昨天于今天相差一天    
     * @author tsq
     */
    public static Integer getTimeDifference(Date startDate,Date endDate){
    	
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(startDate);
    	//防止时间参数影响日期计算 比如 20150901 09:00:00-20150831 10:00:00<1day
    	calendar.set(Calendar.HOUR_OF_DAY, 1);
    	Long startDay = calendar.getTimeInMillis();
    	calendar.setTime(endDate);
    	//若结束日期大于开始日期
    	if(endDate.after(startDate)){
    		calendar.set(Calendar.HOUR_OF_DAY, 2);
    	}else{
    		calendar.set(Calendar.HOUR_OF_DAY, 0);
    	}
    	Long endDay = calendar.getTimeInMillis();
    	return (int) ((endDay-startDay)/(24*60*60*1000));
    }
    /**
     * 获取时间距离当前时间差 （天）
     * @param startDate
     * @return 相差天数
     * @author tsq
     */
    public static Integer getTimeDifferenceToday(Date startDate){
    	return getTimeDifference(startDate,new Date());
    }
	public static void main(String[] args) throws Throwable{
	    Date date = DateUtil.strToDate("2015-08-21 12:00:00");
	    System.out.println(date.after(new Date()));
		System.out.println("ssss"+getTimeDifferenceToday(date));
		System.out.println(calDate("2014-05-01",0,0,-2));
		System.out.println(DateUtil.calDate(new Date(),0,0,-1,DateUtil.DEFAULT_PATTERN_YMD));
	}
}
