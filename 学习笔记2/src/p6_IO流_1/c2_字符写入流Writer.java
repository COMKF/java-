package p6_IO流_1;

import java.io.FileWriter;
import java.io.IOException;

/* Writer:字符写入流，也称为字符输出流。
 * 这里用Writer的子类FileWriter做演示。
 * FileWriter：用于写入字符文件的便捷类。
 * 
 * 构造方法：构造方法没有空参的，意思是创建对象时就必须要明确数据的目的地。
 * 
 * 常用方法：继承Writer的方法。
 * 1.写入数据  void write(T t) //可以写多种格式的数据
 * 2.添加  Writer append(T t)	//可以写多种格式的数据(暂时不用)
 * 3.刷新缓冲，立即将缓冲区中的数据写入到目的地中  void flush()
 * 4.关闭流   void close()//在关闭前会执行一次flush()
 */
public class c2_字符写入流Writer {

	public static final String Line_separator = System.getProperty("line.separator");//创建一个变量用来引用换行符
	
	public static void main(String[] args) throws IOException {
		show1();
//		show2();
	}

	private static void show1() throws IOException {
		/* 创建一个可以往文件中写入字符数据的字符输出流对象。
		 * 
		 * 既然是往一个文件中写入字符数据，那么在创建对象时，就必须明确该文件(用于存储数据的目的地)。
		 * 如果文件不存在，就会自动创建。如果文件存在，则会被覆盖。
		 */
		FileWriter fw = new FileWriter("test.txt");	//创建字符输出流对象时，需要抛出异常，该异常是IOException
		
		/* 调用Writer对象中的writer(String)方法写入数据。
		 * 其实数据写入到了临时存储缓冲区中。
		 */
		fw.write("abcc");//1
//		fw.write(Line_separator);//这样就可以实现换行，好处是可以在任何平台上移植
		fw.write("haha");
//		fw.write("abcc"+Line_separator+"haha");//也可以这样写
//		fw.flush();
		fw.close();//关闭流的操作，一定要有，这样可以关闭资源
		//说明了flush可以用多次，而close只能用一次
	}
	
	private static void show2() throws IOException {
		//如果构造函数参数中加入true，则可实现对文件的续写
		FileWriter fw = new FileWriter("test.txt",true);
		fw.write(Line_separator);
		fw.write("xixi");
		fw.close();
		
	}
}
