package p8_IO流3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

import bean.FilterByEndName;

/* 事实上，之前的切割与合并是有问题的。
 * 1.健壮性的判断，这里不做阐述，可以自己试试。
 * 2.并不知道有多少碎片。
 * 3.并不知道源文件的名称和后缀名。
 * 
 * 如何解决？
 * 可以在切割的时候，将相关信息记录下来，方便下次使用。
 * 根据上述分析，我们可以用配置文件记录这些相关信息，即Properties类。
 * 所以，切割时，添加配置文件。合并时，从配置文件中着手。
 */
public class c6_文件切割与合并的优化 {

	private static final int SIZE = 1024*1024;
	
	public static void main(String[] args) throws IOException {
		File f = new File("0.mp3");
		File dir = new File("E:\\eclipseanzhuangbao\\workspace\\学习笔记2\\文件切割与合并"); //指定碎片文件的产生路径
//		QieGe(f,dir);
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
		Properties pro = new Properties();
		pro.setProperty("partcount", count+"");
		pro.setProperty("filename", f.getName());
		fos = new FileOutputStream(new File(dir,count+".properties"));
		pro.store(fos, "");
		fos.close();
		fis.close();
	}
	

	private static void HeBing(File dir) throws IOException {
		File[] fs = dir.listFiles(new FilterByEndName(".properties"));
		
		if (fs.length!=1) {
			throw new RuntimeException("该目录下没有配置文件或者配置文件不唯一！！");
		}
		//取出配置文件，存储到config中
		File config = fs[0];
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(config);
		pro.load(fis);
		String filename = pro.getProperty("filename");
		int count = Integer.parseInt(pro.getProperty("partcount"));
		//获取目录下的所有碎片文件
		File[] parefiles = dir.listFiles(new FilterByEndName(".part"));
		
		if(parefiles.length!=(count-1)){
			throw new RuntimeException("碎片文件个数不对！！"+"应该为"+count+"个");
		}
		//将碎片文件和流对象关联，并存储到集合中
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for (int i = 1; i < count; i++) {
			al.add(new FileInputStream(parefiles[i-1]));
		}
		//将多个流合并成一个序列流
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		SequenceInputStream sis = new SequenceInputStream(en);
		
		FileOutputStream fos = new FileOutputStream(new File(dir,filename));	//将配置文件中的filename取出，作为合成文件的名称
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while ((len = sis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}
}
