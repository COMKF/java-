package ʵ��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* ���幦�ܣ���ȡһ�����������Ĵ������������5�Σ�����ʹ�ô����ѵ����ޣ���ע�����ʾ�������������г���
 * 
 * ˼·��
 * 1.��Ҫ����һ��������������ÿ����������Ҫ����һ�Σ�����ԭ�д����Ͻ��м�����
 * 2.�Ѹü���������һ�������ļ�ʹ�á�
 * 
 */
public class ��Properties��������¼������������ {

	public static void main(String[] args) throws IOException {
//		count();
		count2();
		
	}

	private static void count() throws IOException {	//��������һ�ַ���
		//�Ѽ������������ļ���װ�ɶ���
		File f = new File("������.ini");	//ע�⣬Windows�����ļ��ĺ�׺һ��Ϊini����java�������ļ���׺Ϊproperties
		//����Properties����
		Properties pro = new Properties();
		if (!f.exists()) {	//��׳���ж�
			f.createNewFile();
			pro.setProperty("count", "1");	//ֱ�����ֵ
			FileOutputStream fos = new FileOutputStream(f);	//����������ļ���ΪPropertiesд���ļ���׼��
			pro.store(fos,"count");	//д���ļ�
			System.out.println("����������ʹ�ã��㻹������5�Σ�");	//����̨����
			fos.close();
		}
		else {
			FileInputStream fis = new FileInputStream(f);	//��ȡ�������ļ���Ϊ�ļ�д��Properties��׼��
			pro.load(fis);	//д��Properties
			fis.close();
			int value = Integer.parseInt(pro.getProperty("count"));	//ȡ�ó���������������ת��Ϊint�ͱ���
			if (value < 5) {
				value++;	//����
				pro.setProperty("count", String.valueOf(value));	//�޸ĳ�����������
				FileOutputStream fos = new FileOutputStream(f);	//����������ļ���ΪPropertiesд���ļ���׼��
				pro.store(fos,"count");	//д���ļ�
				System.out.println("����ʣ����ô���Ϊ"+(6-value)+"��");	//����̨����
				fos.close();
			}
			else {
				System.out.println("��ע�ᣡ��");	//����̨����
			}
		}
	}
	
	private static void count2() throws IOException {	//�������ڶ��ַ������ô����ڣ���fis��fos��ȡ���������˴��룬�����Ч��
		//�Ѽ������������ļ���װ�ɶ���
		File f = new File("������.ini");	//ע�⣬Windows�����ļ��ĺ�׺һ��Ϊini����java�������ļ���׺Ϊproperties
		//����Properties����
		Properties pro = new Properties();
		if (!f.exists()) {	//��׳���ж�
			f.createNewFile();
		}
		FileInputStream fis = new FileInputStream(f);	//��ȡ�������ļ���Ϊ�ļ�д��Properties��׼��
		pro.load(fis);	//д��Properties
		if (pro.getProperty("count") == null) {
			pro.setProperty("count", "0");	//���ֵ
		}
		int value = Integer.parseInt(pro.getProperty("count"));	//ȡ�ó���������������ת��Ϊint�ͱ���
		if (value >= 5) {
//			System.out.println("��ע�ᣡ��");	//����̨����
//			return;	//return��һ�ְ취�������ǿ�������һ���ǳ������İ취--�׳��쳣
			throw new RuntimeException("ʹ�ô����ѵ�����ע��");
		}else {
			value++;	//����
			pro.setProperty("count", String.valueOf(value));	//�޸ĳ�����������
		}
		
		FileOutputStream fos = new FileOutputStream(f);	//����������ļ���ΪPropertiesд���ļ���׼��
		pro.store(fos,"count");	//д���ļ�
		System.out.println("����ʣ����ô���Ϊ"+(6-value)+"��");	//����̨����
		
		fos.close();
		fis.close();
	}
	
//��47�����Թ����Ժ��ٿ��ɡ���
}
