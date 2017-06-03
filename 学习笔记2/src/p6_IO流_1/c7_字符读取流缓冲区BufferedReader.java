package p6_IO��_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* BufferedReader:���ַ���ȡ���ж�ȡ�ı�����������ַ����Ӷ�ʵ���ַ���������еĸ�Ч��ȡ���丸����Reader��
 * 
 * ���췽�������Դ���һ��Ĭ�ϴ�С�Ļ�������Ҳ�����Զ����С�����ұ�����һ����ȡ����Ϊ������
 * 
 * ���÷������̳����ķ�����
 * 1.��ȡһ���ı���  String readLine() //BufferedWriter�����з���
 */
public class c7_�ַ���ȡ��������BufferedReader {

	public static void main(String[] args) throws IOException {
		show();
		show2();
	}

	private static void show() throws IOException {	//ͨ��readLine()������ȡ�ı��ļ�����ȡһ���ַ�
		FileReader fr = new FileReader("buffer_test.txt");
		BufferedReader bffr = new BufferedReader(fr);
		String line = null;
		while ((line = bffr.readLine()) != null) {
			System.out.println(line);	
		}
		bffr.close();
	}

	private static void show2() throws IOException {	//ͨ��read()������ȡ�ı��ļ�,��ȡ�����ַ�
		FileReader fr = new FileReader("buffer_test.txt");
		BufferedReader bffr = new BufferedReader(fr);
		//ע�⣬bffr.read()�����Ǵӻ�����ȡ���ַ����ݣ�Ҳ����ֱ�Ӵ��ڴ���ȡ�����ԱȽϸ�Ч�����ʵ�������read()�����Ѿ������˸����read()������
		int ch;
		while((ch = bffr.read()) != -1){
			System.out.print((char)ch);
		}
		bffr.close();
	}
}
