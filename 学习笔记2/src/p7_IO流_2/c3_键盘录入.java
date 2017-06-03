package p7_IO��_2;

import java.io.IOException;
import java.io.InputStream;

/* ��ȡһ������¼�룬��ӡ�ڿ���̨�ϡ�
 * ���̱������һ����׼�������豸����java���ԣ��������������豸���ж�Ӧ�Ķ���
 * �ñ�׼��������System.in��������Ҫ�أ���Ϊ��ֻ�Ὺ��һ�Σ�����ϵͳ�������������ٴο���������������ϵͳ�رն��رգ����Ը�������Ҫ�رա�
 * 
 */
public class c3_����¼�� {

	public static void main(String[] args) throws IOException {
//		readKey1();
//		readKey2();
		readKey3();
	}
	
	private static void readKey1() throws IOException {	//����¼�뵥���ַ�
		InputStream is = System.in;	//����¼�����������Ҫ����Ķ���������System�࣬����Ǳ�׼������
		int ch = is.read();	//����ʽ��������һֱ�ȴ�����¼��
		System.out.println(ch);
		int ch1 = is.read();	//����ʽ��������һֱ�ȴ�����¼��
		System.out.println(ch1);
		int ch2 = is.read();	//����ʽ��������һֱ�ȴ�����¼��
		System.out.println(ch2);
		System.out.println((int)'\r');	//Windows�µĻس�����\r\n��������Ϳ��Կ���
		System.out.println((int)'\n');
 	}

	private static void readKey2() throws IOException {	//����һֱ¼���ַ�
		InputStream is = System.in;
		int ch = 0;
		while ((ch = is.read())!=-1) {	//��������£����ѭ���ļ���¼�����޷���ֹ�ģ����ǿ�����Ϊ��ֹ
			System.out.println(ch);
		}
	}
	
	private static void readKey3() throws IOException {	//����һֱ¼���ַ�������ĸ��ɴ�д��ʾ�ڿ���̨�ϣ���over�ͽ���
		//1.������������Ϊ��Ҫ�ж������Ƿ���over����Ҫ����ȡ�����ַ�����ַ��������û��س�֮ǰ��¼������ݱ���ַ�������
		StringBuilder sb = new StringBuilder();
		//2.��ȡ���̶�ȡ��
		InputStream is = System.in;
		//3.���������¼��ȡ�����ַ�����ѭ����ȡ
		int ch = 0;
		while ((ch = is.read())!=-1) {	
			//4.����ȡ�����ַ��洢��������
			if (ch == '\r') continue; //��Իس������н�׳���ж�,���һس�������Ҫ�洢
			if (ch == '\n') {
				String temp = sb.toString();
				if ("over".equals(temp)) {
					break;
				}
				System.out.println(temp.toUpperCase());
				sb.delete(0, sb.length());	//��ջ������ķ���
			}
			else sb.append((char)ch);
		}
	}
}
