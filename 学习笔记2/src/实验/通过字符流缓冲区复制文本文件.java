package ʵ��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//����һ���ļ��ĸ���
//Դ�ļ���buffer_test.txt  Ŀ���ļ���buffer_copy.txt
public class ͨ���ַ��������������ı��ļ� {

	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		BufferedWriter bffw = null;
		BufferedReader bffr = null;
		try {
			//1.����buffer_test.txt���ַ���ȡ����buffer_copy.txt�ַ�д����
			fw = new FileWriter("buffer_copy.txt");
			fr = new FileReader("buffer_test.txt");
			//2.ͨ����������������������л���
			bffw = new BufferedWriter(fw);
			bffr = new BufferedReader(fr);
			//3.��ȡbuffer_test.txt�е��ַ�������ȡһ���ַ��ķ���
			String line = null;
			while ((line = bffr.readLine()) != null) {
				//4.��ȡ֮�󣬽��ַ����е��ַ�д��buffer_copy.txt��
				bffw.write(line);
				bffw.newLine();	//ÿ�ζ���һ�У�Ӧ����һ�����ж���
			}
		} catch (IOException e) {
			throw new RuntimeException("��дʧ��");
		}
		//5.�رջ�����
		if (bffr != null)
			try {
				bffr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (bffw != null)
			try {
				bffw.close();
			} catch (IOException e) {
				throw new RuntimeException("�ر�ʧ��");
			}
	}

}
