package p6_IO流_1;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/* LineNumberReader:BufferedReader的子类，跟踪行号的缓冲字符输入流。
 * 
 * 常用方法：
 * 1.获取行号	 int getLineNumber()
 * 2.设置行号  void setLineNumber(int lineNumber)
 * 3.同时还有父类BufferedReader的方法，如read，readLine等。
 */
public class c91_获取行号的缓冲区LineNumberReader {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("buffer_test.txt");
		LineNumberReader lnr = new LineNumberReader(fr);
		
		String line = null;
		lnr.setLineNumber(100);	//设置起始行号，不设置时默认为0
		while ((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber()+":"+line);
		}
		lnr.close();
	}

}
