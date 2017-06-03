package p9_IO流4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 操作基本数据类型：DataOutputStream和DataInputStream。
 * DataOutputStream：数据输出流允许应用程序以适当方式将基本 Java 数据类型写入输出流中。然后，应用程序可以使用数据输入流将数据读入
 * DataInputStream：数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。应用程序可以使用数据输出流写入稍后由数据输入流读取的数据
 */
public class c1_操作基本数据类型 {

	public static void main(String[] args) throws IOException {
		wriData();
		reaData();
	}
	
	private static void wriData() throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		dos.writeUTF("你好");	//写入数据时，会添加一个标头，用来区别UTF-8和UTF修改版
		dos.close();
	}

	private static void reaData() throws IOException{
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		String s = dis.readUTF(dis);	//同时，也只有与之对应的流和方法才能准确读取UTF修改版数据
		System.out.println(s);
	}
}
