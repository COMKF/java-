package bean;

import java.io.IOException;
import java.io.Reader;

//重点是理解其原理。
public class MyBufferedReader_optimize extends Reader{	//实际上BufferedReader，就是Reader的子类，这里让自定义的Buffered也继承Reader

//	private FileReader fr;
	private Reader r;	//这里直接用Reader这个父类来接收，就可以接收一切Reader的子类
	//定义一个数组作为缓冲区
	private char[] buf = new char[1024];
	
	//定义一个指针用来操作这个数组中的元素，当操作到最后一个元素时，指针应该归0
	private int pos = 0;
	
	//定义一个计数器，用于记录缓冲区中的数据个数，当数据减到0时，就从源中获取数据到缓冲区中
	private int count = 0;
	
	public MyBufferedReader_optimize(Reader r) {
		this.r = r;
	}
	
	public int MyRead() throws IOException{
		if (count == 0) {
			count = r.read(buf);
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
		r.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {	//这个功能需要重写父类的功能，在此省略
		
		return 0;
	}

	@Override
	public void close() throws IOException {	//这个功能需要重写父类的功能，在此省略
	}

}
