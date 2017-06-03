package p2_网络编程;

import java.io.IOException;
import java.net.InetAddress;

public class c1_IP地址 {

	public static void main(String[] args) throws IOException {
		//获取本地主机IP地址对象
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println(ip.getHostAddress());//获取本机主机IP地址
		System.out.println(ip.getHostName());//获取本机主机名
		
		//获取其他主机的IP地址对象
		ip = InetAddress.getByName("192.168.56.1");
		ip = InetAddress.getByName("mk-PC");//这两种获取IP地址的方式本质上是一样的，因为IP地址可以和主机名相对应
		
		//IP地址与主机名相对应，其实是有一个过程的--域名解析（根据主机名或者域名找到IP地址）
		//1.首先访问本机的解析文件（域名解析列表），检查有没有匹配的键值对
		//2.没有的话，访问DNS服务器，在DNS上（通过域名解析列表）找到相对应的键值对
		//3.否则会显示地址错误
		
		System.out.println(ip.getHostAddress());//获取本机主机IP地址
		System.out.println(ip.getHostName());//获取本机主机名
		
	}

}
