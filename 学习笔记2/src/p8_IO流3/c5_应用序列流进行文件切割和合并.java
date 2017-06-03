package p8_IO��3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/* ���������ļ�̫���޷��ϴ�����������и�õ������Ƭ�ļ�
 * �и�ķ�ʽ��
 * 1.����С�У�����涨ÿ���ļ���Ƭ�Ĵ�С����Ϊ1M��
 * 2.�������У���������Դ�ļ���СΪ���٣�������5����
 * 
 * �����ԣ���һ�ŷ������ã���Ϊ�ڶ����޷�������Ƭ��С���п��������Ƭ̫��
 * 
 */

public class c5_Ӧ�������������ļ��и�ͺϲ� {

	private static final int SIZE = 1024*1024;	//SIZEΪ1M

	public static void main(String[] args) throws IOException {
		File f = new File("0.mp3");
		File dir = new File("E:\\eclipseanzhuangbao\\workspace\\ѧϰ�ʼ�2\\�ļ��и���ϲ�"); //ָ����Ƭ�ļ��Ĳ���·��
		QieGe(f,dir);
		HeBing(dir);
	}

	private static void QieGe(File f,File dir) throws IOException {	//�иû��ʹ�õ�������
		//�ö�ȡ������Դ�ļ�
		FileInputStream fis = new FileInputStream(f);
		//����һ���ֽ�������Ϊ��������ȷ����Ƭ�ļ��Ĵ�С������Ҫ�����Ƭ������Ҫ��Ļ���������ѭ��ʵ�֣�
		byte[] buf = new byte[SIZE];
		//����Ŀ��
		FileOutputStream fos = null;
		int len = 0;
		int count = 1;	//ָ����Ƭ�ļ��Ĳ���·��
		if (!dir.exists()) {
			dir.mkdirs();
		}
		while ((len=fis.read(buf))!=-1) {
			fos = new FileOutputStream(new File(dir,(count++)+".part"));	//���ļ�·��+�ļ����ٴη�װ
			fos.write(buf,0,len);
			fos.close();
		}
		fis.close();
	}
	
	private static void HeBing(File dir) throws IOException {	//�ϲ��õ���������
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int i=1;i<=4;i++){
			al.add(new FileInputStream(new File(dir,i+".part")));
		}
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		SequenceInputStream sis = new SequenceInputStream(en);
		
		FileOutputStream fos = new FileOutputStream(new File(dir,"0.mp3"));
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while ((len = sis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}


}
