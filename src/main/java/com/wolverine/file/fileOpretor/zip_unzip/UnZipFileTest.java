package com.wolverine.file.fileOpretor.zip_unzip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class UnZipFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnZipFileTest zf = new UnZipFileTest();
		zf.unZip("d:/123.zip");

	}

	public void unZip(String fileName) {
		try {
			ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(fileName)));
			BufferedInputStream bis = new BufferedInputStream(zis);
			String outPath = "d:/test";
			File outFile = null;
			ZipEntry entry = null;
			System.out.println(1222);
			while ((entry = zis.getNextEntry()) != null) {
				System.out.println(12223);
				outFile = new File(outPath, entry.getName());
				FileOutputStream fos = new FileOutputStream(outFile);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				int b = 0;
				while ((b = bis.read()) != -1) {
					bos.write(b);
				}
				bos.close();
				fos.close();
			}
			bis.close();
			zis.close();
			System.out.println(123);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void unZipFile(String fileName, String descDir) throws ZipException, IOException {
		File pathFile = new File(descDir);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}
		Charset gbk = Charset.forName("GBK");
		ZipFile zip = new ZipFile(new File(fileName));
		for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			String zipEntryName = entry.getName();
			InputStream in = zip.getInputStream(entry);
			String outPath = (descDir + zipEntryName).replaceAll("\\*", "/");
			// 判断路径是否存在,不存在则创建文件路径
			File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
			if (!file.exists()) {
				file.mkdirs();
			}
			// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
			if (new File(outPath).isDirectory()) {
				continue;
			}
			// 输出文件路径信息
			System.out.println(outPath);

			OutputStream out = new FileOutputStream(outPath);
			byte[] buf1 = new byte[1024];
			int len;
			while ((len = in.read(buf1)) > 0) {
				out.write(buf1, 0, len);
			}
			in.close();
			out.close();
		}
	}
}
