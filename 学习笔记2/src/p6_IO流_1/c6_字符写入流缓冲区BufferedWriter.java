package p6_IO��_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/* BufferedWriter:���ı�д���ַ����������������ַ����Ӷ��ṩ�����ַ���������ַ����ĸ�Чд�룬�丸����Writer��
 * 
 * ���췽�������Դ���һ��Ĭ�ϴ�С�Ļ�������Ҳ�����Զ����С�����ұ�����һ��д������Ϊ������
 * 
 * ���÷������̳����ķ�����
 * 1.����  void newLine()	//BufferedWriter�����з���
 * 
 */
public class c6_�ַ�д����������BufferedWriter {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("buffer_test.txt");
		//Ϊ�����д��Ч�ʣ���ʹ�����ַ�����������
		//����һ���ַ�д�������������󣬲���ָ��Ҫ��������������������
		BufferedWriter bffw = new BufferedWriter(fw);
		//ʹ�û�������д�뷽�����Ƚ�����д�뻺������
		
//		bffw.write("abbcd");
//		bffw.newLine();//BufferedWriter���еķ�����
//		bffw.write("hihi");
		
		for (int i = 1; i <= 4; i++) {
			bffw.write("abbacd"+i);
			bffw.newLine();
		}
		
		//ʹ�û�������ˢ�·�����������д��Ŀ�ĵ���
//		bffw.flush();
		//�رջ�������ʵ�����ǹر�������Ϊ������û�е���ϵͳ�ײ���Դ������ϵͳ�ײ���Դ�������������������þ������Ч�ʶ��ѡ�
		bffw.close();	//close���������һ��flush����
	}
}
