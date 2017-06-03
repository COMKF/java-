package p7_IO��_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
/* ת�������ַ������ֽ����໥ת���ķ�����
 * �ַ�������>�ֽ���:���룬OutputStreamWriter
 * 
 * �ֽ�������>�ַ���:���룬InputStreamReader
 * 
 * ���  ת��������.bmp
 */
/* ���Ĳ������ɡ�
 * ֮����ҪŪ��������ɣ�����Ϊ������̫�࣬����ʱ��֪�����ĸ�����
 * 
 * ��Ҫ֪������ʱ����Щ����ֻ��Ҫͨ���ĸ���ȷ���ɡ�
 * 1.��ȷԴ��Ŀ��(��)
 * 		Դ�� InputStream  Reader
 * 		Ŀ�ģ�OutputStream  Writer
 * 2.��ȷ�����Ƿ����ı�����
 * 		Դ���Ǵ��ı���Reader����InputStream
 * 		Ŀ�ģ��Ǵ��ı���Writer����OutputStream
 * ������Ϳ�����ȷ����Ҫʹ���ĸ���ϵ��
 * 3.��ȷ������豸
 * 		Դ�豸��Ӳ�̣�File;���̣�System.in;�ڴ棬����;����,Socket��
 * 		Ŀ���豸��Ӳ�̣�File;����̨��System.out;�ڴ棬����;����,Socket��
 * 4.�Ƿ���Ҫ���⹦�ܣ�
 * 		�Ƿ���Ҫ��Ч����������������
 * 		�Ƿ���Ҫת����ת����
 * 		
 */

public class c4_ת���� {

	public static void main(String[] args) throws IOException {	
//		show1();
		show2();
	}
	
	private static void show1() throws IOException {//����һֱ¼���ַ�������ĸ��ɴ�д��ʾ�ڿ���̨�ϣ���over�ͽ���,��ת�����Ż�
		InputStream is = System.in;//��׼���ֽ�������
		
		//���ֽ���ת��Ϊ�ַ�����������ת������
		InputStreamReader isr = new InputStreamReader(is);//��ʱ�Ѿ���ɶ�ȡ���ַ���(������ַ���)
		
		BufferedReader bfr = new BufferedReader(isr);//��Чװ��
		
		
		OutputStream ops = System.out;//��׼���ֽ������
		
		//���ַ���ת��Ϊ���ֽ���������ת������
		OutputStreamWriter osw = new OutputStreamWriter(ops);//��ʱ�Ѿ����������ַ���
		
		BufferedWriter bfw = new BufferedWriter(osw);//��Чװ��
		
		String line = null;
		while((line = bfr.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
//			System.out.println(line.toUpperCase());
			bfw.write(line.toUpperCase());	//���������̨Ҳ��������д
			bfw.newLine();
			bfw.flush();
		}
	}

	private static void show2() throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	//ת������ֱ�Ӽ�д,�ӿ���̨������
		
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));//ת������ֱ�Ӽ�д�����������̨
		//���²���
		String line = null;
		while((line = bfr.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
//			System.out.println(line.toUpperCase());
			bfw.write(line.toUpperCase());	//���������̨Ҳ��������д
			bfw.newLine();
			bfw.flush();
		}
	}
}
