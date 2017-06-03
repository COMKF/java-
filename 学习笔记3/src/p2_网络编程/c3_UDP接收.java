package p2_网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class c3_UDP接收 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("接收端启动......");
		/*
		 * 建立UDP接收端的思路。
		 * 1，建立udp socket服务,因为是要接收数据，必须要明确一个端口号。
		 * 2，创建数据包，用于存储接收到的数据。方便用数据包对象的方法解析这些数据.
		 * 3，使用socket服务的receive方法将接收的数据存储到数据包中。
		 * 4，通过数据包的方法解析数据包中的数据。
		 * 5，关闭资源 
		 */
		
		//1,建立udp socket服务，并明确接收的端口号
		DatagramSocket ds = new DatagramSocket(10000);//绑定端口号10000，接收所有发到这个端口的信息
		
		
		//2,创建数据包。
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		//这个方法用来创建数据包，有两个参数，第一个是字节数组，第二个参数为数据包的长度
		
		//3,使用接收方法将数据存储到数据包中。
		
		ds.receive(dp);//该方法是阻塞式的。
		
		//4，通过数据包对象的方法，解析其中的数据,比如，地址，端口，数据内容。
		String ip = dp.getAddress().getHostAddress();//数据来源的IP地址
		int port = dp.getPort();//数据来源的端口号
		//此端口号可以和接收端的端口号不一样，解释：可以从A电脑的5000端口发送给B电脑的8000端口，这两台电脑的端口号可以不一样
		
		String text = new String(dp.getData(),0,dp.getLength());//获取数据包中的数据
		
		System.out.println(ip+":"+port+":"+text);
		
		//5,关闭资源。
		ds.close();

	}

}
