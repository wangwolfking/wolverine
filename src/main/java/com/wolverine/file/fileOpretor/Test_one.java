package com.wolverine.file.fileOpretor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.wolverine.file.md5.MD5;

public class Test_one {

	public static void main(String[] args) throws Exception {
		// try {
		//// readZipFile("D:\\zip\\8d0d001dbfe69994478a0925a6ce0f06_2015100511981.zip");
		// test1("D:\\zip\\8d0d001dbfe69994478a0925a6ce0f06_2015100511981.zip");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
//		test();
//		String str= "er=er";
//		System.out.println(str.indexOf("_"));
		moveFile();
	}

	public static void test() {
		try {
			if (1 == 1) {
				throw new Exception("上传失败，压缩文件不完整或已损坏，请重新上传");
			}
			System.out.println(123);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void moveFile() {
		try {
			File afile = new File("d:\\zip2\\fe10b0d9da88fe6e82445b9ccb17ef97_2015100511411.zip");
			System.out.println(afile.getAbsolutePath());
			if (afile.renameTo(new File("d:\\zip1" +File.separator+ afile.getName()))) {
				System.out.println("File is moved successful!");
			} else {
				System.out.println("File is failed to move!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readZipFile(String file) throws Exception {
		ZipFile zf = new ZipFile(file);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ZipInputStream zin = new ZipInputStream(in);
		ZipEntry ze;
		while ((ze = zin.getNextEntry()) != null) {
			zin.closeEntry();
			if (ze.isDirectory()) {
			} else {
				ze.setMethod(ZipEntry.STORED);//
				System.err.println("file - " + ze.getName() + " : " + ze.getSize() + " bytes");
				long size = ze.getSize();
				if (size < 0) { // 使用时要修改此处
					BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze)));
					String line;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}
					br.close();
				}
				System.out.println();
			}
		}
		zin.closeEntry();
	}

	public static void test1(String filepath) throws IOException {
		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(filepath));
		ZipEntry zipEntry;
		while ((zipEntry = zipIn.getNextEntry()) != null) {
			zipIn.closeEntry();
			if (!zipEntry.isDirectory()) {
				String name = zipEntry.getName();
				// File f = new File(name);
				// System.out.printf(MD5.getFileMD5String(f));
				long size = zipEntry.getSize();
				long compd = zipEntry.getCompressedSize();
				System.out.printf("%s , size=%d, compressed size=%d\r\n", name, size, compd);
			}
		}
		zipIn.close();
	}
}
//
//通过ZipInStream类将压缩文件解压到指定的文件夹中：
//源程序是：
//import java.io.*;
//import java.util.zip.*;
//public class Decompressing 搜索{ // 创建文件
//public static void main(String[] temp) {
//ZipInputStream zin; // 创建ZipInputStream对象
//try { // try语句捕获可能发生的异常
//zin = new ZipInputStream(new FileInputStream("F:/hello.zip"));
//// 实例化对象，指明要进行解压的文件
//ZipEntry entry = zin.getNextEntry(); // 获取下一个ZipEntry
//while (((entry = zin.getNextEntry()) != null)
//&& !entry.isDirectory()) {
//// 如果entry不为空，并不在同一目录下
//File file = new File("F:\" + entry.getName()); // 获取文件目录
//System.out.println(file);
//if (!file.exists()) { // 如果该文件不存在
//file.mkdirs();// 创建文件所在文件夹
//file.createNewFile(); // 创建文件
//}
//zin.closeEntry(); // 关闭当前entry
//System.out.println(entry.getName() + "解压成功");
//}
//zin.close(); // 关闭流
//} catch (Exception e) {
//e.printStackTrace();
//}
//}
//}
//GET请求
//
//
///**
//    * 从网络获取json数据,(String byte[})
//
//    * @param path
//    * @return
//    */
//   public static String getJsonByInternet(String path){
//       try {
//           URL url = new URL(path.trim());
//           //打开连接
//           HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//
//           if(200 == urlConnection.getResponseCode()){
//               //得到输入流
//               InputStream is =urlConnection.getInputStream();
//               ByteArrayOutputStream baos = new ByteArrayOutputStream();
//               byte[] buffer = new byte[1024];
//               int len = 0;
//               while(-1 != (len = is.read(buffer))){
//                   baos.write(buffer,0,len);
//                   baos.flush();
//               }
//               return baos.toString("utf-8");
//           }
//       }  catch (IOException e) {
//           e.printStackTrace();
//       }
//
//       return null;
//   }
//
//
//POST请求
//
//
//
////获取其他页面的数据
//   /**
//    * POST请求获取数据
//    */
//   public static String postDownloadJson(String path,String post){
//       URL url = null;
//       try {
//           url = new URL(path);
//           HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//           httpURLConnection.setRequestMethod("POST");// 提交模式
//           // conn.setConnectTimeout(10000);//连接超时 单位毫秒
//           // conn.setReadTimeout(2000);//读取超时 单位毫秒
//           // 发送POST请求必须设置如下两行
//           httpURLConnection.setDoOutput(true);
//           httpURLConnection.setDoInput(true);
//           // 获取URLConnection对象对应的输出流
//           PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
//           // 发送请求参数
//           printWriter.write(post);//post的参数 xx=xx&yy=yy
//           // flush输出流的缓冲
//           printWriter.flush();
//           //开始获取数据
//           BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
//           ByteArrayOutputStream bos = new ByteArrayOutputStream();
//           int len;
//           byte[] arr = new byte[1024];
//           while((len=bis.read(arr))!= -1){
//               bos.write(arr,0,len);
//               bos.flush();
//           }
//           bos.close();
//           return bos.toString("utf-8");
//       } catch (Exception e) {
//           e.printStackTrace();
//       }
//       return null;
//   }
