package p7_IO��_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class c2_���ֽ�������mp3 {

	public static void main(String[] args) throws IOException {
//		copy_1();
		copy_2();
//		copy_3();
//		copy_4();
	}

	private static void copy_1() throws IOException {	//����
		FileInputStream fis = new FileInputStream("G:\\javaʵ��\\0.mp3");	//������ȡ��
		FileOutputStream fos = new FileOutputStream("G:\\javaʵ��\\1.mp3");	//����д����
		
		byte[] buf = new byte[1024];	//�Զ��建����
		int len = 0;
		while((len = fis.read(buf)) != -1){
			fos.write(buf,0,len);
		}
		fis.close();
		fos.close();
	}

	private static void copy_2() throws IOException {	//����
		FileInputStream fis = new FileInputStream("G:\\javaʵ��\\0.mp3");	//������ȡ��
		FileOutputStream fos = new FileOutputStream("G:\\javaʵ��\\2.mp3");	//����д����
		BufferedInputStream bfis = new BufferedInputStream(fis);	//��ȡ��������
		BufferedOutputStream bfos = new BufferedOutputStream(fos);	//д����������
		
		int ch = 0;
		while((ch = bfis.read()) != -1){	//ʹ���Դ��Ļ�������һ���������ݶ��뻺������Ȼ��һ����д��
			bfos.write(ch);
		}
		bfis.close();
		bfos.close();
	}
	
	private static void copy_3() throws IOException {	//�����������ַ���
		FileInputStream fis = new FileInputStream("G:\\javaʵ��\\0.mp3");	//������ȡ��
		FileOutputStream fos = new FileOutputStream("G:\\javaʵ��\\3.mp3");	//����д����
		
		byte[] buf = new byte[fis.available()];	//������ֱ�Ӷ���Ϊ�ļ���С
		fis.read(buf);	//���ļ���ȡ����������
		fos.write(buf);	//�ѻ������е�����д��Ŀ�ĵ�
		fis.close();
		fos.close();
	}
	
	private static void copy_4() throws IOException {	//ǧ��Ҫ�ã���Ч�ʼ��ͣ���
		FileInputStream fis = new FileInputStream("G:\\javaʵ��\\0.mp3");	//������ȡ��
		FileOutputStream fos = new FileOutputStream("G:\\javaʵ��\\4.mp3");	//����д����
		
		int ch = 0;
		while((ch = fis.read()) != -1){	
			fos.write(ch);
		}
		fis.close();
		fos.close();
	}
}
