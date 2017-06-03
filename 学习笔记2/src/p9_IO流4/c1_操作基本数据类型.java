package p9_IO��4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* ���������������ͣ�DataOutputStream��DataInputStream��
 * DataOutputStream���������������Ӧ�ó������ʵ���ʽ������ Java ��������д��������С�Ȼ��Ӧ�ó������ʹ�����������������ݶ���
 * DataInputStream����������������Ӧ�ó�����������޹ط�ʽ�ӵײ��������ж�ȡ���� Java �������͡�Ӧ�ó������ʹ�����������д���Ժ���������������ȡ������
 */
public class c1_���������������� {

	public static void main(String[] args) throws IOException {
		wriData();
		reaData();
	}
	
	private static void wriData() throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		dos.writeUTF("���");	//д������ʱ�������һ����ͷ����������UTF-8��UTF�޸İ�
		dos.close();
	}

	private static void reaData() throws IOException{
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		String s = dis.readUTF(dis);	//ͬʱ��Ҳֻ����֮��Ӧ�����ͷ�������׼ȷ��ȡUTF�޸İ�����
		System.out.println(s);
	}
}
