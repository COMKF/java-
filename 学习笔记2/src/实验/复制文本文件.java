package ʵ��;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//����һ���ļ��ĸ���
//Դ�ļ���test.txt  Ŀ���ļ���copy.txt
public class �����ı��ļ� {

	public static void main(String[] args) throws IOException {
		copytxt();
	}

	private static void copytxt() {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//1.����test.txt���ַ���ȡ����copy.txt�ַ�д����
			fr = new FileReader("test.txt");
			fw = new FileWriter("copy.txt");
			//2.��ȡtest.txt�е��ַ�������ȡ�ַ�����ķ���
			char[] buf = new char[3];
			int len = 0;
			while ((len = fr.read(buf)) != -1) {	
				//3.��ȡ֮�󣬽��ַ������е��ַ�д��copy.txt��
				fw.write(buf,0,len);	//�Ĳ鿴���ַ�������ϸ���
			}
		} catch (IOException e) {
			throw new RuntimeException("��дʧ��");
		}
		//4.�ر���
		if (fr != null)
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (fw != null)
			try {
				fw.close();
			} catch (IOException e2) {
//				e.printStackTrace();	//Դ��������������ǿ����޸�Ϊ���������
				throw new RuntimeException("�ر�ʧ��");
			}
	}
}
