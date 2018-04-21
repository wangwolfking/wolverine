package com.wolverine.file.md5;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
		'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 将文件读取到内存进行MD5适合小文件
	 */
	public static String getFileMD5StringMemory(File file) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
	   FileInputStream in = new FileInputStream(file);
	   FileChannel ch = in.getChannel();
	   MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
	   md5.update(byteBuffer);
	   return bufferToHex(md5.digest());
	}
	/**
	 * 将文件读取到内存进行MD5适合小文件
	 */
	public static String getFileMD5String(File file) throws Exception {
		 FileInputStream in = null ;
		 String value = null ;
		 try{
//			 SystemOut.out(file.getAbsolutePath()+",size:"+file.length());
			 in = new FileInputStream(file);
			 byte[] cache = new byte[8192];
			 MessageDigest md5 = MessageDigest.getInstance("MD5");
			 int i=0;
			 while((i=in.read(cache))!=-1){
				 md5.update(cache,0,i);
			 }
		     value = bufferToHex(md5.digest());
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 try{
			 if ( null != in ) in.close();
			 }catch(Exception e){}
		 }
		 return value ;
	 }
	/**
	 * MD5 字符串
	 */
	public static String getMD5String(String s) {
		MessageDigest md5 = null ;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.update(s.getBytes());
		BigInteger bi = new BigInteger(1, md5.digest());
	    return bi.toString(16);
	}
	
	private static String bufferToHex(byte bytes[]) {
	   return bufferToHex(bytes, 0, bytes.length);
	}
	private static String bufferToHex(byte bytes[], int m, int n) {
	   StringBuffer stringbuffer = new StringBuffer(2 * n);
	   int k = m + n;
	   for (int l = m; l < k; l++) {
	    appendHexPair(bytes[l], stringbuffer);
	   }
	   return stringbuffer.toString();
	}
	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
	   char c0 = hexDigits[(bt & 0xf0) >> 4];
	   char c1 = hexDigits[bt & 0xf];
	   stringbuffer.append(c0);
	   stringbuffer.append(c1);
	}
	
	public static void main(String[] args) throws Exception {
		long begin = System.currentTimeMillis();
	
		File big = new File("C:\\f62c5b3a3f179c4e33082fb4437eb631\\f62c5b3a3f179c4e33082fb4437eb631.zip");
		String md5 = getFileMD5String(big);
		//String md5 = getMD5String("a");
		long end = System.currentTimeMillis();
		System.out.println("md5:" + md5 + " time:" + ((end - begin) / 1000)+ "s"+md5.length());
	//	System.out.println("md5:" + md51 + " time:" + ((end - begin) / 1000)+ "s");
	}
}