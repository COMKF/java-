package 实验;

import java.io.IOException;
import java.net.DatagramSocket;

public class 聊天系统 {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket send = new DatagramSocket();
		DatagramSocket rece = new DatagramSocket(10001);
		new Thread(new 聊天系统发送端(send)).start();
		new Thread(new 聊天系统接收端(rece)).start();
	}
}
