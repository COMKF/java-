package p2_网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class c5_TCP服务端 {

	public static void main(String[] args) throws IOException {
		//服务端接收客户端发来的数据，并打印在控制台上。
		/*
		 * TCP传输，服务端建立的过程。
		 * 1.创建服务端Socket服务，使用的是ServerSocket对象。
		 * 2.服务端必须提供一个端口，否则客户端无法连接。
		 * 3.获取连接过来的客户端对象。
		 * 4.通过客户端对象获取Socket流读取客户端发来的数据，并打印在控制台上。
		 * 5.关闭资源。关客户端，关服务端。
		 */
		
		//创建服务端对象。
		ServerSocket serverSocket = new ServerSocket(10002);
		
		//获取连接过来的客户端对象。
		Socket socket = serverSocket.accept();//阻塞式方法
		
		String ip = socket.getInetAddress().getHostAddress();//可获取客服端的地址
		
		//通过Socket对象获取输入流，读取客户端发来的数据。
		InputStream in = socket.getInputStream();
		
		//获取发来的数据
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		
		String text = new String(buf,0,len);
		
		System.out.println(ip+":"+text);//操作
		
		//关闭资源
		socket.close();//操作完毕，关闭客户端
		serverSocket.close();//服务端一般是不关的，因为需要随时提供服务。这里仅作测试。
	}

}
