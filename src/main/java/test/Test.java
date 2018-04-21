package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.javafx.collections.MappingChange.Map;

import net.sf.json.JSONObject;


public class Test {
	// d581fe22d0df89149c411489ba78fd1f
	// d581fe22d0df89149c411489ba78fd1f
	static Logger logger = LogManager.getLogger(Test.class.getName());

	public static void main(String[] args) throws Exception {
		// testSystem();
		// SystemPropertytest();
		// filetest();
		// System.out.println(findFile("D:\\zip\\8d0d001dbfe69994478a0925a6ce0f06_2015100511981\\","rt.dat").getAbsoluteFile());
		// System.out.println(MD5.getFileMD5String(findFile("D:\\zip\\8d0d001dbfe69994478a0925a6ce0f06_2015100511981\\","rt.dat").getAbsoluteFile()));
		// System.out.println(MD5.getFileMD5StringMemory(findFile("D:\\zip\\8d0d001dbfe69994478a0925a6ce0f06_2015100511981\\","rt.dat").getAbsoluteFile()));
		// System.out.println(MD5.getMD5String(findFile("D:\\zip\\8d0d001dbfe69994478a0925a6ce0f06_2015100511981\\","rt.dat").getAbsoluteFile()));
		// String a="12222234_123";
		// System.out.println(a.substring(a.lastIndexOf("_")+1) );
		// String filePath =
		// Thread.currentThread().getContextClassLoader().getResource("").getPath();
		// System.out.println(123);
//		MyApplication myApplication = new MyApplication();
//		logger.trace("123");
//		logger.info("Hello, World!");
//		myApplication.doIt();
//		hello();
//		logger.error("Hello, World!");
//		logger.trace("exit");
//		String t1="YYYYYYYYY";
//	    String t="yocalywzg-PC/192.168.10.252@C-195-128;D-736-559";
//	    t = URLEncoder.encode(t,"utf-8") ;
//	    System.out.println(t);
//	    t=URLDecoder.decode(t,"utf-8");
//	    System.out.println(t);
//	    Test tttTest=new Test();
//	    List<SysProModel> list=tttTest.getSysProModel(t1,t);
//	    java.util.Map<String,List<SysProModel>> tempMap=new HashMap<String, List<SysProModel>>();
//	    tempMap.put("23", list);
//	    for (List<SysProModel> lll : tempMap.values()) {
//			for(SysProModel aa:lll){
//				System.out.println(aa.getDriver());
//			}
//		}
//	    for (SysProModel li : list) {
//	    	System.out.println(li.getDriver()+"=="+li.getName()+"=="+li.getFree()+"=="+li.getTotal());
//		}
//	    
//	    System.out.println(tttTest.getSysPorStr());
//	    String time_format = "yyyy-MM-dd HH:mm:ss";
//	    String str4="2018-01-30 16:48:34";
//		Date createTimes = new SimpleDateFormat(time_format).parse(str4);
//		Long long1=System.currentTimeMillis() - createTimes.getTime();
		String strResult="qwerty";
		int index = strResult.indexOf("#");
		System.out.println(index);
		if ( index >= 0 ) {
			strResult =  strResult.substring(0,index);
		}
		System.out.println(strResult);
	}

	public List<SysProModel> getSysProModel(String orgcode, String sysPor) {
		List<SysProModel> spmList=new ArrayList<SysProModel>();
		String [] str=sysPor.split("@");
		String temp =str[0];
		String[] str1=str[1].split(";");
		for (int i = 0; i < str1.length; i++) {
			SysProModel spm=new SysProModel();
			spm.setOrgCode(orgcode);
			spm.setName(temp);
			String[] str2=str1[i].split("-");
			spm.setDriver(str2[0]);
			spm.setTotal(Integer.parseInt(str2[1]));
			spm.setFree(Integer.parseInt(str2[2]));
			spmList.add(spm);
		}
		java.util.Map<String,String> tempMap=new HashMap<String, String>();
		tempMap.put("123", "234");
		System.out.println(tempMap.get("123"));
		tempMap.put("123", "5555");
		System.out.println(tempMap.get("123"));
		return spmList;
		
	}
	public String getSysPorStr() {
		String str="";		
		StringBuffer strbf = new StringBuffer();
		FileSystemView sys = FileSystemView.getFileSystemView();
		File[] list = File.listRoots();
		try {
			str = java.net.InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		strbf.append(str);
		strbf.append("@");
		for (File diskPartition : list) {
			if (sys.getSystemTypeDescription(diskPartition).equals("本地磁盘")) {
				double totalCapacitybyte = diskPartition.getTotalSpace();
				double freePartitionSpacebyte = diskPartition.getFreeSpace();
				long totalCapacity = Math.round(totalCapacitybyte / (1024 * 1024 * 1024));
				long freePartitionSpace = Math.round(freePartitionSpacebyte / (1024 * 1024 * 1024));
				String temp=diskPartition.getAbsolutePath();
				strbf.append(temp.substring(0,1)+ "-" + totalCapacity  + "-"
						+ freePartitionSpace);
				strbf.append(";");
			}
		}
		return strbf.toString().substring(0,strbf.toString().length()-1);
	}
}
