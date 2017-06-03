package p7_IO流_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
/* 转换流：字符流与字节流相互转换的方法。
 * 字符流——>字节流:编码，OutputStreamWriter
 * 
 * 字节流——>字符流:解码，InputStreamReader
 * 
 * 详见  转换流桥梁.bmp
 */
/* 流的操作规律。
 * 之所以要弄清这个规律，是因为流对象太多，开发时不知道用哪个对象。
 * 
 * 想要知道开发时用哪些对象，只需要通过四个明确即可。
 * 1.明确源和目的(汇)
 * 		源： InputStream  Reader
 * 		目的：OutputStream  Writer
 * 2.明确数据是否是文本数据
 * 		源：是纯文本，Reader；否，InputStream
 * 		目的：是纯文本，Writer；否，OutputStream
 * 到这里就可以明确具体要使用哪个体系。
 * 3.明确具体的设备
 * 		源设备：硬盘，File;键盘，System.in;内存，数组;网络,Socket流
 * 		目的设备：硬盘，File;控制台，System.out;内存，数组;网络,Socket流
 * 4.是否需要额外功能：
 * 		是否需要高效？————缓冲区
 * 		是否需要转换？转换流
 * 		
 */

public class c4_转换流 {

	public static void main(String[] args) throws IOException {	
//		show1();
		show2();
	}
	
	private static void show1() throws IOException {//键盘一直录入字符，将字母变成大写显示在控制台上，遇over就结束,有转换流优化
		InputStream is = System.in;//标准的字节输入流
		
		//将字节流转换为字符流的桥梁，转换流。
		InputStreamReader isr = new InputStreamReader(is);//此时已经变成读取的字符流(输入的字符流)
		
		BufferedReader bfr = new BufferedReader(isr);//高效装饰
		
		
		OutputStream ops = System.out;//标准的字节输出流
		
		//将字符流转换为的字节流桥梁，转换流。
		OutputStreamWriter osw = new OutputStreamWriter(ops);//此时已经变成输出的字符流
		
		BufferedWriter bfw = new BufferedWriter(osw);//高效装饰
		
		String line = null;
		while((line = bfr.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
//			System.out.println(line.toUpperCase());
			bfw.write(line.toUpperCase());	//输出到控制台也可以这样写
			bfw.newLine();
			bfw.flush();
		}
	}

	private static void show2() throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	//转换流的直接简写,从控制台上输入
		
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));//转换流的直接简写，输出到控制台
		//以下不变
		String line = null;
		while((line = bfr.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
//			System.out.println(line.toUpperCase());
			bfw.write(line.toUpperCase());	//输出到控制台也可以这样写
			bfw.newLine();
			bfw.flush();
		}
	}
}
