package p8_IO流3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
/* 实际情况是：Vector集合效率太低，我们基本上不要用。但是除了这个集合，其他集合已经不支持枚举了，该怎么办？
 * 用ArrayList集合代替，然后可以自定义一个枚举类型。
 */
public class c4_序列流的优化 {
	public static void main(String[] args) throws IOException {
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int i=1;i<=3;i++){
			al.add(new FileInputStream(i+".txt"));
		}
		
		/* 这是自定义Enumeration的实现原理，但这样写太麻烦，可以用已经写好的方法
		//自定义Enumeration
		Iterator<FileInputStream> it = al.iterator();
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {

			@Override
			public boolean hasMoreElements() {
				
				return it.hasNext();	//重写Enumeration的方法，并用Iterator的方法替换
			}

			@Override
			public FileInputStream nextElement() {
				
				return it.next();		//重写Enumeration的方法，并用Iterator的方法替换
			}
		};
		*/
		Enumeration<FileInputStream> en = Collections.enumeration(al);	//这个已经写好的方法，原理就是自定义Enumeration的实现原理
		//将en作为参数传递到序列流SequenceInputStream中
		SequenceInputStream sis = new SequenceInputStream(en);
		//输出流
		FileOutputStream fos = new FileOutputStream("4.txt");
		//创建字节数组，作为序列流SequenceInputStream的read方法的存储区域
		byte[] buf = new byte[1024]; //这里不能用FileOutputStream的专用缓冲区，是因为sis.read方法不能接收它，只能接收字节数组
				
		int len = 0;
		while ((len = sis.read(buf))!=-1) {	//这里要用序列流序列流SequenceInputStream的read方法，且参数必须为byte[]或byte
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
		
	}
	
}
