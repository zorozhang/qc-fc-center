package com.fc.center.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 说明：日期处理 创建人：Tanie QQ876003335 修改时间：2018年02月24日
 * 
 * @version
 */
public class DateUtil {

	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
	private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");
	private final static SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyyMM");
	/**
	 * 传进来日期返回yyyy-MM-dd HH:mm:ss格式的字符串
	 * @param date
	 * @return
	 */
	public static String dateStr4(Date date) {
		String str = sdfTime.format(date);
		return str;
	}
	/**
	 * 传进来日期返回yyyyMM格式的字符串
	 * @param date
	 * @return
	 */
	public static String dateStr5(Date date) {
		String str = sdfMonth.format(date);
		return str;
	}
	
	/**
	 * 传进来日期返回yyyyMMddHHmmss格式的字符串
	 * @param date
	 * @return
	 */
	public static String dateStr3(Date date) {
		String str = sdfTimes.format(date);
		return str;
	}
	
	
	/**
	 * 传进来日期返回yyyy-MM-dd格式的字符串
	 * @param date
	 * @return
	 */
	public static String dateStr2(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(date);
		return str;
	}	
	
	public static Date rollDate(Date d, int year, int mon, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, mon);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

//	private static final SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMddHHmmss");
//	private static final SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	private static final SimpleDateFormat format6 = new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss");
////	private static final SimpleDateFormat format5 = new SimpleDateFormat("yyyy/MM/dd");
//	private static final SimpleDateFormat format11 = new SimpleDateFormat("MM-dd HH:mm:ss");

	
	public static Map<String,Object> getApartTime(String Begin, String end) {
		  String[] temp = Begin.split("-");
	        String[] temp2 = end.split("-");
	        if (temp.length > 1 && temp2.length > 1) {
	            Calendar ends = Calendar.getInstance();
	            Calendar begin = Calendar.getInstance();

	            begin.set(NumberUtils.getInt(temp[0]),
	                    NumberUtils.getInt(temp[1]), NumberUtils.getInt(temp[2]));
	            ends.set(NumberUtils.getInt(temp2[0]),
	                    NumberUtils.getInt(temp2[1]), NumberUtils.getInt(temp2[2]));
	            if (begin.compareTo(ends) < 0) {
	                Map<String,Object> map = new HashMap<String,Object>();
	                ends.add(Calendar.YEAR, -NumberUtils.getInt(temp[0]));
	                ends.add(Calendar.MONTH, -NumberUtils.getInt(temp[1]));
	                ends.add(Calendar.DATE, -NumberUtils.getInt(temp[2]));
	                map.put("YEAR", ends.get(Calendar.YEAR));
	                map.put("MONTH", ends.get(Calendar.MONTH) + 1);
	                map.put("DAY", ends.get(Calendar.DATE));
	                return map;
	            }
	        }
	        return null;
	}
	
	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getSdfTimes() {
		return sdfTimes.format(new Date());
	}

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays() {
		return sdfDays.format(new Date());
	}

	
	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static Date getDays(String date) {
		try {
			return sdfDays.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	 * @Title: compareDate
	 * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws @author
	 *             fh
	 */
	public static boolean compareDate(String s, String e) {
		if (fomatDate(s) == null || fomatDate(e) == null) {
			return false;
		}
		return fomatDate(s).getTime() >= fomatDate(e).getTime();
	}

	/**
	 * @Title: compareDateGt
	 * @Description: TODO(日期比较，如果s>e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws @author
	 *             fh
	 */
	public static boolean compareDateGt(String s, String e) {
		if (fomatDate(s) == null || fomatDate(e) == null) {
			return false;
		}
		return fomatDate(s).getTime() > fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Date fomatDate2(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate2(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	
	/**
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// long aa=0;
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24))
					/ 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(beginDateStr.length()==13){
			long lt = new Long(beginDateStr);
			Date date = new Date(lt);
			beginDateStr = simpleDateFormat.format(date);
		}
		if(endDateStr.length()==13){
			long ltend = new Long(endDateStr);
			Date dateend = new Date(ltend);
			endDateStr = simpleDateFormat.format(dateend);
		}
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}
	
	public static Date getAfterDayDate(int days) {
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动

		return canlendar.getTime();
	}
	
	public static Date getAfterDayDate(Date date, int days) {
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.setTime(date);
		canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动

		return canlendar.getTime();
	}
	
	public static Date getAfterMonthFirstDate() {
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.set(Calendar.MONTH, canlendar.get(Calendar.MONTH)+1); 
		canlendar.set(Calendar.DAY_OF_MONTH, 1);		
		return canlendar.getTime();
	}
	
	public static Date getAfterMonthFirstDate(int i) {
		Calendar calendar = Calendar.getInstance(); // java.util包
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.MONTH, i);
		return calendar.getTime();
	}
	/**
	 * 获得每个月几号
	 * @return
	 */
	public static Date getAfterMonthDayDate(int i) {
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.set(Calendar.MONTH, canlendar.get(Calendar.MONTH)); 
		canlendar.set(Calendar.DAY_OF_MONTH, i);		
		return canlendar.getTime();
	}
	
	/**
	 * 得到n天之后是周几
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	public static int getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}

	public static String getToday0() {
		Calendar monEight = Calendar.getInstance();
		monEight.set(Calendar.HOUR_OF_DAY, 00);
		monEight.set(Calendar.MINUTE, 00);
		monEight.set(Calendar.SECOND, 00);
		return sdfTime.format(monEight.getTime());
	}

	public static String getToday24() {
		Calendar monEight = Calendar.getInstance();
		monEight.set(Calendar.HOUR_OF_DAY, 23);
		monEight.set(Calendar.MINUTE, 59);
		monEight.set(Calendar.SECOND, 59);
		return sdfTime.format(monEight.getTime());
	}

	public static String getTimeTakeDate(Date date, int huor, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, huor);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		return sdfTime.format(calendar.getTime());
	}
	/**
	 * 返回在指定日期上加n天后的日期
	 * @author mjl
	 * @date 2018年4月25日  
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getTimeTakeDateAddDuration(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, +n);// +1今天的时间加一天
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String fmtDate(Date date) {
		return sdfDay.format(date);
	}

	/**
	 * 在当前日期上加天数
	 * 
	 * @param args
	 */
	public static Date getAfterDay(String start, Integer duration) {
		// 将开始日期加上租用周期
		try {
			Date startDate = sdfDay.parse(start);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			calendar.add(Calendar.DATE, duration);
			return calendar.getTime();
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static boolean isLastDayOfMonth(Date date) { 
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date); 
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1)); 
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) { 
            return true; 
        } 
        return false; 
    }
    //给定年份，获取分组月份以及起始日期
	public static List getMonth(int Cyear) {
		Calendar c = Calendar.getInstance();
		List<Map> strs = new ArrayList<Map>();
		c.set(Calendar.YEAR, Cyear);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String gtimelast = sdf.format(c.getTime()); //当月
		while(c.get(Calendar.YEAR)==Cyear){
			Map map = new HashMap();
			int lastMonthMaxDay=c.getActualMaximum(Calendar.DAY_OF_MONTH);
			c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), lastMonthMaxDay, 23, 59, 59);

			//按格式输出
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-01  00:00:00");
			String gtime2 = sdf2.format(c.getTime()); //上月第一天
			System.out.println(gtime2);
			String gtime = sdf.format(c.getTime()); //上月最后一天
			System.out.println(gtime);
			map.put("month",c.get(Calendar.MONTH)+1);
			map.put("start",gtime2);
			map.put("end",gtime);
			c.add(Calendar.MONTH, 1);
			strs.add(map);
		}
        return strs;
    }
	/**
	 * 比较2个日期的年和月是否相同，相同返回true，否则false
	 * @author mjl
	 * @date 2018年6月6日  
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameYearAndMonth(Date date1,Date date2){
		if (date1==null||date2==null) {
			return false;
		}
		Calendar cal1 = Calendar.getInstance();  
	    cal1.setTime(date1);  
	    Calendar cal2 = Calendar.getInstance();  
	    cal2.setTime(date2);  
		return cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH);
	}
	public static void main(String[] args) {
		Date date=getAfterMonthFirstDate(2);
		System.out.println(dateStr3(date));
	}
	
	/**
    * 判断时间是否在时间段内
    * @param nowTime
    * @param beginTime
    * @param endTime
    * @return
    */
   public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
       Calendar date = Calendar.getInstance();
       date.setTime(nowTime);

       Calendar begin = Calendar.getInstance();
       begin.setTime(beginTime);

       Calendar end = Calendar.getInstance();
       end.setTime(endTime);

       if (date.after(begin) && date.before(end)) {
           return true;
       } else {
           return false;
       }
   }
   
}
