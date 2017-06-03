package p8_IO流3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

/* 打印流：有两个，PrintWriter(字符打印流)和PrintStream(字节打印流)，打印流可直接操作流和文件。
 * PrintStream，为其他输出流添加了功能，使他们能方便的打印各种数据的表示形式(其他流则不能)。它不抛出IO异常。
 * 构造函数：
 * 1.字符串路径
 * 2.File对象
 * 3.字节输出流
 * 
 * 特有方法：
 * 1.void print(int i)	//把数据保持原样，写入到目的地中，保证了数据的表示形式
 * 知识扩充：void write(XX xx)//该方法写入的是一个数据的最低8位，即一个字节，其余的子节会被丢弃。
 */
/* PrintWriter：向文本输出流打印格式化的表示形式。
 * 构造函数：
 * 1.字符串路径
 * 2.File对象
 * 3.字节输出流
 * 4.字符输出流  PrintWriter(OutputStream out, boolean autoFlush)//两个参数，第一个参数是一个输出流，第二个参数决定是否自动刷新
 * 
 * 特有方法：
 * 1. void print(String x) //把数据保持原样，写入到目的地中，保证了数据的表示形式
 */
public class c2_打印流 {

	public static void main(String[] args) throws IOException {
//		PrintStr();
		PrintWri();
	}
	
	private static void PrintStr() throws FileNotFoundException {
		PrintStream out = new PrintStream("print.txt");
		out.write(97);	//将97按ASCII表转码，然后写入，这也是其他流的写入规则
		
		out.write(609);	//可见写入97和609，效果是一样的，因为取得的都是最低8位
		//1.
		out.print(97);	//将97先变成字符串，把数据保持原样，写入到目的地中，这是打印流独有的写入规则
		
		out.close();
	}

	private static void PrintWri() throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(System.out,true);	//若在后面加入第二个参数，true。则每次调用println和format方法时会自动刷新
		String line = null;
		while ((line = bfr.readLine())!=null) {
			if ("over".endsWith(line)) {
				break;
			}
			out.println(line);
//			out.flush();	//每次运行，进行刷新
		}	
		out.close();
		bfr.close();
		
	}
}
