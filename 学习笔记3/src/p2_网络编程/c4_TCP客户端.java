package p2_������;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class c4_TCP�ͻ��� {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//�ͻ��˷����ݵ��������ȥ
		/*
		 * TCP���䣬�ͻ��˽����Ĺ��̡�
		 * 1.����TCP�ͻ���Socket����ʹ�õ���Socket����	����ö���һ��������ȷĿ�ĵأ���Ҫ���ӵ�������
		 * 2.������ӽ����ɹ�����˵�����ݴ���ͨ���ѽ�����
		 * 		��ͨ������Socket�����ǵײ㽨���õģ�Ҳ�ɳ�Ϊ����IO����
		 * 		����ͨ��getOutputStream������getInputStream������ȡ�ֽ���
		 * 3.ʹ���������������д����
		 * 4.�ر���Դ��
		 */
		
		//�����ͷ���Socket����
		Socket socket = new Socket("192.168.56.1",10002);
		
		//��ȡSocket�е������
		OutputStream out = socket.getOutputStream();
		
		//ʹ���������ָ������д��ȥ
		out.write("tcp��ʾ�����������ˣ���".getBytes());
		
		//�ر���Դ
		socket.close();
	}

}
