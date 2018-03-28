package com.wolverine.util;

import java.util.Collection;

public class StringUtils {
	
	/**
	 * 解析数组成字符串，以逗号分隔
	 * 
	 * @param inArr 数组
	 * @return 字符串，如inArr = {"1", "2"}，则retStr = "'1','2'"
	 */
	public static String parseArrayToStr(String[] inArr) {
		String retStr = null;
		if (inArr != null) {
			retStr = "";
			if (inArr.length > 0) {
				for (String ele : inArr) {
					if (ele == null) {
						ele = "";
					}
					retStr += "'" + ele + "',";
				}
				retStr = retStr.substring(0, retStr.length() - 1);
			}
		}
		return retStr;
	}
	
	/**
	 * 返回对象的字符串表达式
	 * 
	 * @param obj 对象
	 * @return 符串表达式，空对象时，返回""
	 */
	public static String nullToStr(Object obj) {
		String retStr = "";
		if (obj != null) {
			retStr = obj.toString();
		}
		return retStr;
	}
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param inStr 字符串
	 * @return true null，或""
	 *         false 其它
	 */
	public static boolean isEmpty(String inStr) {
		boolean retBoo = false;
		if (inStr == null || "".equals(inStr) || "null".equals(inStr) || "".equals(inStr.trim())) {
			retBoo = true;
		}
		return retBoo;
	}
	
	/**
	 * 判断字符串是否为空白
	 * 
	 * @param inStr 字符串
	 * @return true null，""，或" "等
	 *         false 其它
	 */
	public static boolean isBlank(String inStr) {
		boolean retBoo = false;
		if (isEmpty(inStr) || "".equals(inStr.trim())) {
			retBoo = true;
		}
		return retBoo;
	}
	
	/**
	 * 把字符串列表转换成字符串序列
	 * 
	 * @param strList
	 * @return 字符串序列，如"'1','2','','3'"
	 */
	public static String strListToStr(Collection<String> strList) {
		String retStr = "";
		if (strList != null && strList.size() > 0) {
			for (String str : strList) {
				retStr += "'" + nullToStr(str) + "',";
			}
			retStr = retStr.substring(0, retStr.length() - 1);
		}
		return retStr;
	}
	
	/**
	 * 删除浮点数后面多余的零
	 * 
	 * @param dou 双精度浮点数
	 * @return 删除后的字符串
	 */
	public static String douToStr(double dou) {
		String retStr = "";
		String douStr = String.valueOf(dou);
		int commaInx = douStr.indexOf(".");
		if (commaInx >= 0) {
			if (commaInx == 0) {
				retStr = "";
			} else {
				retStr = douStr.substring(0, commaInx);
			}
			if (commaInx  + 1 < douStr.length()) {
				String afterStr = douStr.substring(commaInx + 1);
				do {
					char lastChr = afterStr.charAt(afterStr.length() - 1);
					if (lastChr == '0') {
						afterStr = afterStr.substring(0, afterStr.length() - 1);
					} else {
						break;
					}
				} while (!"".equals(afterStr));
				if (!"".equals(afterStr)) {
					retStr = retStr + "." + afterStr;
				}
			}
		} else {
			retStr = douStr;
		}
		return retStr;
	}

	/**
	 * 判断是否有汉字
	 */
	public static boolean isChinese(String aa){
		for (int i = 0; i < aa.length(); i++) {
			String bb = aa.substring(i, i + 1);
			boolean cc = java.util.regex.Pattern.matches("[\u4E00-\u9FA5]", bb);
			if(cc){  
				return true ;
			}
		}
		return false ;
	}
}
