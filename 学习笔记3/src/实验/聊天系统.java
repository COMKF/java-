package ʵ��;

import java.io.IOException;
import java.net.DatagramSocket;

public class ����ϵͳ {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket send = new DatagramSocket();
		DatagramSocket rece = new DatagramSocket(10001);
		new Thread(new ����ϵͳ���Ͷ�(send)).start();
		new Thread(new ����ϵͳ���ն�(rece)).start();
	}
}
