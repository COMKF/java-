package p6_IO流_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* BufferedReader:从字符读取流中读取文本，缓冲各个字符，从而实现字符，数组和行的高效读取，其父类是Reader。
 * 
 * 构造方法：可以创建一个默认大小的缓冲区，也可以自定义大小。而且必须有一个读取流作为参数。
 * 
 * 常用方法：继承流的方法。
 * 1.读取一个文本行  String readLine() //BufferedWriter的特有方法
 */
public class c7_字符读取流缓冲区BufferedReader {

	public static void main(String[] args) throws IOException {
		show();
		show2();
	}

	private static void show() throws IOException {	//通过readLine()方法读取文本文件，读取一行字符
		FileReader fr = new FileReader("buffer_test.txt");
		BufferedReader bffr = new BufferedReader(fr);
		String line = null;
		while ((line = bffr.readLine()) != null) {
			System.out.println(line);	
		}
		bffr.close();
	}

	private static void show2() throws IOException {	//通过read()方法读取文本文件,读取单个字符
		FileReader fr = new FileReader("buffer_test.txt");
		BufferedReader bffr = new BufferedReader(fr);
		//注意，bffr.read()方法是从缓冲区取出字符数据，也就是直接从内存中取，所以比较高效，因此实际上这个read()方法已经覆盖了父类的read()方法。
		int ch;
		while((ch = bffr.read()) != -1){
			System.out.print((char)ch);
		}
		bffr.close();
	}
}
