package p6_IO��_1;

import java.io.FileWriter;
import java.io.IOException;

public class c3_�쳣�Ĵ��� {
	public static final String Line_separator = System.getProperty("line.separator");
	public static void main(String[] args) {
		//�ļ��쳣��try��cat�����������
		FileWriter fw = null;	
		try {
			fw = new FileWriter("test.txt");
			fw.write("abcc"+Line_separator+"haha");
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		finally{
			if (fw != null) //��׳���жϣ���������жϵ�ԭ�����¡�
				//��fw = new FileWriter("test.txt");��һ��ʧ��ʱ��fw=null�������fw.close();Ҳ�ᱨ��Ϊ�˱�������������������׳���жϡ�
				try {
					fw.close();	//��Ϊ������Σ�������Ҫ���رգ�����fw.close����finally�С�Ȼ�����fw.close���쳣��Ҫ��������
				} catch (IOException e) {
					throw new RuntimeException("�ر�ʧ��");
				}
		}
	}
}
