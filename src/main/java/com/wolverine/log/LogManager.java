package com.wolverine.log;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

import com.wolverine.util.StringUtils;

/**
 * @see 数据系统日志管理�
 * @version 1.0 
 * @time 2010-08-13
 * @author wuchao
 */
public class LogManager {
	
	private String logname ;
	private String filePath  = "";
	private String folder = "" ;
	String fileName = "" ;
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	private static LogManager logManager = null ;
	public static synchronized LogManager newInstance(String logname,String fileName){
		if ( null == logManager ) {
			logManager = new LogManager(logname, fileName);
		} else {
			logManager.setLogname(logname);
			logManager.setFileName(fileName);
		}
		return logManager ;
	}
	
	
	/**
	 * @param logname 日志名称
	 */
	public LogManager(String logname){
		this.logname = logname ;
	}
	/**
	 * @param logname 日志名称
	 * @param fileName 文件名称
	 */
	public LogManager(String logname,String fileName){
		this.logname = logname ;
		if (null != fileName ) { this.fileName = fileName ; } 
	}
	/**
	 * @param logname 日志名称
	 * @param fileName 文件名称
	 * @param folder  文件目录绝对路径如window(c:/test) linux(/usr)
	 */
	public LogManager(String logname,String fileName,String folder){
		this.logname = logname ;
		if (null != fileName ) { this.fileName = fileName ; } 
		this.folder = folder ;
	}
	/**
	 * 得到当前时间 yyyy-mm-dd
	 * @return
	 */
	private static String getDate(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = tempDate.format(new java.util.Date());
		return datetime;
	}
	/**
	 * 得到当前时间 yyyy-mm-dd HH:mm:ss
	 * @return
	 */
	private static String getDates(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(new java.util.Date());
		return datetime;
	}
	
	/**
	 * 初始�
	 */
	private void init(){
		try {
			String rootPath = "logs" ;
			if ( !StringUtils.isEmpty(this.folder) ) {
				rootPath = this.folder ;
			}
			File file= new File(rootPath);
			if ( !file.exists() ){
				file.mkdir();
			}
			this.filePath = rootPath+"/"+ this.fileName+getDate()+".log" ;
			file = new File(this.filePath);
			if (!file.exists()){
				file.createNewFile();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 写错误日志信�
	 * @param msg 信息
	 */
	public synchronized void error(String msg){
		try {
			init();
			String mssg = ("["+getDates()+"] [ERROR] ["+this.logname+"]"+msg+"\r\n");
			FileWriter   fw   =   new   FileWriter(filePath,true);
			fw.write(mssg);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * 写警告日志信�
	 * @param msg 信息
	 */
	public synchronized void warn(String msg){
		try {
			init();
			String mssg = ("["+getDates()+"] [WARN] ["+this.logname+"]"+msg+"\r\n");
			FileWriter   fw   =   new   FileWriter(filePath,true);
			fw.write(mssg);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	/**
	 * 写日志信�
	 * @param msg 信息
	 */
	public synchronized void info(String msg){
		try {
			init();
			String mssg = ("["+getDates()+"] [INFO] ["+this.logname+"]"+msg+"\r\n");
			FileWriter   fw   =   new   FileWriter(filePath,true);
			fw.write(mssg);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
