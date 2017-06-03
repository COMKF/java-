package p7_IO��_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* �ֽ����������������ַ�����ͬ������˼����ͬ�������������Բ����ַ��������Բ�������ý���ļ����������֣�ͼƬ����Ӱ��
 * ����ֱ�����ࣺ1.InputStream	2.Outputstream
 */

/* OutputStream:�ֽ�д������Ҳ���ֽ��������
 * ������OutputStream������FileOutputStream����ʾ��
 * FileOutputStream������д���ֽ��ļ����ࡣ
 * 
 * ���췽�������췽��û�пղεģ���˼�Ǵ�������ʱ�ͱ���Ҫ��ȷ���ݵ�Ŀ�ĵء�
 * 
 * ���÷������̳�OutputStream�ķ�����
 * 1.д���ֽ���������  void write(byte b[]) 
 * 2.д��int������  void write(int b)
 * 3.д���ֽ��������ݵ�һ����  void write(byte b[], int off, int len)
 * 4.�ر���   void close()
 */

/* InputStream:�ֽڶ�ȡ����Ҳ���ֽ���������
 * ������InputStream������FileInputStream����ʾ��
 * FileInputStream�����ڶ�ȡ�ֽ��ļ����ࡣ
 * 
 * ���췽�������췽��û�пղεģ���˼�Ǵ�������ʱ�ͱ���Ҫ��ȷ���ݵ�Ŀ�ĵء�
 * 
 * ���÷������̳�InputStream�ķ�����
 * 1.��ȡ�����ֽ�  int read() //����ֵΪint��
 * 2.��ȡ�ֽ�����  int read(byte b[])//����ֵΪint��,�����Ƕ�ȡ���ֽ��������ַ����Ƚϣ������Ƽ�ʹ�����ַ������ж�ȡ
 * 3.��ȡ�ֽ��� int available()	//����ֵΪint��,�����ǻ�ȡ�ļ��Ĵ�С
 * 4.�ر���   void close()
 */
public class c1_�ֽ��� {

	public static void main(String[] args) throws IOException {
//		show1();
		show2();
	}


	private static void show1() throws IOException {	//��ʾ�ֽ�д����
		//1.�����ֽ�д�����������ڲ����ļ�
		FileOutputStream fos = new FileOutputStream("bytetest.txt");
		//2.д���ݣ�ֱ�Ӱ�����д�뵽Ŀ�ĵ��У���ζ�Ų���Ҫflush()��������ʵ�ϣ�FileOutputStreamҲ��û��flush()����������Ҫ
		fos.write("bcdet".getBytes());	//����ֱ��д���ַ��������԰��ַ���ת��Ϊ�ֽ�����Ȼ��д��
		fos.close();
	}
	
	private static void show2() throws IOException {	//��ʾ�ֽڶ�ȡ��
		//1.�����ֽڶ�ȡ�����󣬺�ָ���ļ�����
		FileInputStream fis = new FileInputStream("bytetest.txt");
//		//2.��ȡ�ֽڣ�һ�ζ�һ��
//		int ch = 0;
//		while ((ch = fis.read()) != -1) {
//			System.out.println((char)ch);
//		}
//		//2.��ȡ�ֽڣ��������
//		byte[] buf = new byte[1024];
//		int len = 0;
//		while ((len = fis.read(buf)) != -1) {
//			System.out.println(new String(buf,0,len));
//		}
		//2.��ȡ�ֽڣ������������ֱ�Ӷ�������Ĵ�СΪ�ļ����ֽ���(���ļ��Ĵ�С)
		byte[] buf = new byte[fis.available()];
		fis.read(buf);	//�����ַ�����Ȼ�Ƚϼ򵥣����ǽ������á���Ϊ�������ֻ������С�ļ��������ļ������ַ�����������ڴ������
		//���ַ�������һ���ô��ǣ������Ȼ�ȡ�ļ������ݴ�С��Ȼ���ļ������ݴ�С�ֶζ�ȡ��
		System.out.println(new String(buf));
		fis.close();
	}

}
