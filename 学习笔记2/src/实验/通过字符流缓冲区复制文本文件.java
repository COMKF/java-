package 实验;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//进行一个文件的复制
//源文件：buffer_test.txt  目标文件：buffer_copy.txt
public class 通过字符流缓冲区复制文本文件 {

	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		BufferedWriter bffw = null;
		BufferedReader bffr = null;
		try {
			//1.创建buffer_test.txt的字符读取流和buffer_copy.txt字符写入流
			fw = new FileWriter("buffer_copy.txt");
			fr = new FileReader("buffer_test.txt");
			//2.通过缓冲区对两个流对象进行缓冲
			bffw = new BufferedWriter(fw);
			bffr = new BufferedReader(fr);
			//3.读取buffer_test.txt中的字符，按读取一行字符的方法
			String line = null;
			while ((line = bffr.readLine()) != null) {
				//4.读取之后，将字符串中的字符写入buffer_copy.txt中
				bffw.write(line);
				bffw.newLine();	//每次读完一行，应该有一个换行动作
			}
		} catch (IOException e) {
			throw new RuntimeException("读写失败");
		}
		//5.关闭缓冲区
		if (bffr != null)
			try {
				bffr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (bffw != null)
			try {
				bffw.close();
			} catch (IOException e) {
				throw new RuntimeException("关闭失败");
			}
	}

}
