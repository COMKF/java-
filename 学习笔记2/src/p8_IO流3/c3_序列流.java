package p8_IO流3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/* SequenceInputStream:序列流，表示其他输入流的逻辑串联。它从输入流的有序集合开始，从第一个流一直读到最后一个流。
 * 多个源，就需要有多个流。可以把这些流封装在一个集合中，合并成一个源，那么这就是SequenceInputStream的作用。
 * 
 * 构造函数：
 * 1. SequenceInputStream(Enumeration<? extends InputStream> e) //参数是一个集合中所有元素的枚举，可以是多个流。
 * 2. SequenceInputStream(InputStream s1, InputStream s2)	//参数是确定的两个流
 * 
 * 常用方法：
 * 1.读取
 * 1.1读取下一个字符  int read()
 * 1.2读取字节到数组中  int read(byte b[])
 */
public class c3_序列流 {

	public static void main(String[] args) throws IOException {
		//用实例演示一下。将三个文本的数据合并。
		//因为SequenceInputStream的构造函数必须是枚举类型，所以这里用Vector集合。
		//创建Vector集合
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		//添加流到集合中
		v.add(new FileInputStream("1.txt"));
		v.add(new FileInputStream("2.txt"));
		v.add(new FileInputStream("3.txt"));
		//通过枚举将v集合中的元素取出，这个方法等效于Iterator方法
		Enumeration<FileInputStream> en = v.elements();
		//将en作为参数传递到序列流SequenceInputStream中
		SequenceInputStream sis = new SequenceInputStream(en);
		//输出流
		FileOutputStream fos = new FileOutputStream("4.txt");
		//创建字节数组，作为序列流SequenceInputStream的read方法的存储区域
		byte[] buf = new byte[1024];
		
		int len = 0;
		while ((len = sis.read(buf))!=-1) {	//这里要用序列流序列流SequenceInputStream的read方法，且参数必须为byte[]或byte
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
		
	}

}
