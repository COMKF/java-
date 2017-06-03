package p6_IO流_1;
//和c7的代码一样，只不过用了自定义的缓冲区，MyBufferedReader。
import java.io.FileReader;
import java.io.IOException;
import bean.MyBufferedReader;

public class c8_使用自定义的缓冲区进行操作 {

	public static void main(String[] args) throws IOException {
		show();
		show2();
	}

	private static void show() throws IOException {	//通过readLine()方法读取文本文件，读取一行字符
		FileReader fr = new FileReader("buffer_test.txt");
		MyBufferedReader bffr = new MyBufferedReader(fr);
		String line = null;
		while ((line = bffr.MyReadLine()) != null) {
			System.out.println(line);
		}
		bffr.Myclose();
	}

	private static void show2() throws IOException {	//通过read()方法读取文本文件,读取单个字符
		FileReader fr = new FileReader("buffer_test.txt");
		MyBufferedReader bffr = new MyBufferedReader(fr);
		//注意，bffr.read()方法是从缓冲区取出字符数据，也就是直接从内存中取，所以比较高效，因此实际上这个read()方法已经覆盖了父类的read()方法。
		int ch;
		while((ch = bffr.MyRead()) != -1){
			System.out.print((char)ch);
		}
		bffr.Myclose();
	}
}
