package p6_IO流_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/* BufferedWriter:将文本写入字符输出流，缓冲各个字符，从而提供单个字符，数组和字符串的高效写入，其父类是Writer。
 * 
 * 构造方法：可以创建一个默认大小的缓冲区，也可以自定义大小。而且必须有一个写入流作为参数。
 * 
 * 常用方法：继承流的方法。
 * 1.换行  void newLine()	//BufferedWriter的特有方法
 * 
 */
public class c6_字符写入流缓冲区BufferedWriter {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("buffer_test.txt");
		//为了提高写入效率，就使用了字符流缓冲区。
		//创建一个字符写入流缓冲区对象，并和指定要被缓冲的流对象相关联。
		BufferedWriter bffw = new BufferedWriter(fw);
		//使用缓冲区的写入方法，先将数据写入缓冲区中
		
//		bffw.write("abbcd");
//		bffw.newLine();//BufferedWriter独有的方法。
//		bffw.write("hihi");
		
		for (int i = 1; i <= 4; i++) {
			bffw.write("abbacd"+i);
			bffw.newLine();
		}
		
		//使用缓冲区的刷新方法，将数据写入目的地中
//		bffw.flush();
		//关闭缓冲区，实质上是关闭流，因为缓冲区没有调用系统底层资源，调用系统底层资源的是流。缓冲区的作用就是提高效率而已。
		bffw.close();	//close方法会调用一次flush方法
	}
}
