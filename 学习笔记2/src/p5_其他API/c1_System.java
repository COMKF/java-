package p5_����API;

import java.util.Properties;
import java.util.Set;

/* System���������ֶΣ�
 * 1.err����׼���������
 * 2.in����׼������
 * 3.out����׼�����
 * 
 * System���еķ��������Զ��Ǿ�̬�ġ�
 * 
 * ���÷�����
 * 1.��ȡ��ǰʱ��ĺ���ֵ  long currentTimeMillis()//���ص�ǰʱ����Э������ʱ֮����ҹ��ʱ���(�Ժ���Ϊ��λ)
 * 2.ȡ�õ�ǰ��ϵͳ����  Properties getProperties()//����ϵͳ���ԣ��洢��Properties�����У�Hashtable�����࣬�̳�Map
 */

public class c1_System {
	public static final String Line_separator = System.getProperty("line.separator");
	//getProperty���������ݼ���ȡһ�����ԣ������ȡ���ǻ���	

	public static void main(String[] args) { 
		//1
		long l1 = 1460303718781l;//System.currentTimeMillis();	//ֱ��д���֣���ֵĬ��Ϊint�ͣ������ֺ��l���Ϳ��Ը�Ϊlong��
		System.out.println(l1);	//��λ�Ǻ���
		System.out.println(l1/1000/60/60/24);//ת��Ϊ��λ����
		long l2 =System.currentTimeMillis();
		System.out.println(l2-l1);//currentTimeMillis()�����Ļ����÷�������ʱ���
		//2��Properties�����д洢�Ķ���String���͵ļ���ֵ�����ʹ�����Լ��Ĵ洢��ȡ���ķ�������ɶ�Ԫ�صĲ�����
		Properties pro = System.getProperties();//��ȡ����ϵͳ����
		Set<String> nameSet = pro.stringPropertyNames();	//stringPropertyNames��������ȡProperties�����еļ�����ŵ�Set������
		System.out.println(1+Line_separator+2);	//����Ч��չʾ
		System.setProperty("mykey", "myvalue");	//setProperty���������Խ��Լ����õļ�ֵ����ӵ�ϵͳ������
		for(String name : nameSet){
			String value = pro.getProperty(name);//getProperty���������ݼ���ȡһ������
//			System.out.println(name+"::::"+value);
		}
	}

}
