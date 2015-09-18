package com.tsq.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


/**
 * 字符串处理工具类,欢迎添加
 * @author tsq
 *
 */
public class StringUtil {
	/**
	 * 对象转换为字符串
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj){
		return obj==null?"":obj.toString();
	}
	/**
	 * @功能 判断字符串是否为空
	 * @说明 null或这trim().length==0 为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.trim().length() == 0;
	}

	/**
	 * @功能 将source根据指定的分界符delimiter，切成字符串数组
	 * @param source
	 *            源字符串
	 * @param delimiters
	 *            分界符
	 * @param trimTokens
	 *            切分出的字符串是否需要去除空格
	 * @param ignoreEmptyTokens
	 *            是否去除空字符串
	 * @return
	 */
	public static String[] split(String source, String delimiter,
			boolean trimTokens, boolean ignoreEmptyTokens){
		
		if (source==null||delimiter==null)
			return  new String[]{};
		
		StringTokenizer st = new StringTokenizer(source, delimiter);
		List<String> tokens = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (trimTokens) {
				token = token.trim();
			}
			if (!(ignoreEmptyTokens && token.length() == 0)) {
				tokens.add(token);
			}
		}
		return (String[]) tokens.toArray(new String[tokens.size()]);

	}

	/**
	 * @功能 将source根据指定的分界符集合，切成字符串数组
	 * @param source
	 *            源字符串
	 * @param delimiters
	 *            分界符集合
	 * @param trimTokens
	 *            切分出的字符串是否需要去除空格
	 * @param ignoreEmptyTokens
	 *            是否去除空字符串
	 * @return
	 */
	public static String[] split(String source, String[] delimiters,
			boolean trimTokens, boolean ignoreEmptyTokens){	
		if (source == null||delimiters==null)
			return  new String[]{};
		Pattern pattern = Pattern.compile("["+arrayToString(delimiters,"",false)+"]+");
		String[] strs = pattern.split(source);
		if (strs==null||strs.length==0)
			return null;
		List<String> result=new ArrayList<String>();
		if (trimTokens)
		{
			for (String str:strs)
			{
				str = str.trim();
			}
		}
		if(ignoreEmptyTokens)
		{
			for (String str:strs)
			{
				if (!isEmpty(str))
					result.add(str);
			}
		}
		if (result.size()==0)
			return null;
		return result.toArray(new String[]{});
	}
	/**
	 * @功能 将soure数组变成通过delimiter链接的字符串
	 * @param source
	 * @param delimiter
	 * @param appendTail
	 *            是否在字符串末尾增加delimiter
	 * @return
	 */
	public static <T> String arrayToString(T[] source, String delimiter,
			boolean appendTail) {
		if (source==null)
			return ""; 
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < source.length; i++) {
			if (i == 0) {
				bf.append(source[i]);
			} else {
				bf.append(delimiter + source[i]);
			}
		}
		if (appendTail) {
			bf.append(delimiter);
		}
		return bf.toString();
	}
}
