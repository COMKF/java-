package p7_IO流_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 因为字符流=字节流+编码表，所以实际上字符流已经用默认的编码表进行编码和解码了，这个默认的码表就是系统默认的码表。
 * 但是，如果我们需要指定的码表进行编码呢？
 * 
 * 那就只能用字节流来写，然后人为的指定需要使用的码表。
 * 这里就需要用到转换流的另一个功能————指定码表。
 * 
 * 如果需求中明确了使用指定的码表，就不能使用FileWriter和FileReader，因为FileWriter和FileReader内部使用的是默认的本地码表。
 * 只能使用其父类OutputStreamWriter和InputStreamReader。
 * OutputStreamWriter接收一个字节输出流对象，既然是操作文件，那么该对象就应该是FileOutputStream
 * 代码就是：OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("U8_1.txt"),"UTF-8");
 * 同理：InputStreamReader isr = new InputStreamReader(new FileInputStream("U8_1.txt"),"UTF-8");	
 * 扩展：需要高效吗？
 * BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("U8_1.txt"),"UTF-8"));
 * 同理：BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream("U8_1.txt"),"UTF-8"));
 * 
 * 以上可看出，字节流+编码表=转换流，所以转换流和字符流有时是等价的。
 * 
 * 是么时候使用转换流呢？
 * 1.源或者目的对应的是字节流，但操作的却是文本数据，可以使用转换流作为桥梁，提高对文本的操作速度。
 * 2.一旦文本的操作涉及到具体的指定的编码表时，必须要使用转换流。
 */
public class c6_编码表对字符的影响 {

	public static void main(String[] args) throws IOException {
		writer1();
		writer2();
		writer3();
		writer4();
		reader1();
		reader2();
	}
	private static void writer1() throws IOException {	//使用字符流，即默认的码表进行编码
		FileWriter fw = new FileWriter("gbk_1.txt");	//(1)。简体中文的Windows默认码表是gbk，放在这里也就是字符流使用的码表
		fw.write("你好");
		fw.close();
	}
	private static void writer2() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk_2.txt"));//(2)
		osw.write("你好");
		osw.close();
	}
	private static void writer3() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk_3.txt"),"GBK");//(3)。
		//其实(1)(2)(3)的功能是等同的，FileWriter就是转换流指定了本机默认码表的体现。而且这个转换流的子类对象，可以方便操作文本文件。
		osw.write("你好");
		osw.close();
	}
	private static void writer4() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("U8_1.txt"),"UTF-8");//以指定编码表为参数
		osw.write("你好");
		osw.close();
	}
	private static void reader1() throws IOException {
//		FileReader fr = new FileReader("gbk_1.txt");	//这个可没什么劲，GBK编码，GBK解码
		FileReader fr = new FileReader("U8_1.txt");	//试试这个，就会发现结果是  浣犲ソ ，其实就是乱码。乱码的原因大多就是这样产生的，用了不同的码表
		
		char[] buf = new char[10];
		int len = fr.read(buf);
		String str = new String(buf,0,len);
		System.out.println(str);
		
		fr.close();
	}
	private static void reader2() throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("U8_1.txt"),"UTF-8");	//所以要用对应的码表解析对应的文本文件
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk_1.txt"),"UTF-8");//试试这个，结果是??，说明解析到了未知区域
		
		char[] buf = new char[10];
		int len = isr.read(buf);
		String str = new String(buf,0,len);
		System.out.println(str);
		
		isr.close();
	}
}
