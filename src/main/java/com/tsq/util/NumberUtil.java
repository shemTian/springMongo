package com.tsq.util;

import java.math.BigDecimal;
import java.util.regex.Pattern;


public class NumberUtil {

	public static int parseInt(Object o){
		try {
			return Integer.parseInt(o==null?"0":o.toString());
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}
	public static Long parseLong(Object o){
		try {
			return Long.parseLong(o==null?"0":o.toString());
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}
	public static BigDecimal parseBigDecimal(Object fieldValue) {
		return new BigDecimal(fieldValue == null?"0":fieldValue.toString());
	}
	public static boolean isNumber(Object value){
		return Pattern.matches("\\d+|\\d+.\\d+", StringUtil.toString(value));
	}
}
