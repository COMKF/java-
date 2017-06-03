package p8_IO��3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

import bean.FilterByEndName;

/* ��ʵ�ϣ�֮ǰ���и���ϲ���������ġ�
 * 1.��׳�Ե��жϣ����ﲻ�������������Լ����ԡ�
 * 2.����֪���ж�����Ƭ��
 * 3.����֪��Դ�ļ������ƺͺ�׺����
 * 
 * ��ν����
 * �������и��ʱ�򣬽������Ϣ��¼�����������´�ʹ�á�
 * �����������������ǿ����������ļ���¼��Щ�����Ϣ����Properties�ࡣ
 * ���ԣ��и�ʱ����������ļ����ϲ�ʱ���������ļ������֡�
 */
public class c6_�ļ��и���ϲ����Ż� {

	private static final int SIZE = 1024*1024;
	
	public static void main(String[] args) throws IOException {
		File f = new File("0.mp3");
		File dir = new File("E:\\eclipseanzhuangbao\\workspace\\ѧϰ�ʼ�2\\�ļ��и���ϲ�"); //ָ����Ƭ�ļ��Ĳ���·��
//		QieGe(f,dir);
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
		Properties pro = new Properties();
		pro.setProperty("partcount", count+"");
		pro.setProperty("filename", f.getName());
		fos = new FileOutputStream(new File(dir,count+".properties"));
		pro.store(fos, "");
		fos.close();
		fis.close();
	}
	

	private static void HeBing(File dir) throws IOException {
		File[] fs = dir.listFiles(new FilterByEndName(".properties"));
		
		if (fs.length!=1) {
			throw new RuntimeException("��Ŀ¼��û�������ļ����������ļ���Ψһ����");
		}
		//ȡ�������ļ����洢��config��
		File config = fs[0];
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(config);
		pro.load(fis);
		String filename = pro.getProperty("filename");
		int count = Integer.parseInt(pro.getProperty("partcount"));
		//��ȡĿ¼�µ�������Ƭ�ļ�
		File[] parefiles = dir.listFiles(new FilterByEndName(".part"));
		
		if(parefiles.length!=(count-1)){
			throw new RuntimeException("��Ƭ�ļ��������ԣ���"+"Ӧ��Ϊ"+count+"��");
		}
		//����Ƭ�ļ�����������������洢��������
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for (int i = 1; i < count; i++) {
			al.add(new FileInputStream(parefiles[i-1]));
		}
		//��������ϲ���һ��������
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		SequenceInputStream sis = new SequenceInputStream(en);
		
		FileOutputStream fos = new FileOutputStream(new File(dir,filename));	//�������ļ��е�filenameȡ������Ϊ�ϳ��ļ�������
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while ((len = sis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}
}
