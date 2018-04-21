package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.wolverine.pass.DataPassUtil;

import javafx.scene.chart.PieChart.Data;

public class TestFile {
	public static void main(String[] args) throws IOException {
		// BufferedReader是可以按行读取文件
		FileInputStream inputStream = new FileInputStream("d://3333.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		//FileWriter writer = new FileWriter("d://4444.txt");
		//BufferedWriter bw = new BufferedWriter(writer);
		String str = null;
		int i=0;
		while ((str = bufferedReader.readLine()) != null &&i==0) {
			String[] temp = str.split(",");
			String ttt = "";
			System.out.print(i++);
			System.out.print(temp[0]);
			System.out.println(DataPassUtil.unPassFieldData(temp[0]));
			System.out.println("=================");
			ttt=temp[0];
			System.out.println(DataPassUtil.unPassFieldData(ttt));
			System.out.println("=================");
			System.out.println(DataPassUtil.unPassFieldData("﻿{$$$$}{H}4A-01-F2-4A-EF-FF-4C-F2-16"));
			System.out.println("=================");
			System.out.println(DataPassUtil.unPassFieldData("{$$$$}{H}4A-01-F2-4A-EF-FF-4C-F2-16"));
//			if(temp.length==3){
//			ttt = DataPassUtil.unPassFieldData(temp[0]) + "," + DataPassUtil.unPassFieldData(temp[1]) + "," + DataPassUtil.unPassFieldData(temp[2]);
//			}else if(temp.length==2){
//				ttt = DataPassUtil.unPassFieldData(temp[0]) + "," + DataPassUtil.unPassFieldData(temp[1]);	
//			}
			//bw.write(ttt + "\r\n");
			
		}
		// close
		inputStream.close();
		bufferedReader.close();
		//bw.close();
		//writer.close();

	}

}
