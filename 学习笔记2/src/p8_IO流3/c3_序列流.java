package p8_IO��3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/* SequenceInputStream:����������ʾ�������������߼����������������������򼯺Ͽ�ʼ���ӵ�һ����һֱ�������һ������
 * ���Դ������Ҫ�ж���������԰���Щ����װ��һ�������У��ϲ���һ��Դ����ô�����SequenceInputStream�����á�
 * 
 * ���캯����
 * 1. SequenceInputStream(Enumeration<? extends InputStream> e) //������һ������������Ԫ�ص�ö�٣������Ƕ������
 * 2. SequenceInputStream(InputStream s1, InputStream s2)	//������ȷ����������
 * 
 * ���÷�����
 * 1.��ȡ
 * 1.1��ȡ��һ���ַ�  int read()
 * 1.2��ȡ�ֽڵ�������  int read(byte b[])
 */
public class c3_������ {

	public static void main(String[] args) throws IOException {
		//��ʵ����ʾһ�¡��������ı������ݺϲ���
		//��ΪSequenceInputStream�Ĺ��캯��������ö�����ͣ�����������Vector���ϡ�
		//����Vector����
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		//�������������
		v.add(new FileInputStream("1.txt"));
		v.add(new FileInputStream("2.txt"));
		v.add(new FileInputStream("3.txt"));
		//ͨ��ö�ٽ�v�����е�Ԫ��ȡ�������������Ч��Iterator����
		Enumeration<FileInputStream> en = v.elements();
		//��en��Ϊ�������ݵ�������SequenceInputStream��
		SequenceInputStream sis = new SequenceInputStream(en);
		//�����
		FileOutputStream fos = new FileOutputStream("4.txt");
		//�����ֽ����飬��Ϊ������SequenceInputStream��read�����Ĵ洢����
		byte[] buf = new byte[1024];
		
		int len = 0;
		while ((len = sis.read(buf))!=-1) {	//����Ҫ��������������SequenceInputStream��read�������Ҳ�������Ϊbyte[]��byte
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
		
	}

}
