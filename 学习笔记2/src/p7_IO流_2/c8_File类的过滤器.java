package p7_IO��_2;

import java.io.File;

import bean.FilterByEndName;
import bean.FilterByHidden;
import bean.FilterByName;
/* ��������Filter
 * �������ǽӿڣ��кܶ��֣���ͬ�Ĺ������в�ͬ�ķ���������ʵ�ֲ�ͬ�Ĺ��˹���
 * 
 */

public class c8_File��Ĺ����� {

	public static void main(String[] args) {
		show1();
		show2();
		show3();
	}


	private static void show1() {
		File f = new File("F:\\");
		String[] names = f.list(new FilterByName());	//��ȡ��.zip��β���ļ�
		for(String name : names){
			System.out.println(name);
		}
	}

	private static void show2() {
		File f = new File("F:\\");
		File[] files = f.listFiles(new FilterByHidden());	//��ȡ�������ļ�
		for(File file : files){
			System.out.println(file);
		}
	}
	
	private static void show3() {
		File f = new File("F:\\");
		String[] names = f.list(new FilterByEndName("pdf"));	//��ȡ���Զ����ַ�����β���ļ�
		for(String name : names){
			System.out.println(name);
		}
	}
}
