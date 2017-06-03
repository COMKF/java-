package p2_网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
//Socket：套接字，网络通讯其实就是两个Socket之间的通讯，数据在两个Socket之间传输，Socket本身没有标识，只能和端口号绑定。

//UDP传输协议，需要用到Socket（套接字）和Ppacket（数据包），两者对应的类为DatagramSocket和DatagramPacket。
//DatagramSocket：此类表示用来发送和接收数据报包的套接字。 

public class c2_UDP发送 {

	public static void main(String[] args) throws IOException  {

		System.out.println("发送端启动......");
		/*
		 * 创建UDP传输的发送端。
		 * 思路：
		 * 1，建立udp的socket服务。
		 * 2，将要发送的数据封装到数据包中。 
		 * 3，通过udp的socket服务将数据包发送出去。
		 * 4，关闭socket服务。
		 */
		
		//1,udpsocket服务。使用DatagramSocket对象。
		DatagramSocket ds = new DatagramSocket(5677);
		//发送端Socket可以指定绑定端口号（有参数），也可以随机绑定端口号（无参数）。Socket必须有端口号才能正常工作。
		
		//2,将要发送的数据封装到数据包中。使用DatagramPacket将数据封装到的该对象包中。
		String str = "udp传输演示：哥们来了！";
		byte[] buf = str.getBytes();
		
		DatagramPacket dp = 
				new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.56.1"),10000);
		//这个方法用来创建数据包，有4个参数，第一个参数为数据（必须为字节数组）
		//第二个参数为数据包的长度（这里直接设置为字节数组的长度）
		//第三个参数为目的主机的IP地址，第四个参数为目的进程的端口号
		//第三个和第四个参数指明了数据传输的具体信息，即接收端的Socket需要绑定第四个参数的端口号（10000），才能接收信息
		
		//3，通过udp的socket服务将数据包发送出去。使用send方法。
		ds.send(dp);
		
		//4，关闭资源。
		ds.close();
	}

}
