package p2_网络编程;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class c4_TCP客户端 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//客户端发数据到服务端中去
		/*
		 * TCP传输，客户端建立的过程。
		 * 1.创建TCP客户端Socket服务，使用的是Socket对象。	建议该对象一创建就明确目的地，即要链接的主机。
		 * 2.如果链接建立成功，就说明数据传输通道已建立。
		 * 		该通道就是Socket流，是底层建立好的，也可称为网络IO流。
		 * 		可以通过getOutputStream（）和getInputStream（）获取字节流
		 * 3.使用输出流，将数据写出。
		 * 4.关闭资源。
		 */
		
		//创建客服端Socket服务
		Socket socket = new Socket("192.168.56.1",10002);
		
		//获取Socket中的输出流
		OutputStream out = socket.getOutputStream();
		
		//使用输出流将指定数据写出去
		out.write("tcp演示：哥们又来了！！".getBytes());
		
		//关闭资源
		socket.close();
	}

}
