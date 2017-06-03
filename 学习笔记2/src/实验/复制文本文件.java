package 实验;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//进行一个文件的复制
//源文件：test.txt  目标文件：copy.txt
public class 复制文本文件 {

	public static void main(String[] args) throws IOException {
		copytxt();
	}

	private static void copytxt() {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//1.创建test.txt的字符读取流和copy.txt字符写入流
			fr = new FileReader("test.txt");
			fw = new FileWriter("copy.txt");
			//2.读取test.txt中的字符，按读取字符数组的方法
			char[] buf = new char[3];
			int len = 0;
			while ((len = fr.read(buf)) != -1) {	
				//3.读取之后，将字符数组中的字符写入copy.txt中
				fw.write(buf,0,len);	//磕查看这种方法的详细情况
			}
		} catch (IOException e) {
			throw new RuntimeException("读写失败");
		}
		//4.关闭流
		if (fr != null)
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (fw != null)
			try {
				fw.close();
			} catch (IOException e2) {
//				e.printStackTrace();	//源代码是这个，但是可以修改为下面的内容
				throw new RuntimeException("关闭失败");
			}
	}
}
