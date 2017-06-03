package p2_������;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class c3_UDP���� {

	public static void main(String[] args) throws IOException {
		
		System.out.println("���ն�����......");
		/*
		 * ����UDP���ն˵�˼·��
		 * 1������udp socket����,��Ϊ��Ҫ�������ݣ�����Ҫ��ȷһ���˿ںš�
		 * 2���������ݰ������ڴ洢���յ������ݡ����������ݰ�����ķ���������Щ����.
		 * 3��ʹ��socket�����receive���������յ����ݴ洢�����ݰ��С�
		 * 4��ͨ�����ݰ��ķ����������ݰ��е����ݡ�
		 * 5���ر���Դ 
		 */
		
		//1,����udp socket���񣬲���ȷ���յĶ˿ں�
		DatagramSocket ds = new DatagramSocket(10000);//�󶨶˿ں�10000���������з�������˿ڵ���Ϣ
		
		
		//2,�������ݰ���
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		//������������������ݰ�����������������һ�����ֽ����飬�ڶ�������Ϊ���ݰ��ĳ���
		
		//3,ʹ�ý��շ��������ݴ洢�����ݰ��С�
		
		ds.receive(dp);//�÷���������ʽ�ġ�
		
		//4��ͨ�����ݰ�����ķ������������е�����,���磬��ַ���˿ڣ��������ݡ�
		String ip = dp.getAddress().getHostAddress();//������Դ��IP��ַ
		int port = dp.getPort();//������Դ�Ķ˿ں�
		//�˶˿ںſ��Ժͽ��ն˵Ķ˿ںŲ�һ�������ͣ����Դ�A���Ե�5000�˿ڷ��͸�B���Ե�8000�˿ڣ�����̨���ԵĶ˿ںſ��Բ�һ��
		
		String text = new String(dp.getData(),0,dp.getLength());//��ȡ���ݰ��е�����
		
		System.out.println(ip+":"+port+":"+text);
		
		//5,�ر���Դ��
		ds.close();

	}

}
