package p2_������;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
//Socket���׽��֣�����ͨѶ��ʵ��������Socket֮���ͨѶ������������Socket֮�䴫�䣬Socket����û�б�ʶ��ֻ�ܺͶ˿ںŰ󶨡�

//UDP����Э�飬��Ҫ�õ�Socket���׽��֣���Ppacket�����ݰ��������߶�Ӧ����ΪDatagramSocket��DatagramPacket��
//DatagramSocket�������ʾ�������ͺͽ������ݱ������׽��֡� 

public class c2_UDP���� {

	public static void main(String[] args) throws IOException  {

		System.out.println("���Ͷ�����......");
		/*
		 * ����UDP����ķ��Ͷˡ�
		 * ˼·��
		 * 1������udp��socket����
		 * 2����Ҫ���͵����ݷ�װ�����ݰ��С� 
		 * 3��ͨ��udp��socket�������ݰ����ͳ�ȥ��
		 * 4���ر�socket����
		 */
		
		//1,udpsocket����ʹ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket(5677);
		//���Ͷ�Socket����ָ���󶨶˿ںţ��в�������Ҳ��������󶨶˿ںţ��޲�������Socket�����ж˿ںŲ�������������
		
		//2,��Ҫ���͵����ݷ�װ�����ݰ��С�ʹ��DatagramPacket�����ݷ�װ���ĸö�����С�
		String str = "udp������ʾ���������ˣ�";
		byte[] buf = str.getBytes();
		
		DatagramPacket dp = 
				new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.56.1"),10000);
		//������������������ݰ�����4����������һ������Ϊ���ݣ�����Ϊ�ֽ����飩
		//�ڶ�������Ϊ���ݰ��ĳ��ȣ�����ֱ������Ϊ�ֽ�����ĳ��ȣ�
		//����������ΪĿ��������IP��ַ�����ĸ�����ΪĿ�Ľ��̵Ķ˿ں�
		//�������͵��ĸ�����ָ�������ݴ���ľ�����Ϣ�������ն˵�Socket��Ҫ�󶨵��ĸ������Ķ˿ںţ�10000�������ܽ�����Ϣ
		
		//3��ͨ��udp��socket�������ݰ����ͳ�ȥ��ʹ��send������
		ds.send(dp);
		
		//4���ر���Դ��
		ds.close();
	}

}
