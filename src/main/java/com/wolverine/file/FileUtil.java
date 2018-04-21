package com.wolverine.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class FileUtil {
	public static Properties getProperties(String param_fileName) {
		Properties pps = new Properties();
		try {
			pps.load(new FileInputStream(param_fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pps;
	}

	public static void copyFileUsingFileStreams(File source, File dest) throws IOException {
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(source);
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		} finally {
			input.close();
			output.close();
		}
	}

	public static void copyFileUsingFileChannels(File source, File dest) throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
	}

	public static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
		FileUtils.copyFile(source, dest);
	}

	public static void copyFileUsingJava7Files(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath());
	}

    public static void fileChannelCopy(File s, File t) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Long start;	

		File source = new File("d:\\test\\1\\1.txt");
		File dest = new File("d:\\test\\2\\2.txt");

		// copy file using FileStreamslong 
		start = System.nanoTime();
		long end;
		copyFileUsingFileStreams(source, dest);
		System.out.println("Time taken by FileStreams Copy = " + (System.nanoTime() - start));

		// copy files using java.nio.FileChannelsource = new
		// File("C:\\Users\\nikos7\\Desktop\\files\\sourcefile2.txt");
		dest = new File("d:\\test\\3\\3.txt");
		start = System.nanoTime();
		copyFileUsingFileChannels(source, dest);
		end = System.nanoTime();
		System.out.println("Time taken by FileChannels Copy = " + (end - start));

		// copy file using Java 7 Files classsource = new
		// File("C:\\Users\\nikos7\\Desktop\\files\\sourcefile3.txt");
		dest = new File("d:\\test\\4\\4.txt");
		start = System.nanoTime();
		copyFileUsingJava7Files(source, dest);
		end = System.nanoTime();
		System.out.println("Time taken by Java7 Files Copy = " + (end - start));

		// copy files using apache commons iosource = new
		// File("C:\\Users\\nikos7\\Desktop\\files\\sourcefile4.txt");
		dest = new File("d:\\test\\5\\5.txt");
		start = System.nanoTime();
		copyFileUsingApacheCommonsIO(source, dest);
		end = System.nanoTime();
		System.out.println("Time taken by Apache Commons IO Copy = " + (end - start));
		
		dest = new File("d:\\test\\6\\6.txt");
		start = System.nanoTime();
		fileChannelCopy(source, dest);
		end = System.nanoTime();
		System.out.println("fileChannelCopy Copy = " + (end - start));

	}

}
