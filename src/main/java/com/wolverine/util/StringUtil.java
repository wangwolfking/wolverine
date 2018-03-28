package com.wolverine.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static String add(String s, String add) {
		return add(s, add, StringPool.COMMA);
	}

	public static String add(String s, String add, String delimiter) {
		return add(s, add, delimiter, false);
	}

	public static String add(String s, String add, String delimiter,
			boolean allowDuplicates) {

		if ((add == null) || (delimiter == null)) {
			return null;
		}

		if (s == null) {
			s = StringPool.BLANK;
		}

		if (allowDuplicates || !contains(s, add, delimiter)) {
			if (Validator.isNull(s) || s.endsWith(delimiter)) {
				s += add + delimiter;
			} else {
				s += delimiter + add + delimiter;
			}
		}

		return s;
	}

	public static boolean contains(String s, String text) {
		return contains(s, text, StringPool.COMMA);
	}

	public static boolean contains(String s, String text, String delimiter) {
		if ((s == null) || (text == null) || (delimiter == null)) {
			return false;
		}

		if (!s.endsWith(delimiter)) {
			s += delimiter;
		}

		int pos = s.indexOf(delimiter + text + delimiter);

		if (pos == -1) {
			if (s.startsWith(text + delimiter)) {
				return true;
			}

			return false;
		}

		return true;
	}

	public static int count(String s, String text) {
		if ((s == null) || (text == null)) {
			return 0;
		}

		int count = 0;

		int pos = s.indexOf(text);

		while (pos != -1) {
			pos = s.indexOf(text, pos + text.length());
			count++;
		}

		return count;
	}

	public static boolean endsWith(String s, char end) {
		return startsWith(s, (new Character(end)).toString());
	}

	public static boolean endsWith(String s, String end) {
		if ((s == null) || (end == null)) {
			return false;
		}

		if (end.length() > s.length()) {
			return false;
		}

		String temp = s.substring(s.length() - end.length(), s.length());

		if (temp.equalsIgnoreCase(end)) {
			return true;
		} else {
			return false;
		}
	}

	public static String extractChars(String s) {
		if (s == null) {
			return "";
		}

		char[] c = s.toCharArray();

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < c.length; i++) {
			if (Validator.isChar(c[i])) {
				sb.append(c[i]);
			}
		}

		return sb.toString();
	}

	public static String extractDigits(String s) {
		if (s == null) {
			return "";
		}

		char[] c = s.toCharArray();

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < c.length; i++) {
			if (Validator.isDigit(c[i])) {
				sb.append(c[i]);
			}
		}

		return sb.toString();
	}

	public static String extractFirst(String s, String delimiter) {
		if (s == null) {
			return null;
		} else {
			String[] array = split(s, delimiter);

			if (array.length > 0) {
				return array[0];
			} else {
				return null;
			}
		}
	}

	public static String extractLast(String s, String delimiter) {
		if (s == null) {
			return null;
		} else {
			String[] array = split(s, delimiter);

			if (array.length > 0) {
				return array[array.length - 1];
			} else {
				return null;
			}
		}
	}

	public static String lowerCase(String s) {
		if (s == null) {
			return null;
		} else {
			return s.toLowerCase();
		}
	}

	public static String merge(List list) {
		return merge(list, StringPool.COMMA);
	}

	public static String merge(List list, String delimiter) {
		return merge((String[]) list.toArray(new String[0]), delimiter);
	}

	public static String merge(String[] array) {
		return merge(array, StringPool.COMMA);
	}

	public static String merge(String[] array, String delimiter) {
		if (array == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < array.length; i++) {
			sb.append(array[i].trim());

			if ((i + 1) != array.length) {
				sb.append(delimiter);
			}
		}

		return sb.toString();
	}

	public static String randomize(String s) {
		Randomizer r = new Randomizer();

		return r.randomize(s);
	}

	public static String read(ClassLoader classLoader, String name)
			throws IOException {

		return read(classLoader.getResourceAsStream(name));
	}

	public static String read(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		StringBuffer sb = new StringBuffer();
		String line = null;

		while ((line = br.readLine()) != null) {
			sb.append(line).append('\n');
		}

		br.close();

		return sb.toString().trim();
	}

	public static String remove(String s, String remove) {
		return remove(s, remove, StringPool.COMMA);
	}

	public static String remove(String s, String remove, String delimiter) {
		if ((s == null) || (remove == null) || (delimiter == null)) {
			return null;
		}

		if (Validator.isNotNull(s) && !s.endsWith(delimiter)) {
			s += delimiter;
		}

		while (contains(s, remove, delimiter)) {
			int pos = s.indexOf(delimiter + remove + delimiter);

			if (pos == -1) {
				if (s.startsWith(remove + delimiter)) {
					s = s.substring(remove.length() + delimiter.length(), s
							.length());
				}
			} else {
				s = s.substring(0, pos)
						+ s.substring(pos + remove.length()
								+ delimiter.length(), s.length());
			}
		}

		return s;
	}

	public static String replace(String s, char oldSub, char newSub) {
		return replace(s, oldSub, new Character(newSub).toString());
	}

	public static String replace(String s, char oldSub, String newSub) {
		if ((s == null) || (newSub == null)) {
			return null;
		}

		char[] c = s.toCharArray();

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < c.length; i++) {
			if (c[i] == oldSub) {
				sb.append(newSub);
			} else {
				sb.append(c[i]);
			}
		}

		return sb.toString();
	}

	public static String replace(String s, String oldSub, String newSub) {
		if ((s == null) || (oldSub == null) || (newSub == null)) {
			return null;
		}

		int y = s.indexOf(oldSub);

		if (y >= 0) {
			StringBuffer sb = new StringBuffer();

			int length = oldSub.length();
			int x = 0;

			while (x <= y) {
				sb.append(s.substring(x, y));
				sb.append(newSub);
				x = y + length;
				y = s.indexOf(oldSub, x);
			}

			sb.append(s.substring(x));

			return sb.toString();
		} else {
			return s;
		}
	}

	public static String replace(String s, String[] oldSubs, String[] newSubs) {
		if ((s == null) || (oldSubs == null) || (newSubs == null)) {
			return null;
		}

		if (oldSubs.length != newSubs.length) {
			return s;
		}

		for (int i = 0; i < oldSubs.length; i++) {
			s = replace(s, oldSubs[i], newSubs[i]);
		}

		return s;
	}

	public static String reverse(String s) {
		if (s == null) {
			return null;
		}

		char[] c = s.toCharArray();
		char[] reverse = new char[c.length];

		for (int i = 0; i < c.length; i++) {
			reverse[i] = c[c.length - i - 1];
		}

		return new String(reverse);
	}

	public static String shorten(String s) {
		return shorten(s, 20);
	}

	public static String shorten(String s, int length) {
		return shorten(s, length, "..");
	}

	public static String shorten(String s, String suffix) {
		return shorten(s, 20, suffix);
	}

	public static String shorten(String s, int length, String suffix) {
		if (s == null || suffix == null) {
			return null;
		}

		if (s.length() > length) {
			s = s.substring(0, length) + suffix;
		}

		return s;
	}

	public static String[] split(String s) {
		return split(s, StringPool.COMMA);
	}

	public static String[] split(String s, String delimiter) {
		if (s == null || delimiter == null) {
			return new String[0];
		}

		s = s.trim();

		if (!s.endsWith(delimiter)) {
			s += delimiter;
		}

		if (s.equals(delimiter)) {
			return new String[0];
		}

		List nodeValues = new ArrayList();

		if (delimiter.equals("\n") || delimiter.equals("\r")) {
			try {
				BufferedReader br = new BufferedReader(new StringReader(s));

				String line = null;

				while ((line = br.readLine()) != null) {
					nodeValues.add(line);
				}

				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else {
			int offset = 0;
			int pos = s.indexOf(delimiter, offset);

			while (pos != -1) {
				nodeValues.add(s.substring(offset, pos));

				offset = pos + delimiter.length();
				pos = s.indexOf(delimiter, offset);
			}
		}

		return (String[]) nodeValues.toArray(new String[0]);
	}

	public static boolean[] split(String s, String delimiter, boolean x) {
		String[] array = split(s, delimiter);
		boolean[] newArray = new boolean[array.length];

		for (int i = 0; i < array.length; i++) {
			boolean value = x;

			try {
				value = Boolean.valueOf(array[i]).booleanValue();
			} catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static double[] split(String s, String delimiter, double x) {
		String[] array = split(s, delimiter);
		double[] newArray = new double[array.length];

		for (int i = 0; i < array.length; i++) {
			double value = x;

			try {
				value = Double.parseDouble(array[i]);
			} catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static float[] split(String s, String delimiter, float x) {
		String[] array = split(s, delimiter);
		float[] newArray = new float[array.length];

		for (int i = 0; i < array.length; i++) {
			float value = x;

			try {
				value = Float.parseFloat(array[i]);
			} catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static int[] split(String s, String delimiter, int x) {
		String[] array = split(s, delimiter);
		int[] newArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			int value = x;

			try {
				value = Integer.parseInt(array[i]);
			} catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static long[] split(String s, String delimiter, long x) {
		String[] array = split(s, delimiter);
		long[] newArray = new long[array.length];

		for (int i = 0; i < array.length; i++) {
			long value = x;

			try {
				value = Long.parseLong(array[i]);
			} catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static short[] split(String s, String delimiter, short x) {
		String[] array = split(s, delimiter);
		short[] newArray = new short[array.length];

		for (int i = 0; i < array.length; i++) {
			short value = x;

			try {
				value = Short.parseShort(array[i]);
			} catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static boolean startsWith(String s, char begin) {
		return startsWith(s, (new Character(begin)).toString());
	}

	public static boolean startsWith(String s, String start) {
		if ((s == null) || (start == null)) {
			return false;
		}

		if (start.length() > s.length()) {
			return false;
		}

		String temp = s.substring(0, start.length());

		if (temp.equalsIgnoreCase(start)) {
			return true;
		} else {
			return false;
		}
	}

	public static String trimLeading(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i))) {
				return s.substring(i, s.length());
			}
		}

		return StringPool.BLANK;
	}

	public static String trimTrailing(String s) {
		for (int i = s.length() - 1; i >= 0; i--) {
			if (!Character.isWhitespace(s.charAt(i))) {
				return s.substring(0, i + 1);
			}
		}

		return StringPool.BLANK;
	}

	public static String upperCase(String s) {
		if (s == null) {
			return null;
		} else {
			return s.toUpperCase();
		}
	}

	public static String wrap(String text) {
		return wrap(text, 80, "\n");
	}

	public static String wrap(String text, int width, String lineSeparator) {
		if (text == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer();

		try {
			BufferedReader br = new BufferedReader(new StringReader(text));

			String s = StringPool.BLANK;

			while ((s = br.readLine()) != null) {
				if (s.length() == 0) {
					sb.append(lineSeparator);
				} else {
					String[] tokens = s.split(StringPool.SPACE);
					boolean firstWord = true;
					int curLineLength = 0;

					for (int i = 0; i < tokens.length; i++) {
						if (!firstWord) {
							sb.append(StringPool.SPACE);
							curLineLength++;
						}

						if (firstWord) {
							sb.append(lineSeparator);
						}

						sb.append(tokens[i]);

						curLineLength += tokens[i].length();

						if (curLineLength >= width) {
							firstWord = true;
							curLineLength = 0;
						} else {
							firstWord = false;
						}
					}
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return sb.toString();
	}

	public static String substring(String str, int len) {
		if (str == null || str.equals("") || str.equals("null")
				|| str.length() == 0)
			return null;
		if (str.length() < len)
			return null;

		return str.substring(0, len);
	}

	public static String substring(String str, int begin, int end) {
		if (str == null || str.equals("") || str.equals("null")
				|| str.length() == 0)
			return null;
		if (str.length() < end)
			return null;

		return str.substring(begin, end);
	}
	
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
		if (inStr == null || "".equals(inStr) || "null".toLowerCase().equals(inStr.toLowerCase()) || "".equals(inStr.trim())) {
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
	
	 public static String getEncoding(String str) {
	        String encode = "GB2312"; 
	        try { 
	            if (str.equals(new String(str.getBytes(encode), encode))) { 
	                String s = encode; 
	                return s; 
	            } 
	        } catch (Exception exception) { 
	        } 
	        encode = "ISO-8859-1"; 
	        try { 
	            if (str.equals(new String(str.getBytes(encode), encode))) { 
	                String s1 = encode; 
	                return s1; 
	            } 
	        } catch (Exception exception1) { 
	        } 
	        encode = "UTF-8"; 
	        try { 
	            if (str.equals(new String(str.getBytes(encode), encode))) { 
	                String s2 = encode; 
	                return s2; 
	            } 
	        } catch (Exception exception2) { 
	        } 
	        encode = "GBK";
	        try { 
	            if (str.equals(new String(str.getBytes(encode), encode))) { 
	                String s3 = encode; 
	                return s3; 
	            } 
	        } catch (Exception exception3) { 
	        } 
	        return ""; 
	 }
	/**
	 * 获取字符数据 如果为空转换成空字符串
	 * @param inStr 字符数据
	 */
	public static String getValStr(String inStr) {
		if (inStr == null || "".equals(inStr)  || "".equals(inStr.trim()) || "null".toLowerCase().equals(inStr.trim().toLowerCase())) {
			inStr = "";
		}
		return inStr.trim();
	}

	public static Double toDouble(Object object) {
		Double v = 0.00 ;
		if ( null != object ) {
			try{v=Double.parseDouble(object.toString());}catch(Exception e){}
		} 
		return v;
	}

	public static Integer toInteger(Object object) {
		Integer v = -1 ;
		if ( null != object ) {
			try{v=Integer.parseInt(object.toString());}catch(Exception e){}
		} 
		return v;
	}

	public static String toString(Object object) {
		return getValStr(object+"");
	}

	public static Date toDate(Object object) {
		try{
			return (Date)object;
		}catch(Exception e){
			return null;
		}
	}

	public static boolean isDate(String birthday, String format) {
		try{
			new SimpleDateFormat(format).parse(birthday) ;
			return true ;
		}catch(Exception e){
			return false ;
		}
	}
	/** 
     * 手机号验证 
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isMobile(String str) {
    	str = str.trim() ;
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3-8][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str.trim());  
        b = m.matches();   
        return b;  
    }
    /**
     * 验证座机
     * @param linkphone
     */
    public static boolean isPhone(String linkphone) {   
    	 String reg="(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|" +  
         "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";  
    	 	return Pattern.matches(reg, linkphone);  
	}  
    
	public static boolean isInt(String height) {
		try{
			Integer.parseInt(height);
			return true ;
		}catch(Exception e){
			return false ;
		}
	}
	
	

}
