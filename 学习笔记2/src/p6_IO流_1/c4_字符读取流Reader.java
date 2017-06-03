package p6_IO流_1;

import java.io.FileReader;
import java.io.IOException;

/* Reader:字符读取流,也称字符输入流。
 * 这里用Reader的子类FileReader做演示。
 * FileReader：用于读取字符文件的便捷类。
 * 
 * 构造方法：构造方法没有空参的，意思是创建对象时就必须要明确数据的来源。
 * 
 * 常用方法：继承Reader的方法。
 * 1.读取单个字符  int read() //返回值为int型，因为数据在计算机中的存储形式是二进制
 * 2.读取字符数组  int read(char cbuf[])//把读到的数个字符存储到字符数组中，返回值为int型，意义是读取到的字符的个数
 * 3.关闭流并释放与之相关的所有资源  void close()
 */
public class c4_字符读取流Reader {

	public static void main(String[] args) throws IOException {
//		show1();
		show2();
	}

	private static void show1() throws IOException {	//1，读取单个字符
		/* 创建字符读取流对象。
		 * 
		 * 在创建读取流对象时，必须要明确被读取的文件，一定要确定该文件是存在的。
		 * 用一个读取流关联一个已存在的文件。
		 */
		FileReader fr = new FileReader("test.txt");	//创建字符读取流对象时，需要抛出异常，该异常是IOException
		
		//用Reader中的read()方法读取文本文件。
		
//		int ch1 = fr.read();
//		System.out.println((char)ch1);	//如果直接输出的话，输出的是ASCII码，可以用(char)强转
//		int ch2 = fr.read();
//		System.out.println(ch2);
//		fr.close();
		
		int ch = 0;	//1，读取单个字符的写法
		while ((ch = fr.read())!= -1) {	//如果达到文本的末尾，则返回-1，可以通过这个判断是否把文件读取完毕
			System.out.println((char)ch);
		}
		fr.close();
	}
	
	private static void show2() throws IOException {	//2，读取字符数组
		FileReader fr = new FileReader("test.txt");
		//用Reader中的read(char [])方法读取文本文件。
		
		//先创建字符数组
		char[] buf = new char[3];	//这个其实也就是缓冲区，是自定义的缓冲区。我们在接下来需要学习的是已被封装的缓冲区，有独特的功能。
		
//		int num = fr.read(buf); //将读到的字符存储到字符数组中
//		System.out.println(num+":"+new String(buf));
//		fr.close();
		
		int len = 0;	//2，读取字符数组的写法
		while ((len = fr.read(buf)) != -1) {	//如果达到文本的末尾，则读取到的字符的个数为-1，可以通过这个判断是否把文件读取完毕
			System.out.println(len+":"+new String(buf,0,len));	//这是字符串的构造方法，在p8的c1中有详解
		}
		fr.close();
	}
}
