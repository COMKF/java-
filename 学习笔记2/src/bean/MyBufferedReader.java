package bean;

import java.io.FileReader;
import java.io.IOException;

/* 自定义的读取缓冲区，模拟一个BufferedReader,从这个例子体会缓冲区的实际原理。
 * 
 * 分析：
 * 缓冲区就是封装了一个数组，并对外提供了更多的方法对数组进行访问，其实这些方法最终操作的都是数组的脚标。
 * 
 * 缓冲的原理：
 * 其实就是从源中获取一批数据装进缓冲区中，在缓冲区中不断的取出一个个数据。
 * 在此次取完后，再从源中读取一批数据到缓冲区中，当源中的数据取完时，用-1作结束标记
 */

public class MyBufferedReader {
	private FileReader fr;
	
	//定义一个数组作为缓冲区
	private char[] buf = new char[1024];
	
	//定义一个指针用来操作这个数组中的元素，当操作到最后一个元素时，指针应该归0
	private int pos = 0;
	
	//定义一个计数器，用于记录缓冲区中的数据个数，当数据减到0时，就从源中获取数据到缓冲区中
	private int count = 0;
	
	public MyBufferedReader(FileReader fr) {
		this.fr = fr;
	}
	
	public int MyRead() throws IOException{
//		//1.从源中获取一批数据到缓冲区中。需要先做判断，只有计数器为0时，才需要从源中获取数据。
//		if (count == 0) {
//			count = fr.read(buf);
//			if(count < 0) return -1;
//			//每次获取数据到缓冲区后，脚标归0
//			pos = 0;
//			char ch = buf[pos];
//			pos++;
//			count--;
//			return ch;
//		}else if (count > 0) {
//			char ch = buf[pos];
//			pos++;
//			count--;
//			return ch;
//		}
//		return 0;
		
		//优化后的代码
		if (count == 0) {
			count = fr.read(buf);
			pos = 0;
		}
		if(count < 0) return -1;
		char ch = buf[pos++];
		count--;
		return ch;
	}
	
	public String MyReadLine() throws IOException{
		StringBuilder sb = new StringBuilder();
		
		int ch = 0;
		while ((ch = MyRead())!= -1) {
			if (ch == '\r') continue;
			if (ch == '\n') return sb.toString();
			//将缓冲区中读到的字符，存储到缓存行数据的缓冲区中
			sb.append((char)ch);
		}
		if (sb.length() != 0) {	//健壮性判断，有时候文件结束时，没有打回车符，那么该文件就是以字符结尾。如果不加这个判断，就会丢失最后一行数据。
			return sb.toString();
		}
		return null;
	}
	
	public void Myclose() throws IOException {
		fr.close();
	}
	
}
