package p2_������;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class c5_TCP����� {

	public static void main(String[] args) throws IOException {
		//����˽��տͻ��˷��������ݣ�����ӡ�ڿ���̨�ϡ�
		/*
		 * TCP���䣬����˽����Ĺ��̡�
		 * 1.���������Socket����ʹ�õ���ServerSocket����
		 * 2.����˱����ṩһ���˿ڣ�����ͻ����޷����ӡ�
		 * 3.��ȡ���ӹ����Ŀͻ��˶���
		 * 4.ͨ���ͻ��˶����ȡSocket����ȡ�ͻ��˷��������ݣ�����ӡ�ڿ���̨�ϡ�
		 * 5.�ر���Դ���ؿͻ��ˣ��ط���ˡ�
		 */
		
		//��������˶���
		ServerSocket serverSocket = new ServerSocket(10002);
		
		//��ȡ���ӹ����Ŀͻ��˶���
		Socket socket = serverSocket.accept();//����ʽ����
		
		String ip = socket.getInetAddress().getHostAddress();//�ɻ�ȡ�ͷ��˵ĵ�ַ
		
		//ͨ��Socket�����ȡ����������ȡ�ͻ��˷��������ݡ�
		InputStream in = socket.getInputStream();
		
		//��ȡ����������
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		
		String text = new String(buf,0,len);
		
		System.out.println(ip+":"+text);//����
		
		//�ر���Դ
		socket.close();//������ϣ��رտͻ���
		serverSocket.close();//�����һ���ǲ��صģ���Ϊ��Ҫ��ʱ�ṩ��������������ԡ�
	}

}
