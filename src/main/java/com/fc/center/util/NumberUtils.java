package com.fc.center.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtils {
	
	public static BigDecimal isNull(BigDecimal money) {
		if (null == money) {
			return BigDecimal.ZERO;
		}
		return money;
	}

	public static double format(double d, String format) {
		DecimalFormat df = new DecimalFormat(format);
		String ds = df.format(d);
		return Double.parseDouble(ds);
	}

	public static double format2(double d) {
		DecimalFormat df = new DecimalFormat("0.00");
		String ds = df.format(d);
		return Double.parseDouble(ds);
	}

	private static final DecimalFormat df2 = new DecimalFormat("0.00");

	/**
	 * 保留两位小数，四舍五入
	 * 
	 * @param d
	 * @return
	 */
	/*
	 * public synchronized static String format2Str(double d){ String
	 * ds=df2.format(d); return ds; }
	 */

	/**
	 * 截取到小数点后两位，不进行四舍五入
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static String format2Str(double d) {
		df2.setRoundingMode(RoundingMode.FLOOR);
		String ds = df2.format(d);
		return ds;
	}

	public static double format4(double d) {
		DecimalFormat df = new DecimalFormat("0.0000");
		String ds = df.format(d);
		return Double.parseDouble(ds);
	}

	public static double format6(double d) {
		DecimalFormat df = new DecimalFormat("0.000000");
		String ds = df.format(d);
		return Double.parseDouble(ds);
	}

	public static double getDouble(String str) {
		if (str == null || str.equals(""))
			return 0.0;
		double ret = 0.0;
		try {
			ret = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			ret = 0.0;
		}
		return format6(ret);
	}

	public static long getLong(String str) {
		if (str == null || str.equals(""))
			return 0L;
		long ret = 0;
		try {
			ret = Long.parseLong(str);
		} catch (NumberFormatException e) {
			ret = 0;
		}
		return ret;
	}

	public static Long[] getLongs(String[] str) {
		if (str == null || str.length < 1)
			return new Long[0];
		Long[] ret = new Long[str.length];
		for (int i = 0; i < str.length; i++) {
			ret[i] = getLong(str[i]);
		}
		return ret;
	}

	// 截取数字
	public static long getStrNumber(String content) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			return getLong(matcher.group(0));
		}
		return 0;
	}

	public static int getInt(String str) {
		if (str == null || str.equals(""))
			return 0;
		int ret = 0;
		try {
			ret = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			ret = 0;
		}
		return ret;
	}

	public static int compare(double x, double y) {
		BigDecimal val1 = new BigDecimal(x);
		BigDecimal val2 = new BigDecimal(y);
		return val1.compareTo(val2);
	}

	/**
	 * 两个浮点型数据相加的精确算法
	 * 
	 * @param x
	 * @param y
	 * @return x+y
	 */
	public static double add(double x, double y) {
		BigDecimal xb = new BigDecimal(x + "");
		BigDecimal yb = new BigDecimal(y + "");
		return xb.add(yb).doubleValue();
	}

	/**
	 * 两个浮点型数据相减的精确算法
	 * 
	 * @param x
	 * @param y
	 * @return x-y
	 */
	public static double subStract(double x, double y) {
		BigDecimal xb = new BigDecimal(x + "");
		BigDecimal yb = new BigDecimal(y + "");
		return xb.subtract(yb).doubleValue();
	}

	/**
	 * 两个浮点型数据相乘的精确算法
	 * 
	 * @param x
	 * @param y
	 * @return x*y
	 */
	public static double multiply(double x, double y) {
		BigDecimal xb = new BigDecimal(x + "");
		BigDecimal yb = new BigDecimal(y + "");
		return xb.multiply(yb).doubleValue();
	}

	/**
	 * 两个浮点型数据相除的精确算法
	 * 
	 * @param x
	 * @param y
	 * @return x/y
	 */
	public static double divide(double x, double y) {
		BigDecimal xb = new BigDecimal(x + "");
		BigDecimal yb = new BigDecimal(y + "");
		return xb.divide(yb, 6, BigDecimal.ROUND_HALF_UP).doubleValue();// 保留六位小数，第七位四舍五入进位
	}

	/**
	 * @param d
	 * @param len
	 * @return
	 */
	public static double ceil(double d, int len) {
		/*
		 * String str=Double.toString(d); int a=str.indexOf(".");
		 * if(a+3>str.length()){ a=str.length(); }else{ a=a+3; }
		 * str=str.substring(0, a); return Double.parseDouble(str);
		 */
		DecimalFormat a = new DecimalFormat("#,##0.000000");
		String frmStr = a.format(d);
		String str = frmStr.substring(0, frmStr.indexOf(".") + 3);
		return Double.parseDouble(str);
	}

	public static double ceil(double d) {
		return ceil(d, 2);
	}
	/**
	 * 返回l1/l2 向上取整的值
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static Long ceil(Long l1, Long l2 ){
		return (l1%l2==0)? l1/l2:l1/l2 +1;
	}

}
