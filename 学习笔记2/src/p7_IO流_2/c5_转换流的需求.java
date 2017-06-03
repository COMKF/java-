package p7_IO流_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class c5_转换流的需求 {

	public static void main(String[] args) throws IOException {
		show1();//将键盘录入的数据写到一个文件中
		show2();//将一个文本文件内容显示在控制台上
		show3();//将一个文本文件中的内容复制到另一个文本文件中
	}

	private static void show1() throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	
		
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt")));
		InandOut(bfr, bfw);
		bfr.close();
		bfw.close();
	}


	private static void show2() throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));	
		
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		InandOut(bfr, bfw);
		bfr.close();
		bfw.close();
	}

	private static void show3() throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));
		
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));
		InandOut(bfr, bfw);
		bfr.close();
		bfw.close();
	}
	
	private static void InandOut(BufferedReader bfr, BufferedWriter bfw) throws IOException {
		String line = null;
		while((line = bfr.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
			bfw.write(line.toUpperCase());
			bfw.newLine();
			bfw.flush();
		}
	}
}
