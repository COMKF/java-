package p7_IO流_2;

import java.io.IOException;
import java.io.InputStream;

/* 读取一个键盘录入，打印在控制台上。
 * 键盘本身就是一个标准的输入设备，对java而言，对于这种输入设备都有对应的对象。
 * 用标准输入流：System.in，尽量不要关，因为它只会开启一次，除非系统重启，否则不能再次开启。而且它会随系统关闭而关闭，所以该流不需要关闭。
 * 
 */
public class c3_键盘录入 {

	public static void main(String[] args) throws IOException {
//		readKey1();
//		readKey2();
		readKey3();
	}
	
	private static void readKey1() throws IOException {	//键盘录入单个字符
		InputStream is = System.in;	//键盘录入的流对象，需要特殊的对象，它属于System类，这就是标准输入流
		int ch = is.read();	//阻塞式方法，会一直等待键盘录入
		System.out.println(ch);
		int ch1 = is.read();	//阻塞式方法，会一直等待键盘录入
		System.out.println(ch1);
		int ch2 = is.read();	//阻塞式方法，会一直等待键盘录入
		System.out.println(ch2);
		System.out.println((int)'\r');	//Windows下的回车就是\r\n，从这里就可以看出
		System.out.println((int)'\n');
 	}

	private static void readKey2() throws IOException {	//键盘一直录入字符
		InputStream is = System.in;
		int ch = 0;
		while ((ch = is.read())!=-1) {	//正常情况下，这个循环的键盘录入是无法终止的，但是可以人为终止
			System.out.println(ch);
		}
	}
	
	private static void readKey3() throws IOException {	//键盘一直录入字符，将字母变成大写显示在控制台上，遇over就结束
		//1.创建容器，因为需要判断输入是否是over，需要将读取到的字符变成字符串，在用户回车之前将录入的数据变成字符串即可
		StringBuilder sb = new StringBuilder();
		//2.获取键盘读取流
		InputStream is = System.in;
		//3.定义变量记录读取到的字符，并循环获取
		int ch = 0;
		while ((ch = is.read())!=-1) {	
			//4.将读取到的字符存储到容器中
			if (ch == '\r') continue; //针对回车符进行健壮性判断,而且回车符不需要存储
			if (ch == '\n') {
				String temp = sb.toString();
				if ("over".equals(temp)) {
					break;
				}
				System.out.println(temp.toUpperCase());
				sb.delete(0, sb.length());	//清空缓冲区的方法
			}
			else sb.append((char)ch);
		}
	}
}
