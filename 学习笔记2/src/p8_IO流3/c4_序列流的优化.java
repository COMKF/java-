package p8_IO��3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
/* ʵ������ǣ�Vector����Ч��̫�ͣ����ǻ����ϲ�Ҫ�á����ǳ���������ϣ����������Ѿ���֧��ö���ˣ�����ô�죿
 * ��ArrayList���ϴ��棬Ȼ������Զ���һ��ö�����͡�
 */
public class c4_���������Ż� {
	public static void main(String[] args) throws IOException {
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int i=1;i<=3;i++){
			al.add(new FileInputStream(i+".txt"));
		}
		
		/* �����Զ���Enumeration��ʵ��ԭ��������д̫�鷳���������Ѿ�д�õķ���
		//�Զ���Enumeration
		Iterator<FileInputStream> it = al.iterator();
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {

			@Override
			public boolean hasMoreElements() {
				
				return it.hasNext();	//��дEnumeration�ķ���������Iterator�ķ����滻
			}

			@Override
			public FileInputStream nextElement() {
				
				return it.next();		//��дEnumeration�ķ���������Iterator�ķ����滻
			}
		};
		*/
		Enumeration<FileInputStream> en = Collections.enumeration(al);	//����Ѿ�д�õķ�����ԭ������Զ���Enumeration��ʵ��ԭ��
		//��en��Ϊ�������ݵ�������SequenceInputStream��
		SequenceInputStream sis = new SequenceInputStream(en);
		//�����
		FileOutputStream fos = new FileOutputStream("4.txt");
		//�����ֽ����飬��Ϊ������SequenceInputStream��read�����Ĵ洢����
		byte[] buf = new byte[1024]; //���ﲻ����FileOutputStream��ר�û�����������Ϊsis.read�������ܽ�������ֻ�ܽ����ֽ�����
				
		int len = 0;
		while ((len = sis.read(buf))!=-1) {	//����Ҫ��������������SequenceInputStream��read�������Ҳ�������Ϊbyte[]��byte
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
		
	}
	
}
