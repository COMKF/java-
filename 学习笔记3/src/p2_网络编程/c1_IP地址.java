package p2_������;

import java.io.IOException;
import java.net.InetAddress;

public class c1_IP��ַ {

	public static void main(String[] args) throws IOException {
		//��ȡ��������IP��ַ����
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println(ip.getHostAddress());//��ȡ��������IP��ַ
		System.out.println(ip.getHostName());//��ȡ����������
		
		//��ȡ����������IP��ַ����
		ip = InetAddress.getByName("192.168.56.1");
		ip = InetAddress.getByName("mk-PC");//�����ֻ�ȡIP��ַ�ķ�ʽ��������һ���ģ���ΪIP��ַ���Ժ����������Ӧ
		
		//IP��ַ�����������Ӧ����ʵ����һ�����̵�--�����������������������������ҵ�IP��ַ��
		//1.���ȷ��ʱ����Ľ����ļ������������б��������û��ƥ��ļ�ֵ��
		//2.û�еĻ�������DNS����������DNS�ϣ�ͨ�����������б��ҵ����Ӧ�ļ�ֵ��
		//3.�������ʾ��ַ����
		
		System.out.println(ip.getHostAddress());//��ȡ��������IP��ַ
		System.out.println(ip.getHostName());//��ȡ����������
		
	}

}
