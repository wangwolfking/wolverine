package com.wolverine.pass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.StringTokenizer;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import com.wolverine.util.StringUtil;
import com.wolverine.util.constants.BossCommonConstants;
import com.wolverine.util.exception.CheckException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DataPassUtil {
	private String code = "UTF-16BE";

	/**
	 * 判断是否已加密
	 * @param data 数据
	 * @return encryptType 加密类型【ZIP|HEX】
	 * @throws Exception
	 */
	public static boolean checkEncrypt(String data,String encryptType){
		try {
			if ( null == encryptType || "".equals(encryptType) ) {
				throw new CheckException("encryptType is null "); 
			}
			if (null == data || "".equals(data)){
				throw new CheckException("data is null "); 
			}
			if ( data.startsWith(BossCommonConstants.PASSPREFIX+encryptType)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 判断是否已加密
	 * 默认验证hex加密
	 * @param adatata
	 * @return
	 * @throws Exception
	 */
	public static boolean checkEncrypt(String data) {
		return checkEncrypt(data, BossCommonConstants.HEX);
	}

	public static String unPassFieldData(String value) {
		try {
			if ( StringUtil.isEmpty(value) ) return "" ;
			String prefix = BossCommonConstants.PASSPREFIX;
			if (!value.startsWith(prefix)) {
				return value;
			}

			String srcStr = value;
			if (value.startsWith(prefix + BossCommonConstants.ZIPLIB)) {
				srcStr = srcStr.substring((prefix + BossCommonConstants.ZIPLIB)
						.length());

				return ungzip(srcStr);
			} else if (value.startsWith(prefix + BossCommonConstants.HEX)) {
				srcStr = srcStr.substring((prefix + BossCommonConstants.HEX)
						.length());

				return new String(hexStr2ByteArr(srcStr),"UTF-8");
			}

			return value;
		} catch (Exception e) {
			return value;
		}
	}

	public static String passFieldData(String value) {
		return passFieldData(value, BossCommonConstants.HEX);
	}
	
	/**
	 * 去除前缀
	 * @param value
	 * @return
	 */
	public static String passFieldDataQuery(String value){
		if ( null == value || "".equals(value) ) return value ;
		String values =  passFieldData(value, BossCommonConstants.HEX);
		String ph = BossCommonConstants.PASSPREFIX + BossCommonConstants.HEX ;
		values = values.substring(ph.length());
		return values ;
	}
	
	public static String passFieldData(String value, String passType) {
		try {
			if (passType == null || passType.equals("") || value == null
					|| value.equals("")) {
				return value;
			}

			String data = value;

			if (passType.equals(BossCommonConstants.ZIPLIB)) {
				data = BossCommonConstants.PASSPREFIX
						+ BossCommonConstants.ZIPLIB
						+ gzipData(value.getBytes());
			} else if (passType.equals(BossCommonConstants.HEX)) {
				data = BossCommonConstants.PASSPREFIX + BossCommonConstants.HEX
						+ byteArr2HexStr(value.getBytes("UTF-8"));
			}

			return data;
		} catch (Exception e) {
			return value;
		}

	}

	private static String hex2(byte[] bytes, boolean isIndex)
			throws Exception {
		// TODO Auto-generated method stub

		String str = "";
		for (int iLoop = 0; iLoop < bytes.length; iLoop++) {
			int offset = 0;
			if (isIndex) {
				offset = iLoop;
			}
			bytes[iLoop] = (byte) (bytes[iLoop] + offset);
			String hexStr = Integer.toHexString(bytes[iLoop]);

			if (iLoop == 0) {
				str = "{" + bmData(hexStr) + "}";
			} else {
				str += "{" + bmData(hexStr) + "}";
			}

		}
		return str;
	}

	private static String unHex2(String srcStr, boolean isIndex)
			throws Exception {
		// TODO Auto-generated method stub

		int iLoop = 0;
		StringTokenizer stoken = new StringTokenizer(srcStr, "}");
		String[] data = new String[stoken.countTokens()];
		while (stoken.hasMoreElements()) {
			try {
				String tokenStr = (String) stoken.nextElement();
				data[iLoop] = tokenStr.substring(1);
				data[iLoop] = unBmData(data[iLoop]);
				iLoop++;
			} catch (Exception ex) {
				System.out.println("Error iLoop:" + iLoop);
			}

		}

		byte[] outData = new byte[data.length];

		int offset = 0;
		for (iLoop = 0; iLoop < data.length; iLoop++) {
			long bdata = Long.parseLong(data[iLoop], 16);

			if (isIndex) {
				offset = iLoop;
			}
			bdata = bdata - offset;
			outData[iLoop] = (byte) bdata;
		}

		return new String(outData);
	}

	private static String bmData(String hexStr) {
		if (hexStr == null || hexStr.equals(""))
			return hexStr;
		int strLen = hexStr.length();
		String temStr = "";
		int icount = 1;
		int jLoop = 0;
		boolean found = false;
		for (int iLoop = 0; iLoop < strLen;) {
			icount = 1;
			char c = hexStr.charAt(iLoop);
			for (jLoop = iLoop + 1; jLoop < strLen; jLoop++) {
				char jc = hexStr.charAt(jLoop);
				if (c == jc) {
					icount++;
				} else {
					break;
				}
			}

			if (icount > 1) {
				String kTemStr = "[" + icount + c + "]";
				temStr = temStr + kTemStr;
				iLoop = jLoop;
			} else {
				temStr += c;
				iLoop++;
			}

		}

		if (temStr != null && !temStr.equals("")) {
			hexStr = temStr;
		}

		return hexStr;
	}

	private static String unBmData(String hexStr) {
		String outStr = hexStr;
		String tempStr = "";
		int jLoop = 0;

		String[] tempData = hexStr.split("\\[");
		for (jLoop = 0; jLoop < tempData.length; jLoop++) {
			String selStr = tempData[jLoop];
			int iLength = selStr.length();
			for (int kLoop = 0; kLoop < iLength; kLoop++) {
				char c = selStr.charAt(kLoop);
				if (c != ']') {
					continue;
				}

				String tcstr = "";
				String cstr = selStr.substring(0, kLoop);
				String remainStr = selStr.substring(kLoop + 1);

				String iSelStr = cstr.substring(0, cstr.length() - 1);
				String cSelStr = cstr.substring(cstr.length() - 1);
				int istrCount = Integer.parseInt(iSelStr);
				for (int tLoop = 0; tLoop < istrCount; tLoop++) {
					tcstr += cSelStr;
				}

				tcstr += remainStr;

				tempStr = tempStr + tcstr;
			}

		}

		if (tempStr != null && !tempStr.equals("")) {
			return tempStr;
		}

		return outStr;
	}

	private static String gzipData(byte[] data) throws Exception {

		ByteArrayOutputStream bArray = new ByteArrayOutputStream();

		DeflaterOutputStream gz = new DeflaterOutputStream(bArray);
		gz.write(data);
		gz.finish();
		gz.close();

		data = bArray.toByteArray();

		BASE64Encoder base64Encode = new BASE64Encoder();
		String bes = base64Encode.encode(data);

		return bes;
	}

	private static String ungzip(String srcData) throws Exception {

		byte data[] = srcData.getBytes();

		BASE64Decoder decode = new BASE64Decoder();
		byte[] stream = decode.decodeBuffer(new String(data));

		ByteArrayInputStream bArray = new ByteArrayInputStream(stream);
		InflaterInputStream gs = new InflaterInputStream(bArray);

		ByteArrayOutputStream zipOut = new ByteArrayOutputStream(1024);
		int i = 1024;
		byte[] tempBuf = new byte[i];
		while ((i = gs.read(tempBuf, 0, i)) > 0) {
			zipOut.write(tempBuf, 0, i);
		}
		gs.close();

		return new String(zipOut.toByteArray()).trim();
	}

	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i] + 100;
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			
			if (i > 0){
				sb.append("-");
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			String temp = Integer.toString(intTmp, 16);
			temp = temp.toUpperCase();
			
			sb.append(temp);
			
		}
		return sb.toString();
	}

	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		strIn = strIn.replaceAll("-", "");
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) (Integer.parseInt(strTmp, 16) - 100);
		}
		return arrOut;
	}

	public static void main(String[] args) throws Exception { 
		String name = "{$$$$}{H}49-F8-F4-48-1F-07-4C-EF-15"; 
		System.out.println(unPassFieldData(name)); 
		System.out.println(passFieldData("裴盛厚"));  
		
		//System.out.println(passFieldData("新产品"));
		
		
/*		链接数据库解密用程序 
	    Connection con = null;// 创建一个数据库连接
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result = null;// 创建一个结果集对象
	    try{
	        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");
	        String url = "jdbc:oracle:" + "thin:@139.196.231.192:7356:YOCALYDB";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "yocalyadmin";// 用户名,系统默认的账户名
	        String password = "yocaly789";// 你安装时选设置的密码
	        con = DriverManager.getConnection(url, user, password);// 获取连接
	        System.out.println("连接成功！");
	        String sql = "SELECT ID , C_USERNAME FROM TMPG_ECGmianyang";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
//	        pre.setString(1, "刘显安");// 设置参数，参数的索引从1开始，而不是表中列名的索引
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	        while (result.next()){
	            // 当结果集不为空时
	        	String str = result.getString("C_USERNAME");
//	            System.out.println("解密前:" + str  + "解密后姓名:"
//	                    + unPassFieldData(str));
	            
	            String uSql = "update TMPG_ECGmianyang set C_NAMENEW = ? where ID = ?";
	            
	            PreparedStatement upre = con.prepareStatement(uSql);
	            upre.setString(1, unPassFieldData(str));
	            upre.setInt(2, result.getInt("ID"));
	            
	            int i = upre.executeUpdate();
	            System.out.println(result.getInt("ID")+":"+i);
	            upre.close();
	        }
	    }catch (Exception e){
	        e.printStackTrace();
	    }finally {
	        try
	        {
	            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
	            // 注意关闭的顺序，最后使用的最先关闭
	            if (result != null)
	                result.close();
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("数据库连接已关闭！");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
*/		
		
//		
		//String data1 = "谢兆诚";
		//System.out.println(passFieldData(data1));
		

	} 
}
