package p7_IO流_2;

import java.io.File;

import bean.FilterByEndName;
import bean.FilterByHidden;
import bean.FilterByName;
/* 过滤器：Filter
 * 过滤器是接口，有很多种，不同的过滤器有不同的方法，可以实现不同的过滤功能
 * 
 */

public class c8_File类的过滤器 {

	public static void main(String[] args) {
		show1();
		show2();
		show3();
	}


	private static void show1() {
		File f = new File("F:\\");
		String[] names = f.list(new FilterByName());	//获取以.zip结尾的文件
		for(String name : names){
			System.out.println(name);
		}
	}

	private static void show2() {
		File f = new File("F:\\");
		File[] files = f.listFiles(new FilterByHidden());	//获取非隐藏文件
		for(File file : files){
			System.out.println(file);
		}
	}
	
	private static void show3() {
		File f = new File("F:\\");
		String[] names = f.list(new FilterByEndName("pdf"));	//获取以自定义字符串结尾的文件
		for(String name : names){
			System.out.println(name);
		}
	}
}
