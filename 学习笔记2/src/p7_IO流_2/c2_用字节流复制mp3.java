package p7_IO流_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class c2_用字节流复制mp3 {

	public static void main(String[] args) throws IOException {
//		copy_1();
		copy_2();
//		copy_3();
//		copy_4();
	}

	private static void copy_1() throws IOException {	//建议
		FileInputStream fis = new FileInputStream("G:\\java实验\\0.mp3");	//创建读取流
		FileOutputStream fos = new FileOutputStream("G:\\java实验\\1.mp3");	//创建写入流
		
		byte[] buf = new byte[1024];	//自定义缓冲区
		int len = 0;
		while((len = fis.read(buf)) != -1){
			fos.write(buf,0,len);
		}
		fis.close();
		fos.close();
	}

	private static void copy_2() throws IOException {	//建议
		FileInputStream fis = new FileInputStream("G:\\java实验\\0.mp3");	//创建读取流
		FileOutputStream fos = new FileOutputStream("G:\\java实验\\2.mp3");	//创建写入流
		BufferedInputStream bfis = new BufferedInputStream(fis);	//读取流缓冲区
		BufferedOutputStream bfos = new BufferedOutputStream(fos);	//写入流缓冲区
		
		int ch = 0;
		while((ch = bfis.read()) != -1){	//使用自带的缓冲区，一个个把数据读入缓冲区，然后一次性写入
			bfos.write(ch);
		}
		bfis.close();
		bfos.close();
	}
	
	private static void copy_3() throws IOException {	//不建议用这种方法
		FileInputStream fis = new FileInputStream("G:\\java实验\\0.mp3");	//创建读取流
		FileOutputStream fos = new FileOutputStream("G:\\java实验\\3.mp3");	//创建写入流
		
		byte[] buf = new byte[fis.available()];	//缓冲区直接定义为文件大小
		fis.read(buf);	//把文件读取到缓冲区中
		fos.write(buf);	//把缓冲区中的数据写入目的地
		fis.close();
		fos.close();
	}
	
	private static void copy_4() throws IOException {	//千万不要用！！效率极低！！
		FileInputStream fis = new FileInputStream("G:\\java实验\\0.mp3");	//创建读取流
		FileOutputStream fos = new FileOutputStream("G:\\java实验\\4.mp3");	//创建写入流
		
		int ch = 0;
		while((ch = fis.read()) != -1){	
			fos.write(ch);
		}
		fis.close();
		fos.close();
	}
}
