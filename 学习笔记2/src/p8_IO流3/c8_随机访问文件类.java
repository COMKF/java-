package p8_IO流3;

import java.io.IOException;
import java.io.RandomAccessFile;
/* 随机访问文件类：RandomAccessFile类，此类可随机访问文件，自身就具备读写的方法。
 * 此类不是IO四大体系中的子类。IO四大体系是：Reader，Writer，InputStream，OutputStream。
 * 特点：
 * 1.该对象既能读也能写。
 * 2.该对象内部维护了一个byte数组，并通过指针可以操作数组中的元素。
 * 3.可以通过getFilePointer方法获取指针的位置，和通过seek方法设置指针的位置。
 * 4.其实该对象就是将字节输入流和输出流进行了封装。(要不然凭什么可以读和写啊)
 * 5.该对象的源或者目的只能是文件，通过构造函数就可以看出。
 * 
 * 构造函数：
 * 1.RandomAccessFile(String name, String mode)	//两个参数，第一个是文件名，第二个是模式，有4个值，r，rw，rws，rwd，指定对文件的操作类型
 * 2.RandomAccessFile(File file, String mode)	//两个参数，第一个是文件对象
 * 
 * 常用方法：
 * 1.读取read和写入write，不再阐述
 * 
 */
public class c8_随机访问文件类 {

	public static void main(String[] args) throws IOException {
//		wrifile();
//		reafile();
		wrifile2();
		
	}

	private static void wrifile() throws IOException {
		//使用RandomAccessFile写入一些人员信息，比如姓名和年龄。
		//如果文件不存在，则创建，如果文件存在，则不创建
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		raf.write("张三".getBytes());
//		raf.write(97);	
//		raf.write(609);	//说明写入int型数据时，int型数据虽然有4个字节，但只会写入最后一个字节，即最低8位。
		raf.writeInt(97);	//这个方法，写入的就是int型数据的4个字节，保存了完整的int型数据。
//		raf.writeChars("小青");	//类似的方法还有writeChars等，这个可以写入字符串，这种方法都保证了数据的完整性。但有可能造成数据乱码。
//		raf.writeBytes("小青");	//因为数据被忠实的，完整的保存了，但是txt可能解析不出来，所以造成乱码
		raf.write("小强".getBytes());
		raf.writeInt(99);
		raf.close();
	}
	
	private static void reafile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "r");
		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);	//读取一个字节数组的数据
		System.out.println(name);
		int age = raf.readInt();	//读取四个字节，并转化为int型数据
		System.out.println(age);
		
		System.out.println(raf.getFilePointer());	//获取当前的指针位置
		//通过seek设置指针的位置，不读取小强，而直接读取小强的年龄
		raf.seek(12);	//设置指针位置，这就是随机读取，想从哪读就从哪读，只需要指定指针的位置即可
		
		int age2 = raf.readInt();	//
		System.out.println(age2);

		raf.close();
	}
	
	private static void wrifile2() throws IOException {	//用随机写的思想，续写文件
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		raf.write("随机数".getBytes());
		raf.writeInt((int)(Math.random()*6+97));
		raf.seek((int) raf.length());	//直接设置指针位置到文件末尾，从末尾开始写
		raf.write("王五".getBytes());
		raf.writeInt(101);
		raf.close();
		/* 事实上，每次用RandomAccessFile打开文件，文件指针都处于第一位，而之前保存的数据也不会变。
		 * 如果此时用write方法，将会覆盖之前的数据。剩下的没有覆盖到的数据，不会改变。
		 */
		//这个类，实用的地方在，对一个文件进行切割时，可以开启多线程，用多个流，同时切割，只要设置好文件指针即可，不需要用到序列流，节省时间。
	}

}
