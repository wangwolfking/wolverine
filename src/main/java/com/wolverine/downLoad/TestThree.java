package com.wolverine.downLoad;

//public class TestThree {

//}
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 测试利用多线程进行文件的写操作
 */
public class TestThree {

	public static void main(String[] args) throws Exception {
		// 预分配文件所占的磁盘空间，磁盘中会创建一个指定大小的文件
		//RandomAccessFile raf = new RandomAccessFile("D://abc.txt", "rw");
		//raf.setLength(1024*1024); // 预分配 1M 的文件空间
		//raf.close();
		
		// 所要写入的文件内容
		String s1 = "aslfdkja;fkaf;afja;你好我是你的谁谁额ldjfalsdjfaljfaljsdf\n";
		System.out.println(s1.length());
		System.out.println(s1.getBytes().length);
		String s2 = "22222222222aaaaaaaaaaaaaaaaaaaa;lsdjfa faaf afja lda a fas fa 2222222222222222222\n";
		System.out.println(s2.length());
		String s3 = "333333333333aawerdfdddddfagfafdasdfafasfdafa333333333333333333\n";
		System.out.println(s3.length());
		String s4 = "asdf afafsa fda fsafdsadfsadfsafdasfvcxvzxcvqewrwqre\n";
		System.out.println(s4.length());
		String s5 = "555555555555555555555555555555";
		
		// 利用多线程同时写入一个文件
		new FileWriteThread(0,s1.getBytes()).start(); // 从文件的1024字节之后开始写入数据
		new FileWriteThread(s1.getBytes().length,s2.getBytes()).start(); // 从文件的2048字节之后开始写入数据
		new FileWriteThread(s1.getBytes().length+s2.getBytes().length,s3.getBytes()).start(); // 从文件的3072字节之后开始写入数据
		new FileWriteThread(s1.getBytes().length+s2.getBytes().length+s3.getBytes().length,s4.getBytes()).start(); // 从文件的4096字节之后开始写入数据
		new FileWriteThread(s1.getBytes().length+s2.getBytes().length+s3.getBytes().length+s4.getBytes().length,s5.getBytes()).start(); // 从文件的5120字节之后开始写入数据
	}
	
	// 利用线程在文件的指定位置写入指定数据
	static class FileWriteThread extends Thread{
		private int skip;
		private byte[] content;
		
		public FileWriteThread(int skip,byte[] content){
			this.skip = skip;
			this.content = content;
		}
		
		public void run(){
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile("D://abc.txt", "rw");
				raf.seek(skip);
				raf.write(content);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					raf.close();
				} catch (Exception e) {
				}
			}
		}
	}

}
