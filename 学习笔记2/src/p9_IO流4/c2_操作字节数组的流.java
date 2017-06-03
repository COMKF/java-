package p9_IO��4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* �����ֽ��������:ByteArrayInputStream��ByteArrayOutputStream��
 * �����������Դ��Ŀ�Ķ����ڴ棬��չ�����в���������������ǵ�Դ��Ŀ�Ķ����ڴ档
 * ByteArrayInputStream������һ���ڲ����������û��������������ж�ȡ���ֽڡ��ڲ����������� read ����Ҫ�ṩ����һ���ֽڡ� 
 * ByteArrayOutputStream��ʵ����һ������������е����ݱ�д��һ�� byte ���顣���������������ݵĲ���д����Զ�������
 * �����������������ǵĹرշ�������Ч�ģ���Ϊ���ǲ��������ڴ棬û�е��õײ���Դ�����еķ����ڹرմ������Կɱ����á�
 * 
 * ������������Դ���ڴ棬��ByteArrayInputStream�����Ŀ�����ڴ棬��ByteArrayOutputStream��
 * 
 * ������ֽ�������������ƵĻ��У������ַ���������������ַ���������
 */
public class c2_�����ֽ�������� {

	public static void main(String[] args) {
		ByteArrayInputStream bais = new ByteArrayInputStream("abcdefg".getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int ch = 0;
		while ((ch=bais.read())!=-1) {
			baos.write(ch);
		}
		System.out.println(baos.toString());
	}

}
