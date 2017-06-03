package p6_IO��_1;

import java.io.FileReader;
import java.io.IOException;

/* Reader:�ַ���ȡ��,Ҳ���ַ���������
 * ������Reader������FileReader����ʾ��
 * FileReader�����ڶ�ȡ�ַ��ļ��ı���ࡣ
 * 
 * ���췽�������췽��û�пղεģ���˼�Ǵ�������ʱ�ͱ���Ҫ��ȷ���ݵ���Դ��
 * 
 * ���÷������̳�Reader�ķ�����
 * 1.��ȡ�����ַ�  int read() //����ֵΪint�ͣ���Ϊ�����ڼ�����еĴ洢��ʽ�Ƕ�����
 * 2.��ȡ�ַ�����  int read(char cbuf[])//�Ѷ����������ַ��洢���ַ������У�����ֵΪint�ͣ������Ƕ�ȡ�����ַ��ĸ���
 * 3.�ر������ͷ���֮��ص�������Դ  void close()
 */
public class c4_�ַ���ȡ��Reader {

	public static void main(String[] args) throws IOException {
//		show1();
		show2();
	}

	private static void show1() throws IOException {	//1����ȡ�����ַ�
		/* �����ַ���ȡ������
		 * 
		 * �ڴ�����ȡ������ʱ������Ҫ��ȷ����ȡ���ļ���һ��Ҫȷ�����ļ��Ǵ��ڵġ�
		 * ��һ����ȡ������һ���Ѵ��ڵ��ļ���
		 */
		FileReader fr = new FileReader("test.txt");	//�����ַ���ȡ������ʱ����Ҫ�׳��쳣�����쳣��IOException
		
		//��Reader�е�read()������ȡ�ı��ļ���
		
//		int ch1 = fr.read();
//		System.out.println((char)ch1);	//���ֱ������Ļ����������ASCII�룬������(char)ǿת
//		int ch2 = fr.read();
//		System.out.println(ch2);
//		fr.close();
		
		int ch = 0;	//1����ȡ�����ַ���д��
		while ((ch = fr.read())!= -1) {	//����ﵽ�ı���ĩβ���򷵻�-1������ͨ������ж��Ƿ���ļ���ȡ���
			System.out.println((char)ch);
		}
		fr.close();
	}
	
	private static void show2() throws IOException {	//2����ȡ�ַ�����
		FileReader fr = new FileReader("test.txt");
		//��Reader�е�read(char [])������ȡ�ı��ļ���
		
		//�ȴ����ַ�����
		char[] buf = new char[3];	//�����ʵҲ���ǻ����������Զ���Ļ������������ڽ�������Ҫѧϰ�����ѱ���װ�Ļ��������ж��صĹ��ܡ�
		
//		int num = fr.read(buf); //���������ַ��洢���ַ�������
//		System.out.println(num+":"+new String(buf));
//		fr.close();
		
		int len = 0;	//2����ȡ�ַ������д��
		while ((len = fr.read(buf)) != -1) {	//����ﵽ�ı���ĩβ�����ȡ�����ַ��ĸ���Ϊ-1������ͨ������ж��Ƿ���ļ���ȡ���
			System.out.println(len+":"+new String(buf,0,len));	//�����ַ����Ĺ��췽������p8��c1�������
		}
		fr.close();
	}
}
