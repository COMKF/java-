package ʵ��;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ����_����� {

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
		
		//��ʵ�ķ�������Ӧ����ˣ�һֱ�������ȵ��ͻ����������ݾ�ȥӦ��
		while(true){
			
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
			
			//�����ǽ�������
			//ʹ�ÿͻ���Socket�������������ͷ���������
			OutputStream out = socket.getOutputStream();
			out.write("�յ�����".getBytes());
			
			//�ر���Դ
			socket.close();//������ϣ��رտͻ���
//			serverSocket.close();//�����һ���ǲ��صģ���Ϊ��Ҫ��ʱ�ṩ����
		}
	}

}
