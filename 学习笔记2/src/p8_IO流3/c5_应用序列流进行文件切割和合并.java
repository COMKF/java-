package p8_IO流3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/* 功能需求：文件太大，无法上传，必须进行切割，得到多个碎片文件
 * 切割的方式：
 * 1.按大小切，比如规定每个文件碎片的大小必须为1M。
 * 2.按个数切，比如无论源文件大小为多少，必须切5个。
 * 
 * 很明显，第一张方法更好，因为第二种无法控制碎片大小，有可能造成碎片太大。
 * 
 */

public class c5_应用序列流进行文件切割和合并 {

	private static final int SIZE = 1024*1024;	//SIZE为1M

	public static void main(String[] args) throws IOException {
		File f = new File("0.mp3");
		File dir = new File("E:\\eclipseanzhuangbao\\workspace\\学习笔记2\\文件切割与合并"); //指定碎片文件的产生路径
		QieGe(f,dir);
		HeBing(dir);
	}

	private static void QieGe(File f,File dir) throws IOException {	//切割并没有使用到序列流
		//用读取流关联源文件
		FileInputStream fis = new FileInputStream(f);
		//定义一个字节数组作为缓冲区，确定碎片文件的大小（若需要大的碎片，则需要大的缓冲区，用循环实现）
		byte[] buf = new byte[SIZE];
		//创建目的
		FileOutputStream fos = null;
		int len = 0;
		int count = 1;	//指定碎片文件的产生路径
		if (!dir.exists()) {
			dir.mkdirs();
		}
		while ((len=fis.read(buf))!=-1) {
			fos = new FileOutputStream(new File(dir,(count++)+".part"));	//把文件路径+文件名再次封装
			fos.write(buf,0,len);
			fos.close();
		}
		fis.close();
	}
	
	private static void HeBing(File dir) throws IOException {	//合并用到了序列流
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int i=1;i<=4;i++){
			al.add(new FileInputStream(new File(dir,i+".part")));
		}
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		SequenceInputStream sis = new SequenceInputStream(en);
		
		FileOutputStream fos = new FileOutputStream(new File(dir,"0.mp3"));
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while ((len = sis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}


}
