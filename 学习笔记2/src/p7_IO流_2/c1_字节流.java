package p7_IO流_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 字节流：基本操作与字符流相同，操作思想相同，但它不仅可以操作字符，还可以操作其他媒体文件，比如音乐，图片，电影。
 * 两个直接子类：1.InputStream	2.Outputstream
 */

/* OutputStream:字节写入流，也称字节输出流。
 * 这里用OutputStream的子类FileOutputStream做演示。
 * FileOutputStream：用于写入字节文件的类。
 * 
 * 构造方法：构造方法没有空参的，意思是创建对象时就必须要明确数据的目的地。
 * 
 * 常用方法：继承OutputStream的方法。
 * 1.写入字节数组数据  void write(byte b[]) 
 * 2.写入int型数据  void write(int b)
 * 3.写入字节数组数据的一部分  void write(byte b[], int off, int len)
 * 4.关闭流   void close()
 */

/* InputStream:字节读取流，也称字节输入流。
 * 这里用InputStream的子类FileInputStream做演示。
 * FileInputStream：用于读取字节文件的类。
 * 
 * 构造方法：构造方法没有空参的，意思是创建对象时就必须要明确数据的目的地。
 * 
 * 常用方法：继承InputStream的方法。
 * 1.读取单个字节  int read() //返回值为int型
 * 2.读取字节数组  int read(byte b[])//返回值为int型,意义是读取的字节数，三种方法比较，还是推荐使用这种方法进行读取
 * 3.获取字节数 int available()	//返回值为int型,意义是获取文件的大小
 * 4.关闭流   void close()
 */
public class c1_字节流 {

	public static void main(String[] args) throws IOException {
//		show1();
		show2();
	}


	private static void show1() throws IOException {	//演示字节写入流
		//1.创建字节写入流对象，用于操作文件
		FileOutputStream fos = new FileOutputStream("bytetest.txt");
		//2.写数据，直接把数据写入到目的地中，意味着不需要flush()方法，事实上，FileOutputStream也就没有flush()方法，不需要
		fos.write("bcdet".getBytes());	//不能直接写入字符串，可以把字符串转换为字节数组然后写入
		fos.close();
	}
	
	private static void show2() throws IOException {	//演示字节读取流
		//1.创建字节读取流对象，和指定文件关联
		FileInputStream fis = new FileInputStream("bytetest.txt");
//		//2.读取字节，一次读一个
//		int ch = 0;
//		while ((ch = fis.read()) != -1) {
//			System.out.println((char)ch);
//		}
//		//2.读取字节，按数组读
//		byte[] buf = new byte[1024];
//		int len = 0;
//		while ((len = fis.read(buf)) != -1) {
//			System.out.println(new String(buf,0,len));
//		}
		//2.读取字节，按数组读，且直接定义数组的大小为文件的字节数(即文件的大小)
		byte[] buf = new byte[fis.available()];
		fis.read(buf);	//用这种方法虽然比较简单，但是建议少用。因为这个方法只适用于小文件，若大文件用这种方法，会造成内存溢出。
		//这种方法的另一个用处是，可以先获取文件的数据大小，然后按文件的数据大小分段读取。
		System.out.println(new String(buf));
		fis.close();
	}

}
